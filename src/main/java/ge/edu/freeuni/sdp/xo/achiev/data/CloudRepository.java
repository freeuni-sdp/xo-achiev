package ge.edu.freeuni.sdp.xo.achiev.data;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.TableOperation;

public class CloudRepository implements Repository{
	
	private CloudTable table;

	public CloudRepository(CloudTable table) {
		this.table = table;
	}

	@Override
	public void insertOrUpdate(AchievEntity achiev) throws StorageException {
		TableOperation operation = TableOperation.insertOrReplace(achiev);
		table.execute(operation);
	}

}
