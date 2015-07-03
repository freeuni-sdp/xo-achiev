import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import ge.edu.freeuni.sdp.xo.achiev.FakeAchievService;
import ge.edu.freeuni.sdp.xo.achiev.Score;
import ge.edu.freeuni.sdp.xo.achiev.UserAchievment;
import ge.edu.freeuni.sdp.xo.achiev.MyCustomException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ProcessingException;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;


public class TestFakeAchieve extends JerseyTest{

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Override
	protected Application configure() {
		System.out.println("we are here");
		return new ResourceConfig(FakeAchievService.class);
	}

	@Test
	public void testInvalidScoreValidId() {
		Score score = new Score();
		score.score = -10;
		Response actual = target("fake/100").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(),actual.getStatus());
	}

	@Test
	public void throwExceptionValidScoreInvalidId() {
		thrown.expect( ProcessingException.class );

		Score score = new Score();
		score.score = 0;
		Response actual = target("fake/0").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		fail("should not reach this line");
	}

	private void setValid(){
		Score score = new Score();
		score.score = 1;
		Response actual = target("fake/100").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());

		score.score = 2;
		actual = target("fake/101").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());

		score.score = 3;
		actual = target("fake/102").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());

		score.score = 4;
		actual = target("fake/103").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());

		score.score = 5;
		actual = target("fake/104").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());

		score.score = 6;
		actual = target("fake/105").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());

		score.score = 7;
		actual = target("fake/106").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());

		score.score = 8;
		actual = target("fake/107").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());

		score.score = 10;
		actual = target("fake/108").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());

		score.score = 9;
		actual = target("fake/109").request().put(Entity.entity(score, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
	}
	@Test
	public void testChangeValidSet() {
		setValid();
	}


	@Test
	public void throwExceptionInvalidRank() {
		thrown.expect( ProcessingException.class );

		Response actual = target("fake/-100").request().get();
		fail("should not reach this line");
	}

	// This Test is dependent on previous
	@Test
	public void testRankOrder() {
		setValid();
		UserAchievment achievment = new UserAchievment();
		UserAchievment achievmentActual;

		achievment.rank = 10;
		achievment.score = 1;
		Response actual = target("fake/100").request().get();

		achievmentActual = (UserAchievment)actual.readEntity(UserAchievment.class);
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		assertEquals(achievment, achievmentActual);


		achievment.rank = 1;
		achievment.score = 10;
		actual = target("fake/108").request().get();

		achievmentActual = (UserAchievment)actual.readEntity(UserAchievment.class);
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		assertEquals(achievment, achievmentActual);


		achievment.rank = 2;
		achievment.score = 9;
		actual = target("fake/109").request().get();

		achievmentActual = (UserAchievment)actual.readEntity(UserAchievment.class);
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		assertEquals(achievment, achievmentActual);


		achievment.rank = 3;
		achievment.score = 8;
		actual = target("fake/107").request().get();

		achievmentActual = (UserAchievment)actual.readEntity(UserAchievment.class);
		assertEquals(Response.Status.OK.getStatusCode(),actual.getStatus());
		assertEquals(achievment, achievmentActual);
	}




}
