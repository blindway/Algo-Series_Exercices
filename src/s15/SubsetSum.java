package s15;

public class SubsetSum {
	// ============================================================
	public static void main(String[] args) {
		int[] t = { 5, 8, 3 };
		int max = 20;
		System.out.println("Valid sums < " + max);
		for (int i = 0; i < max; i++) {
			boolean r = subsetSumDyn(t, i);
			if (r)
				System.out.println(i);
		}
	}

	// ============================================================
	// Subset Sum Problem : Dynamic Programming version
	// ============================================================
	public static boolean subsetSumDyn(int[] t, int k0) {
		boolean[] sols = new boolean[k0 + 1]; // tableau de solutions
												// intermédiaires rempli de
												// false
		sols[0] = true;
		for (int i = 0; i < t.length; i++) {
			int currentValue = t[i];
			for (int j = k0; j > 0; j--) { // parcourir depuis la droite
				if ((j - currentValue >= 0) && (sols[j - currentValue]))
					sols[j] = true;
			}
		}
		return sols[k0];
	}
}
