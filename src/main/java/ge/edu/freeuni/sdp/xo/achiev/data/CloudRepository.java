package ge.edu.freeuni.sdp.xo.achiev.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import jersey.repackaged.com.google.common.collect.Lists;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.TableOperation;
import com.microsoft.azure.storage.table.TableQuery;
import com.microsoft.azure.storage.table.TableQuery.QueryComparisons;

public class CloudRepository implements Repository {

	private CloudTable table;

	final String PARTITION_KEY = "PartitionKey";
	final static String PARTITION = AchievEntity.PARTITION;

	public CloudRepository(CloudTable table) {
		this.table = table;
	}

	@Override
	public void insertOrUpdate(AchievEntity achiev) throws StorageException {
		TableOperation operation = TableOperation.insertOrReplace(achiev);
		table.execute(operation);
	}

	@Override
	public AchievEntity get(String id) throws Exception {
		AchievEntity toGet = new AchievEntity(id, 0);

		TableOperation query = TableOperation.retrieve(toGet.getPartitionKey(),
				toGet.getRowKey(), AchievEntity.class);
		toGet = table.execute(query).getResultAsType();
		
		String partitionFilter = TableQuery.generateFilterCondition(
				PARTITION_KEY, QueryComparisons.EQUAL, PARTITION);

		TableQuery<AchievEntity> partitionQuery = TableQuery.from(
				AchievEntity.class).where(partitionFilter);

		Iterable<AchievEntity> wholeTable = table.execute(partitionQuery);
		ArrayList<AchievEntity> wholeTableList = Lists.newArrayList(wholeTable
				.iterator());
		Collections.sort(wholeTableList, new Comparator<AchievEntity>() {
			@Override
			public int compare(AchievEntity o1, AchievEntity o2) {
				return Integer.compare(o1.getScore(), o2.getScore());
			}
		});
		toGet.setRank(wholeTableList.indexOf(toGet)+1);
		return toGet;
	}

}
