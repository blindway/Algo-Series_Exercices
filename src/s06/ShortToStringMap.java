package s06;

public class ShortToStringMap {
	private int size;

	private int tabKey[];
	private String tabValue[];

	private int pos = 0;

	// TODO - A COMPLETER...
	// ------------------------------
	// Private methods
	// ------------------------------

	// Could be useful, for instance :
	// - one method to detect and handle the "array is full" situation
	// - one method to locate a key in the array
	// (to be called from containsKey(), put(), and remove())

	private int getPosOfKey(short key) {

		for (int i = 0; i < tabKey.length; i++) {

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
		tabKey = new int[0];
		tabValue = new String[0];
		size = 0;
	}

	// ------------------------------------------------------------
	// adds an entry in the map, or updates the image
	public void put(short key, String img) {

		if (containsKey(key)) {
			int x = getPosOfKey(key);
			tabValue[x] = img;
		} else {
			int newTabK[] = new int[tabKey.length + 1];
			String newTabV[] = new String[tabValue.length + 1];

			for (int i = 0; i < tabKey.length; i++) {
				newTabK[i] = tabKey[i];
			}
			for (int i = 0; i < tabValue.length; i++) {
				newTabV[i] = tabValue[i];
			}
			newTabK[newTabK.length-1] = key;
			newTabV[newTabV.length-1] = img;
			
			tabKey = newTabK;
			tabValue = newTabV;
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
		if (containsKey(key)){
			
			//créer tableaux plus petits de 1
			// copier les valeurs
			//écrase la valeur Key avec la dernière du tableau
			//Associer les tableaux de la classe avec les nouveaux
			
			size--;
		}
	}

	// ------------------------------------------------------------
	public boolean containsKey(short k) {
		for (int i = 0; i < tabKey.length; i++) {
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
