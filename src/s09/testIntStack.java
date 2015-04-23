package s09;

public class testIntStack {

	public static void main(String[] args) {

		System.out.println(findBugs01());
	}

	static boolean findBugs01() {
		IntStack s = new IntStack(10);
		s.push(0);
		if (s.pop() != 0)
			return true;
		if (!s.isEmpty())
			return true;
		return false;
	}

	static boolean findBugs02() {
		IntStack s = new IntStack(10);
		s.push(0);
		s.push(1);
		if (s.isEmpty())
			return true;
		return false;
	}

	static boolean findBugs03() {
		IntStack s = new IntStack(10);
		s.push(0);
		s.push(5);
		s.pop();
		s.push(1);
		if (s.pop() != 1)
			return true;
		if (s.isEmpty())
			return true;
		return false;
	}

	static boolean findBugs04() {
		IntStack s = new IntStack(5);
		try {
			s.push(7);
		} catch (Exception e) {

			return true;
		}
		return false;
	}

	static boolean findBugs05() {
		IntStack s = new IntStack(5);
		IntStack s2 = new IntStack(12);

		s.push(3);

		if (s2.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
