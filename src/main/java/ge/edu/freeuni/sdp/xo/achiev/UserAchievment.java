package ge.edu.freeuni.sdp.xo.achiev;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserAchievment {

	@XmlElement
	int score;
	
	@XmlElement
	int rank;
	
	@Override
	public String toString() {
		return "score - "+score+" rank - "+rank;
	}
}
