package s07;

public class Minimum {

	public static void main(String[] args) {

		int tab[] = { 6, 9, 3, 3, 5, 7, 4 };
		int itr = tab.length / 2;
		System.out.println("Le min [6, 9, 3, 3, 5, 7, 4] en 1 appel recursif: "+Min(tab, itr));
		
		int start = 0;
		int end = tab.length-1;
		System.out.println("Le min [6, 9, 3, 3, 5, 7, 4] en 2 appels recursifs: "+Min2(tab, start, end));

	}

	//unique appel recursif
	@SuppressWarnings("null")
	public static int Min(int[] tab, int itr) {
		if (tab == null || tab.length == 0) {
			return (Integer) null;
		} 
		else if (itr == tab.length - 1) {
			return tab[itr];
		} 
		else {
			int nextVal = Min(tab, itr + 1);
			if (tab[itr] < nextVal) {
				return tab[itr];
			} 
			else {
				return nextVal;
			}
		}
	}

	//double appel recursif
	@SuppressWarnings("null")
	public static int Min2(int[] tab, int start, int end) {
		if (tab == null || tab.length == 0) {
			return (Integer) null;
		} 
		else if (end == start) {
			return tab[start];
		} 
		else {
			int mid = (start + end) / 2;
			int val1 = Min2(tab, start, mid);
			int val2 = Min2(tab, mid + 1, end);
			if (val1 < val2) {
				return val1;
			} 
			else {
				return val2;
			}
		}
	}

}
