package ge.edu.freeuni.sdp.xo.achiev;
import ge.edu.freeuni.sdp.xo.achiev.data.AchievEntity;
import ge.edu.freeuni.sdp.xo.achiev.data.Repository;
import ge.edu.freeuni.sdp.xo.achiev.data.RepositoryFactory;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.microsoft.azure.storage.StorageException;

@Path("/{id}")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AchievService {
	
	public Repository getRepository() throws StorageException {
		return RepositoryFactory.create();
	}

	@PUT
	public Response changeScore(@PathParam("id") String id, @Valid Score score){
		final AchievEntity achievEntity = new AchievEntity(id, score.score);
		try {
			getRepository().insertOrUpdate(achievEntity);
			return Response.status(Status.OK).build();
		} catch (StorageException e) {
			System.out.println("EXCEPTION");
			throw new MyCustomException("internal server error", Response.Status.INTERNAL_SERVER_ERROR, 1); 
		}
	}
	
	@GET
	public UserAchievment getUserAchievment(@PathParam("id") String id) {
		UserAchievment achievement = new UserAchievment();
		try {
			AchievEntity achiev = getRepository().get(id);
			achievement.score = achiev.getScore();
			achievement.rank = Integer.parseInt(achiev.getPartitionKey());
			return achievement;
		} catch (Exception e) {
			System.out.println("EXCEPTION");
			throw new MyCustomException("internal server error", Response.Status.INTERNAL_SERVER_ERROR, 1); 
		}
	}
}
