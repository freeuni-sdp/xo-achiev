package ge.edu.freeuni.sdp.xo.achiev.data;

import com.microsoft.azure.storage.table.TableServiceEntity;

public class AchievEntity extends TableServiceEntity{
	private int score;
	private int rank;
	/**
	 * We have only 1 partition. 
	 */
	public final static String PARTITION = "0"; 
	
	public AchievEntity(String ID,int score){
		this.rowKey = ID;
		this.partitionKey = PARTITION; // same partition key for every user. 
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getRank(){
		return rank;
	}
	
	public void setRank(int rank){
		this.rank = rank;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AchievEntity other = (AchievEntity) obj;
		if (score != other.score)
			return false;
		return true;
	}
	
	
}
