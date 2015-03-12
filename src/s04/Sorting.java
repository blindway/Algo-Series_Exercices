package s04;

public class Sorting {
	public static void main(String[] args) {
		int[] t = { 4, 3, 2, 6, 8, 7 };
		int[] u = { 2, 3, 4, 6, 7, 8 };
		insertionSort(t);
		for (int i = 0; i < t.length; i++)
			if (t[i] != u[i]) {
				System.out.println("Something is wrong...");
				return;
			}
		int[] v = { 5 };
		insertionSort(v);
		int[] w = {};
		insertionSort(w);
		System.out.println("\nMini-test passed successfully...");
	}

	// ------------------------------------------------------------
	public static void selectionSort(int[] a) {
		// TODO - A COMPLETER !
	}

	// ------------------------------------------------------------
	public static void shellSort(int[] a) {
		// TODO - A COMPLETER !
	}

	// ------------------------------------------------------------
	public static void insertionSort(int[] a) {
		int i, j, v;

		for (i = 1; i < a.length; i++) {
			v = a[i]; // v is the element to insert
			j = i;
			while (j > 0 && a[j - 1] > v) {
				a[j] = a[j - 1]; // move to the right
				j--;
			}
			a[j] = v; // insert the element
		}
	}
	// ------------------------------------------------------------
}