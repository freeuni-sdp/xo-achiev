package ge.edu.freeuni.sdp.xo.achiev;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Score {

	@XmlElement
	int score;
	
	@Override
	public String toString() {
		return "score - "+score;
	}
}
