package ge.edu.freeuni.sdp.xo.achiev;

public class FakeDBObject {

	private int score;
	private int ID;
	
	public FakeDBObject(int ID,int score){
		this.ID = ID;
		this.score = score;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
