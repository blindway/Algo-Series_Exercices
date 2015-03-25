package s05;

// import s05.TurtlePanel;

public class FractalCurve {

	private static final int L = 0; // Code meaning TurnLeft
	private static final int R = 1; // Code meaning TurnRight
	private static final int A = 3; // Code meaning Advance

	private static final int panelWidth = 800;
	private static final int panelHeight = 600;
	private static final int HMargin = 30;
	private static final int startX = HMargin / 2;
	private static final int startY = panelHeight / 2;

	private static int maxLevels = 2;

	private static int[] pattern = { A, A, L, A, A, R, A, A, R, A, A, L, A, A };

	private TurtlePanel t;
	private double scaleFactor = Math.pow(getStraightAdvance(), maxLevels);
	private int usableWidth = (panelWidth - HMargin);
	private float baseDist = (float) (usableWidth / scaleFactor);

	// ----------------------------------------------------------------------------
	public FractalCurve() {
		t = TurtlePanel.create("Fractal Curve", panelWidth, panelHeight,
				startX, startY, true);
		drawPattern(maxLevels);
		// drawPattern(1);
	}

	// ----------------------------------------------------------------------------
	public void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}

	// ----------------------------------------------------------------------------
	public void drawPattern(int level) {
		for (int i = 0; i < pattern.length; i++) {
			switch (pattern[i]) {
			case R:
				t.turnRight();
				break;
			case L:
				t.turnLeft();
				break;
			case A:
				if (level == 1)
					t.advance(baseDist);
				else drawPattern(level-1);
				break;
			}
		}
	}

	// ----------------------------------------------------------------------------
	// Get number of (advance) steps in initial direction
	// ----------------------------------------------------------------------------
	private int getStraightAdvance() {
		int ix = 1, iy = 0; // Initial direction (orientation vectors)
		int ctSteps = 0; // Count steps in initial direction

		for (int op : pattern) {
			if (op == A) {
				if (ix == 1)
					ctSteps++; // Step backward
				else if (ix == -1)
					ctSteps--; // Step forward
			} else if (op == L) {
				int tx = ix;
				ix = -iy;
				iy = tx;
			} else if (op == R) {
				int tx = ix;
				ix = iy;
				iy = -tx;
			}
		}
		return ctSteps;
	}

	public static int fact(int n) {
		if (n == 1)
			return 1;
		return n * fact(n - 1);
	}

	public static int modulo(int val, int divisor) {
		if (val < divisor)
			return val;
		return modulo(val - divisor, divisor);
	}

	public static int nbrDe1(int n) {
		if (n == 0)
			return 0;
		else
			return ((n % 2) + nbrDe1(n / 2));
	}

	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public static int auCarre(int n) {
		if (n == 0)
			return 0;
		return auCarre(n - 1) + 2 * n - 1;
	}

	// ----------------------------------------------------------------------------
	public static void main(String[] args) {
		if (args.length == 1)
			maxLevels = Integer.parseInt(args[0]);
		new FractalCurve();

		System.out.println(fact(4));

		System.out.println(modulo(5, 2));

		System.out.println(nbrDe1(7));
	}

}