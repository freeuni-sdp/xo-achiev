package ge.edu.freeuni.sdp.xo.achiev;

import javax.validation.constraints.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Score {

	@NotNull
    @Min(0)
	@XmlElement
	public int score;

	@Override
	public String toString() {
		return "score - "+score;
	}
}
