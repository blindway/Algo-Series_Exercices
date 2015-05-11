package s12;

public class BitSetOfShortsItr {

	BitSetOfShorts b;
	int index = 0;
	int cpt = 0;

	// ------------------------------------------------------------
	public BitSetOfShortsItr(BitSetOfShorts theSet) {
		b = theSet;
		cpt = theSet.size();
	}

	public boolean hasMoreElements() {
		return cpt > 0;
	}

	public short nextElement() {

		while (!b.contains((short) index)) {
			index++;
		}

		short nextEl = (short) index;
		cpt--;
		index++;
		return nextEl;

	}

}