import static org.junit.Assert.assertEquals;
import ge.edu.freeuni.sdp.xo.achiev.FakeAchievService;
import ge.edu.freeuni.sdp.xo.achiev.Score;
import ge.edu.freeuni.sdp.xo.achiev.UserAchievment;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;


public class TestFakeAchieve extends JerseyTest{
	
	@Override
	protected Application configure() {
		return new ResourceConfig(FakeAchievService.class);
	}
	
	@Test
	public void testChangeInvalid() {
		Score score = new Score();
		score.score = -10;
		Response actual = target("/100").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(),actual.getStatus());
		
		
		score = new Score();
		score.score = 0;
		actual = target("/0").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(),actual.getStatus());
		
		score = new Score();
		score.score = 110;
		actual = target("/5").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(),actual.getStatus());
	}
	
	
	@Test
	public void testChangeValidSet() {
		Score score = new Score();
		score.score = 1;
		Response actual = target("/100").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		
		score.score = 2;
		actual = target("/101").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		
		score.score = 3;
		actual = target("/102").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		
		score.score = 4;
		actual = target("/103").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		
		score.score = 5;
		actual = target("/104").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		
		score.score = 6;
		actual = target("/105").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		
		score.score = 7;
		actual = target("/106").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		
		score.score = 8;
		actual = target("/107").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		
		score.score = 10;
		actual = target("/108").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		
		score.score = 9;
		actual = target("/109").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
	}
	
	
	@Test
	public void testRankInvalid() {
		Response actual = target("/-100").request().get();
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(),actual.getStatus());
		
		
		actual = target("/-100").request().get();
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(),actual.getStatus());
		
		actual = target("/10").request().get();
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(),actual.getStatus());
		
		actual = target("/0").request().get();
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(),actual.getStatus());
	}
	
	// This Test is dependent on previous
	@Test
	public void testRankOrder() {
		UserAchievment achievment = new UserAchievment();
		UserAchievment achievmentActual;

		achievment.rank = 10;
		Response actual = target("/100").request().get();
		
		achievmentActual = (UserAchievment)actual.readEntity(UserAchievment.class);
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		assertEquals(achievment, achievmentActual);
		
		
		achievment.rank = 1;
		actual = target("/108").request().get();
		
		achievmentActual = (UserAchievment)actual.readEntity(UserAchievment.class);
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		assertEquals(achievment, achievmentActual);
		
		
		achievment.rank = 2;
		actual = target("/109").request().get();
		
		achievmentActual = (UserAchievment)actual.readEntity(UserAchievment.class);
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		assertEquals(achievment, achievmentActual);
		
		
		achievment.rank = 3;
		actual = target("/107").request().get();
		
		achievmentActual = (UserAchievment)actual.readEntity(UserAchievment.class);
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		assertEquals(achievment, achievmentActual);
	}
	
	
	
	
}
