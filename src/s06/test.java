package s06;

public class test {

	public static void main(String[] args) {
		
		
	}

	public static SetOfShorts z(SetOfShorts s, int x) {
		SetOfShorts res = new SetOfShorts();
		SetOfShortsItr itr = new SetOfShortsItr(s);
		while (itr.hasMoreElements()) {
			short i = itr.nextElement();
			if (i < x)
				res.add(i);
		}
		return res;
	}

}
