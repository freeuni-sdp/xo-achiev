package ge.edu.freeuni.sdp.xo.achiev;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserAchievment {

	@XmlElement
	public int score;
	
	@XmlElement
	public int rank;
	
	@Override
	public String toString() {
		return "score - "+score+" rank - "+rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAchievment other = (UserAchievment) obj;
		if (rank != other.rank)
			return false;
		return true;
	}
	
	
}
