package ge.edu.freeuni.sdp.xo.achiev;

public class FakeDBObject {

	private int score;
	private String ID;
	
	public FakeDBObject(String ID,int score){
		this.ID = ID;
		this.score = score;
	}
	
	public String getID() {
		return ID;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
