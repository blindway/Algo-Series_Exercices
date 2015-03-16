package s04;

import s03.List;
import s03.ListItr;

public class Sorting {
	public static void main(String[] args) {
		int[] t = { 4, 3, 2, 6, 8, 7, 9, 1 };
		int[] u = { 1, 2, 3, 4, 6, 7, 8, 9 };
		insertionSort(t);
		for (int i = 0; i < t.length; i++)
			if (t[i] != u[i]) {
				System.out.println("Something is wrong with insertionSort...");
				return;
			}
		shellSort(t);
		for (int i = 0; i < t.length; i++) {
			if ((t[i] != u[i])) {
				System.out.println("Something is wrong with shellSort...");
				return;
			}
		}
		int[] v = { 5 };
		insertionSort(v);
		shellSort(v);
		int[] w = {};
		insertionSort(w);
		shellSort(w);
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
		int longueur = a.length;
		int k = 0;
		while (k < longueur) {
			k = 3 * k + 1;
		}
		while (k != 0) {
			k = k / 3;
			for (int i = k; i < longueur; i++) {
				int valeur = a[i];
				int j = i;
				while ((j > (k - 1)) && (a[j - k] > valeur)) {
					a[j] = a[j - k];
					j = j - k;
				}
				a[j] = valeur;
			}
		}
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
	static void bubbleSortList(List l) {
		if (l.isEmpty())
			return;
		ListItr li = new ListItr(l);
		boolean goOn = true;
		while (goOn) {
			// TODO ...
		}
	}

	// Swaps between left and right element if needed
	// Returns true is swap occurred
	private static boolean bubbleSwapped(ListItr li) {
		if (li.isFirst() || li.isLast())
			return false;
		// TODO ...
	}
}