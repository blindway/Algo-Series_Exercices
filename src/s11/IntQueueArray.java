package s11;

import java.util.Deque;
import java.util.Random;

import sun.misc.Queue;

// ======================================================================
public class IntQueueArray {
	private int[] buffer = new int[5];
	private int front = 1;
	private int back = 0;
	private int size = 0;

	// ------------------------------
	public IntQueueArray() {
	}

	// ------------------------------
	public void enqueue(int elt) {
		checkSize();
		back++;
		if (back == buffer.length)
			back = 0;
		buffer[back] = elt;
		size++;
	}

	// ------------------------------
	public boolean isEmpty() {
		return size == 0;
	}

	// ------------------------------
	// PRE: !isEmpty()
	public int consult() {
		return buffer[front];
	}

	// ------------------------------
	// PRE: !isEmpty()
	public int dequeue() {
		int aux = buffer[front];
		front = (front + 1) % buffer.length;
		size--;
		return aux;
	}

	// ------------------------------
	private void checkSize() {
		if (!(size < buffer.length)) {
			int[] bufferTemp = new int[2 * size];
			int index = 0;
			for (int i = front; i < buffer.length; i++) {
				bufferTemp[index] = buffer[i];
				index++;
			}
			for (int i = 0; i < front; i++) {
				bufferTemp[index] = buffer[i];
				index++;
			}
			front = 0;
			back = --index;
			buffer = bufferTemp;
		}
	}

	// ======================================================================
	public static void main(String[] args) {
		int n = 1000000;
		if (args.length == 1)
			n = Integer.parseInt(args[0]);
		Random r = new Random();
		long seed = r.nextInt(1000);
		r.setSeed(seed);
		System.out.println("Using seed " + seed);
		IntQueueArray q = new IntQueueArray();
		int m = 0;
		int k = 0;
		int p = 0;
		for (int i = 0; i < n; i++) {
			boolean doAdd = r.nextBoolean();
			if (doAdd) {
				k++;
				q.enqueue(k);
				ok(!q.isEmpty(), "should be non-empty " + m + " " + k + " " + p
						+ "\n");
				m++;
				// System.out.print("a("+k+")");
			} else {
				if (m == 0) {
					ok(q.isEmpty(), "should be empty " + m + " " + k + " " + p
							+ "\n");
				} else {
					ok(!q.isEmpty(), "should be non-empty " + m + " " + k + " "
							+ p + "\n");
					int e = q.dequeue();
					// System.out.print("r("+e+")");
					m--;
					ok(e == p + 1, "not FIFO " + m + " " + k + " " + p + "\n");
					p++;
				}
			}
		}
		System.out.println("Test passed successfully");
	}

	// ------------------------------------------------------------
	static void ok(boolean b, String s) {
		if (b)
			return;
		throw new RuntimeException("property not verified: " + s);
	}
}