package s14;

public class PolynomThing {
	private final double[] coef;
	private final boolean isReducible;
	private final String name;

	public PolynomThing(double[] c, boolean red, String s) {
		int n = c.length;
		coef = new double[n];
		System.arraycopy(c, 0, coef, 0, n);
		isReducible = red;
		name = s;
	}

	@Override
	public int hashCode() {

		int result = 19;

		// each char
		for (int i = 0; i < name.length(); i++) {
			int c = (int) name.charAt(i);
			result = result * 31 + c;
		}

		// boolean
		int c = (isReducible ? 1 : 0);
		result = result * 31 + c;

		// tab
		for (int i = 0; i < degree(); i++) {
			c = (int) Double.doubleToRawLongBits(coef[i]);
			result = result * 31 + c;
		}

		return Math.abs(result);
		//return ((int) Math.abs(result) % degree());

	}

	public double getCoef(int i) {
		return coef[i];
	}

	public int degree() {
		return coef.length;
	}

	public String name() {
		return name;
	}

	public boolean isReducible() {
		return isReducible;
	}

	// -------------------------------------------
	public static void main(String[] args) {
		PolynomThing a = new PolynomThing(new double[] { 2, 3, 4 }, true, "foo");
		PolynomThing b = new PolynomThing(new double[] { 2, 3, 5 }, true, "bar");
		PolynomThing c = new PolynomThing(new double[] { 2, 3 }, true, "demo");
		PolynomThing d = new PolynomThing(new double[] { 2, 3, 4 }, false,
				"foo");
		System.out.println(a.hashCode() + " " + b.hashCode() + " "
				+ c.hashCode() + " " + d.hashCode());
	}

}