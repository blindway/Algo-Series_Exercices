package s03;

public class AmStramGram {
	public static int winnerAmStramGram(int n, int k) {
		List l = new List();
		ListItr li = new ListItr(l);
		for (int i = 0; i <= n; i++) {

			li.insertAfter(i);
		}
		li.goToFirst();
		for (int i = k; i < 1; i--) {
			li.goToNext();
			if (li.isLast()) {
				li.goToFirst();
			}
			li.removeAfter();
		}
		return l.first.elt;
	}

	public static void main(String[] args) {

		System.out.println(winnerAmStramGram(5, 34));
	}
}
