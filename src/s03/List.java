package s03;

public class List {
	ListNode first, last;
	int size;

	// --------------------
	public List() {
		first = null;
		last = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	// ==================================================
	// === Small Test Program ===
	// ==================================================

	public static void main(String[] args) {
		if (findsBugInScenario1())
			System.out.println("Something is wrong...");
		else
			System.out.println("Test passed successfully");
	}

	// --------------------
	private static boolean findsBugInScenario1() {
		int[] t = { 10, 20, 30, 40, 50 };
		List l = new List();
		ListItr li = new ListItr(l);
		if (!l.isEmpty()) {
			System.out.println("1");
			return true;
		}
		if (!li.isFirst()) {
			System.out.println("2");
			return true;
		}
		if (!li.isLast()) {
			System.out.println("3");
			return true;
		}
		li.insertAfter(30);
		li.insertAfter(10);
		li.goToNext();
		li.insertAfter(20);
		li.goToLast();
		li.insertAfter(50);
		li.insertAfter(40);
		li.goToFirst();
		for (int i = 0; i < t.length; i++) {
			if (li.consultAfter() != t[i]) {
				System.out.println("4");
				return true;
			}
			li.goToNext();
		}
		if (!li.isLast()) {
			System.out.println("5");
			return true;
		}

		li.goToFirst();
		li.removeAfter();
		li.goToNext();
		li.removeAfter();
		li.goToNext();
		li.removeAfter();
		li.goToFirst();
		if (li.consultAfter() != 20) {
			System.out.println("6");
			return true;
		}
		li.goToNext();
		if (li.consultAfter() != 40) {
			System.out.println("7");
			return true;
		}
		li.goToNext();
		if (!li.isLast()) {
			System.out.println("8");
			return true;
		}

		return false;
	}
	// --------------------

}