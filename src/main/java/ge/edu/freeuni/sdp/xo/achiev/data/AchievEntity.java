package ge.edu.freeuni.sdp.xo.achiev.data;

import com.microsoft.azure.storage.table.TableServiceEntity;

public class AchievEntity extends TableServiceEntity{
	private int score;

	public AchievEntity(String ID,int score){
		this.rowKey = ID;
		final int index = 0;
		this.partitionKey = ID.charAt(index)+"";
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
