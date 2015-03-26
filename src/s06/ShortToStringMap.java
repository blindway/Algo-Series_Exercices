package s06;

public class ShortToStringMap {
	private int size;

	private int tabKey[];
	private String tabValue[];

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

		for (int i = 0; i < size; i++) {

			if (tabKey[i] == key) {
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
		tabKey = new int[1];
		tabValue = new String[1];
		size = 0;
	}

	// ------------------------------------------------------------
	// adds an entry in the map, or updates the image
	public void put(short key, String img) {

		if (containsKey(key)) {
			int x = getPosOfKey(key);
			tabValue[x] = img;
		} else if (size == tabKey.length) {
			int newTabK[] = new int[tabKey.length * 2];
			String newTabV[] = new String[tabValue.length * 2];

			for (int i = 0; i < tabKey.length; i++) {
				newTabK[i] = tabKey[i];
			}
			for (int i = 0; i < tabValue.length; i++) {
				newTabV[i] = tabValue[i];
			}
			newTabK[size + 1] = key;
			newTabV[size + 1] = img;

			tabKey = newTabK;
			tabValue = newTabV;
			size++;
		} else {
			tabKey[size] = key;
			tabValue[size] = img;
			size++;
		}

	}

	// ------------------------------------------------------------
	// returns null if !containsKey(key)
	public String get(short key) {

		if (!containsKey(key)) {
			return "null";
		} else {
			int x = getPosOfKey(key);
			return tabValue[x];
		}

	}

	// ------------------------------------------------------------
	public void remove(short key) {
		if (containsKey(key)) {
			tabKey[key] = tabKey[size - 1];
			tabValue[getPosOfKey(key)] = tabValue[size - 1];
			tabKey[size - 1] = 0;
			tabValue[size - 1] = null;
			size--;
		}
	}

	// ------------------------------------------------------------
	public boolean containsKey(short k) {
		for (int i = 0; i < size; i++) {
			if (tabKey[i] == k) {
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

		for (int i = 0; i < m.tabKey.length; i++) {
			if (!(this.containsKey((short) (m.tabKey[i])))) {
				this.put((short) m.tabKey[i], m.tabValue[i]);
			}
		}
	}

	// ------------------------------------------------------------
	// a.intersection(b) : "a becomes a intersection b"
	// images are those in b
	public void intersection(ShortToStringMap s) {

		for (int i = 0; i < this.tabKey.length; i++) {
			if (s.containsKey((short) this.tabKey[i])) {
				this.remove((short) this.tabKey[i]);
			}
		}
	}

	// ------------------------------------------------------------
	// a.toString() returns all elements in
	// a string like: {3:"abc",9:"xy",-5:"jk"}
	public String toString() {
		String resultat= "";
		for (int i = 0; i < size; i++) {
			resultat+= tabKey[i] +"="+tabValue[i]+",";
		}
		
		return "{"+resultat+"}";
	}
}
