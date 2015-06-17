package ge.edu.freeuni.sdp.xo.achiev;

import java.util.Comparator;

public class FakeDBObjectComparator implements Comparator<FakeDBObject>{

	@Override
	public int compare(FakeDBObject arg0, FakeDBObject arg1) {
		int scoreFirst = arg0.getScore();
		int scoreSecond = arg1.getScore();
		if (scoreFirst == scoreSecond)
			return 0;
		else if (scoreFirst > scoreSecond)
			return -1;
		return 1;
	}

}
