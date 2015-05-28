package s15;

public class GridPath {
	// ============================================================
	// Min Path Problem : Recursive version
	// ============================================================
	public static int minPath(int[][] t) {
		return minPath(t, t.length - 1, t[0].length - 1);
	}

	public static int minPath(int[][] t, int i, int j) {
		if (i < 0 || j < 0)
			return Integer.MAX_VALUE / 2;
		if (i == 0 && j == 0)
			return t[0][0];
		int a = minPath(t, i - 1, j);
		int b = minPath(t, i, j - 1);
		if (b < a)
			a = b;
		return a + t[i][j];
	}

	// ============================================================
	// Min Path Problem : Dynamic Programming version
	// ============================================================
	public static int minPathDyn(int[][] t) {
		int n = t.length, m = t[0].length;
		int[][] minPathSol = new int[n][m];
		minPathSol[0][0] = t[0][0];
<<<<<<< HEAD
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				//comparer cellule du dessu et cellule � gauche
				int up = minPathSol[i-1][j];
				int left = minPathSol [i][j-1];
				if(up<left) // alors on prend up
					minPathSol[i][j] = up + t[i][j];
				else	//alors o prend left
					minPathSol[i][j] = left + t[i][j];
			}
=======
		boolean[][] fromWhere = new boolean[n][m];

		for (int i = 1; i < n; i++) {
			// première colonne
			minPathSol[i][0] = minPathSol[i - 1][0] + t[i][0];
>>>>>>> origin/master
		}

		for (int j = 1; j < m; j++) {
			// première ligne
			minPathSol[0][j] = minPathSol[0][j - 1] + t[0][j];

		}

		System.out.println(minPathSol[0][2]);
		
		return minPathSol[n - 1][m - 1];
	}

	// ============================================================
	// Small Main
	// ============================================================
	public static void main(String[] args) {
		int[][] t = { { 2, 2, 6, 7 }, { 3, 8, 5, 9 }, { 2, 1, 8, 2 },
				{ 4, 2, 3, 5 } };
		System.out.println(minPath(t));
		System.out.println(minPathDyn(t));
	}
}
