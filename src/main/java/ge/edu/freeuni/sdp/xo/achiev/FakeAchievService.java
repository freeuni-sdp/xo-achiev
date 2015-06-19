package ge.edu.freeuni.sdp.xo.achiev;

import javax.validation.constraints.*;
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
import javax.ws.rs.WebApplicationException;


@Path("/{id}")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class FakeAchievService {
	private static FakeDB db = new FakeDB();

	@PUT
	public Response changeScore(@PathParam("id") int id, @Valid Score score){
		boolean isChangedDB = db.changeScore(id, score.score);
		if (isChangedDB)
			return Response.status(Status.OK).build();

		throw new MyCustomException("can't find user with id", Response.Status.NOT_FOUND, 1); // last param can be removed
	}

	@GET
	public UserAchievment getUserAchievment(@PathParam("id") int id) {
		UserAchievment userAchievment = db.getUserAchievment(id);
		if (userAchievment == null)
			throw new MyCustomException("can't find user with id", Response.Status.NOT_FOUND, 1);
		return userAchievment;
	}
}
