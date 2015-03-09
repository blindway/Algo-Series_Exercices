package s03;

public class AmStramGram {
	public static int winnerAmStramGram(int n, int k) {
		List l = new List();
		ListItr li = new ListItr(l);
		for (int i = n; i > 0; i--) {
			li.insertAfter(i);
		}
		while (l.size() > 1) {
			for (int i = 1; i < k; i++) {
				if (li.isLast())
					li.goToFirst();
				li.goToNext();
			}
			if (li.isLast())
				li.goToFirst();
			li.removeAfter();
		}
		return l.first.elt;
	}

	public static void main(String[] args) {

		System.out.println(winnerAmStramGram(5, 34));
		System.out.println(winnerAmStramGram(14, 2));
	}
}
