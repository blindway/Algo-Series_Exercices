package s11;

import java.util.Random;

public class ObjQueue {

	// ======================================================================
	static class QueueNode {
		Object elt;
		QueueNode prev = null;

		// ----------
		QueueNode(Object elt) {
			this.elt = elt;
		}
	}

	// ======================================================================
	private QueueNode front;
	private QueueNode back;

	// ------------------------------
	public ObjQueue() {
	}

	// --------------------------
	public void enqueue(Object elt) {

		QueueNode chainz = new QueueNode(elt);

		if (isEmpty()) {
			back = chainz;
			front = chainz;
		} else {
			back.prev = chainz;
			back = chainz;
		}
	}

	// --------------------------
	public boolean isEmpty() {
		return back == null;
	}

	// --------------------------
	// PRE : !isEmpty()
	public Object consult() {
		return front.elt;
	}

	// --------------------------
	// PRE : !isEmpty()
	public Object dequeue() {
		Object e = front.elt;
		if (front == back) {
			back = null;
			front = null;
		} else {
			front = front.prev;
		}
		return e;
	}

	// --------------------------
	public String toString() {
		String res = "";
		QueueNode c = front;
		while (c != null) {
			res += c.elt + " ";
			c = c.prev;
		}
		return res;
	}

	// ======================================================================
	// ======================================================================
	public static void main(String[] args) {
		int n = 1000000;
		if (args.length == 1)
			n = Integer.parseInt(args[0]);
		Random r = new Random();
		long seed = r.nextInt(1000);
		r.setSeed(seed);
		System.out.println("Using seed " + seed);
		ObjQueue q = new ObjQueue();
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
					int e = (int) q.dequeue();
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