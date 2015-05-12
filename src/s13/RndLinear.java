package s13;

import java.util.Random;

public class RndLinear {
	public static void main(String[] args) {
		int nbOfExperiments = 100000;
		int n = 10;
		Random r = new Random();
		testLinear(r, n, nbOfExperiments);
	}

	// ============================================================
	public static int rndLinear(Random r, int n) {
		int m = (n * (n + 1)) / 2;
		int x = r.nextInt(m)+1;
		int value = 0;
		int result;
		for (result = 0; value < x; result++) {
			value += result + 1;
		}
		return result;
	}

	// ============================================================
	static void testLinear(Random r, int n, int nbOfExperiments) {
		int[] t = new int[n + 1];
		for (int i = 0; i < nbOfExperiments; i++)
			t[rndLinear(r, n)]++;
		System.out.println(0 + " : " + t[0]);
		for (int i = 1; i < n + 1; i++)
			System.out.println(i + " : " + (double) t[i] / nbOfExperiments);
	}
}
