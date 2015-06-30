package ge.edu.freeuni.sdp.xo.achiev.data;

import com.microsoft.azure.storage.StorageException;

public interface Repository {

	public void insertOrUpdate(AchievEntity achiev) throws StorageException;
}
