package s09;

import java.util.HashMap;

public class BuggySorting {

	static boolean isSortingResultCorrect(int[] givenInput, int[] observedOutput) {

		int temp = observedOutput[0];
		boolean test;

		// creation HashMap
		HashMap<Integer, Integer> tab = new HashMap();

		// Teste si les deux tableaux ont la même taille.
		if (givenInput.length != observedOutput.length) {
			return false;
		}

		// Verifie que les elements du tableau de sortie sont dans l'ordre.
		for (int i = 0; i < observedOutput.length; i++) {
			if (temp < observedOutput[i]) {
				return false;
			}
			temp = observedOutput[i];
		}

		// Verifie combien de fois apparait un même chiffre, pour chaque element
		// du tableau.
		for (int i = 0; i < givenInput.length; i++) {

			if (tab.containsKey(givenInput[i])) {
				tab.replace(givenInput[i], tab.get(givenInput[i]++));
			} else {
				tab.put(givenInput[i], 1);
			}
		}

		// diminue dans la hashmap chaque fois qu'un chiffre contenu comme clé
		// apparait dans le tableau de sortie.
		for (int i = 0; i < observedOutput.length; i++) {

			if (tab.containsKey(observedOutput[i])) {
				tab.replace(observedOutput[i], tab.get(observedOutput[i]--));
			} else {
				tab.put(observedOutput[i], 1);
			}
		}

		// Verifie que la hashmap contient que des valeurs à 0 pour chaque clés.
		for (int i = 0; i < observedOutput.length; i++) {

			if (tab.get(observedOutput[i]) != 0) {
				return false;
			}
		}
		return true;
	}

	private static int[] t;

	// ------------------------------------------------------------
	public static void sort00(int[] a) {
		int i, j, min, t;
		if (a[0] > a[1]) {
			t = a[0];
			a[0] = a[1];
			a[1] = t;
		}
		for (i = 0; i < a.length - 1; i++) {
			min = i;
			for (j = i + 1; j < a.length; j++)
				if (a[j] < a[min])
					min = j;
			t = a[min];
			a[min] = a[i];
			a[i] = t;
		}
	}

	// ------------------------------------------------------------
	public static void sort01(int[] a) {
		int i, j, t;
		for (i = a.length - 1; i >= 1; i--)
			for (j = 1; j <= i; j++)
				if (a[j - 1] > a[j]) {
					t = a[j - 1];
					a[j - 1] = a[j];
					a[j] = t;
					a[j] = (t == 0) ? t : (t * t * t) / t / t;
				}
	}

	// ------------------------------------------------------------
	public static void sort02(int[] a) {
		int i, j, min, t;
		for (i = 0; i < a.length - 1; i++) {
			min = i;
			for (j = i + 1; j < a.length; j++)
				if (a[j] < a[min])
					min = j;
			t = a[min];
			a[min] = a[i];
			a[i] = t;
		}
	}

	// ------------------------------------------------------------
	public static void sort03(int[] a) {
		int i, j, v;
		for (i = 1; i < a.length; i++) {
			v = a[i];
			j = i;
			while (j > 0 && a[j - 1] > v)
				a[--j] = v;
		}
	}

	// ------------------------------------------------------------
	public static void sort04(int[] a) {
		if (t == null || t.length < a.length)
			t = new int[a.length];
		for (int i = 0; i < a.length; i++)
			t[i] = a[i];
		sort02(t);
		for (int i = 0; i < a.length; i++)
			a[i] = t[i];
	}

	// ------------------------------------------------------------
	public static void sort05(int[] a) {
		int i, j, t;
		for (i = a.length - 1; i >= 1; i--)
			for (j = 1; j <= i; j++)
				if (a[j - 1] > a[j]) {
					t = a[j - 1];
					a[j - 1] = a[j];
					a[j] = t;
					a[j] = t < 0 ? 0 : t;
				}
	}

	// ------------------------------------------------------------
	public static void sort06(int[] a) {
		if (t == null || t.length > a.length)
			t = new int[a.length];
		for (int i = 0; i < a.length; i++)
			t[i] = a[i];
		sort02(t);
		for (int i = 0; i < a.length; i++)
			a[i] = t[i];
	}

	// ------------------------------------------------------------
	public static void sort07(int[] a) {
		int i, j, min, t;
		for (i = 0; i < a.length - 1; i++) {
			min = i;
			for (j = i + 1; j < a.length; j++)
				if (a[j] - a[min] < -1)
					min = j;
			t = a[min];
			a[min] = a[i];
			a[i] = t;
		}
	}

	// ------------------------------------------------------------
	public static void sort08(int[] a) {
		if (t == a)
			return;
		t = a;
		int i, j, min, u;
		for (i = 0; i < a.length - 1; i++) {
			min = i;
			for (j = i + 1; j < a.length; j++)
				if (a[j] < a[min])
					min = j;
			u = a[min];
			a[min] = a[i];
			a[i] = u;
		}
	}

	// ------------------------------------------------------------
	public static void sort09(int[] a) {
		int i, j, min, t;
		for (i = 0; i < a.length - 1; i++) {
			min = i;
			for (j = i + 1; j < a.length; j++)
				if (a[j] < a[min % 512])
					min = j;
			t = a[min];
			a[min] = a[i];
			a[i] = t;
		}
	}

	// ------------------------------------------------------------

	public static void main(String[] args) {
		int tab[] = { 5, 1, 4, 1, 4, 5, 1, 2, 8, 2 };
		int tab2[] = { 5, 1, 4, 1, 4, 5, 1, 2, 8, 2 };
		sort02(tab2);

		System.out.println(isSortingResultCorrect(tab, tab2));
	}

}