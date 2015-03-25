package s06;

public class ShortToStringMap {
	private int size;

	private int tabK[];
	private String tabV[];

	private int pos = 1;

	// TODO - A COMPLETER...
	// ------------------------------
	// Private methods
	// ------------------------------

	// Could be useful, for instance :
	// - one method to detect and handle the "array is full" situation
	// - one method to locate a key in the array
	// (to be called from containsKey(), put(), and remove())

	private int getPosOfKey(short key) {

		for (int i = 0; i < tabK.length; i++) {

			if (tabK[i] == key) {
				return i;
			}
		}
		return -1;
	}

	// ------------------------------
	// Public methods
	// ------------------------------
	// ------------------------------------------------------------
	public ShortToStringMap() {

		SetOfShorts dico = new SetOfShorts();

	}

	// ------------------------------------------------------------
	// adds an entry in the map, or updates the image
	public void put(short key, String img) {

		if (containsKey(key)) {
			int x = getPosOfKey(key);
			tabV[x] = img;
		} else {
			tabK[pos] = key;
			tabV[pos] = img;
			pos++;
		}
		
		size++;

	}

	// ------------------------------------------------------------
	// returns null if !containsKey(key)
	public String get(short key) {

		if (!containsKey(key)) {
			return "null";
		} else {
			int x = getPosOfKey(key);
			return tabV[x];
		}

	}

	// ------------------------------------------------------------
	public void remove(short e) {

		int x = getPosOfKey(e);
		tabV[x] = "";
		tabK[x] = 0;
		size--;

	}

	// ------------------------------------------------------------
	public boolean containsKey(short k) {

		for (int i = 0; i < tabK.length; i++) {

			if (tabK[i] == k) {
				return true;
			}
		}
		return false;

	}

	// ------------------------------------------------------------
	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	// ------------------------------------------------------------
	// a.union(b) : a becomes "a union b"
	// images are those in b whenever possible
	public void union(ShortToStringMap m) {
		// TODO - A COMPLETER...
	}

	// ------------------------------------------------------------
	// a.intersection(b) : "a becomes a intersection b"
	// images are those in b
	public void intersection(ShortToStringMap s) {
		// TODO - A COMPLETER...
	}

	// ------------------------------------------------------------
	// a.toString() returns all elements in
	// a string like: {3:"abc",9:"xy",-5:"jk"}
	public String toString() {
		return null;
	}
}
