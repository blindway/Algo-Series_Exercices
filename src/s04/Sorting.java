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
		// Défini la taille du tableau
		int taille = a.length;
		// tant qu'il reste des éléments non triés
		for (; taille > 0; taille--) {
			int max = 0;
			int i = 0;
			int tmp = 0;

			// On cherche le plus grand
			while (i < taille) {
				if (a[i] > a[max]) {
					max = i;
				}
				i++;
			}

			// On inverse le plus grand avec le dernier du tableau
			tmp = a[taille - 1];
			a[taille - 1] = a[max];
			a[max] = tmp;
		}

		// Affiche le tableau trié
		for (int j2 = 0; j2 < a.length; j2++) {
			System.out.println(a[j2]);
		}
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