package ge.edu.freeuni.sdp.xo.achiev;

import java.util.PriorityQueue;

public class FakeDB {
	private PriorityQueue<FakeDBObject> db;
	
	public FakeDB(){
		db = new PriorityQueue<FakeDBObject>(10,new FakeDBObjectComparator());
		db.add(new FakeDBObject(100, 0));
		db.add(new FakeDBObject(101, 0));
		db.add(new FakeDBObject(102, 0));
		db.add(new FakeDBObject(103, 0));
		db.add(new FakeDBObject(104, 0));
		db.add(new FakeDBObject(105, 0));
		db.add(new FakeDBObject(106, 0));
		db.add(new FakeDBObject(107, 0));
		db.add(new FakeDBObject(108, 0));
		db.add(new FakeDBObject(109, 0));
	}
	
	public boolean changeScore(int ID, int score){
		for (FakeDBObject o: db){
			if (o.getID() == ID){
				db.remove(o);
				o.setScore(score);
				db.add(o);
				return true;
			}
		}
		return false;
	}
	
	public UserAchievment getUserAchievment(int ID){
		PriorityQueue<FakeDBObject> newdb = new PriorityQueue<FakeDBObject>(10,new FakeDBObjectComparator());
		for (FakeDBObject o: db)
			newdb.add(o);
		for (int i=10; i>0; i--){
			FakeDBObject o = newdb.poll();
			if (o.getID() == ID){
				UserAchievment userAchievment = new UserAchievment();
				userAchievment.rank = i;
				userAchievment.score = o.getScore();
				return userAchievment;
			}
		}
		return null;
	}
}
