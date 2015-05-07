package s11;

public class demo2 {
	public static void main(String[] args) {
		
		int a = 5;
		demo(a);
	}

	static void demo(int n) {
		ObjQueue f;
		int i, sum = 0;
		f = new ObjQueue();
		for (i = 0; i < n; i++)
			f.enqueue(new Integer(i));
		while (!f.isEmpty())
			sum = sum + (Integer) f.dequeue();
		System.out.println(sum);
	}

}