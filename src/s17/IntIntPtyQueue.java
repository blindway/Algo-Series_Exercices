package s17;

import java.util.Random;
import s11.IntQueueChained;

// ------------------------------------------------------------
public class IntIntPtyQueue {

	private IntQueueChained[] qt;
	private int size = 0;

	// or: private IntQueueArray[] qt;
	// ...
	// ------------------------------------------------------------
	// priorities will be in 0..theMaxPty
	public IntIntPtyQueue(int theMaxPty) {
		qt = new IntQueueChained[theMaxPty];
	}

	// ------------------------------------------------------------
	public boolean isEmpty() {
		/*
		 * alternative en O(n) sans variable. boolean resultat = false; for
		 * (IntQueueChained intQueueChained : qt) { if
		 * (!intQueueChained.isEmpty()) resultat = true; } return resultat;
		 */
		return size == 0;
	}

	// ------------------------------------------------------------
	// PRE: 0<=pty<maxPty
	public void enqueue(int elt, int pty) {
		size++;
		if (qt[pty] != null) {
			qt[pty].enqueue(elt);
		} else {
			qt[pty] = new IntQueueChained();
			qt[pty].enqueue(elt);
		}
	}

	// ------------------------------------------------------------
	// highest pty present in the queue.
	// PRE: ! isEmpty()
	public int consultPty() {
		int result = 0;
		for (int i = qt.length - 1; i > 0; i--) {
			if (qt[i] != null && !qt[i].isEmpty()) {
				result = i;
				break;
			}
		}
		return result;
	}

	// ------------------------------------------------------------
	// elt with highest (smallest) pty.
	// PRE: ! isEmpty()
	public int consult() {
		return qt[consultPty()].consult();
	}

	// ------------------------------------------------------------
	// elt with highest (smallest) pty.
	// PRE: ! isEmpty()
	public int dequeue() {
		size--;
		return qt[consultPty()].dequeue();
	}

	// ------------------------------------------------------------
	// ------------------------------------------------------------
	// ------------------------------------------------------------
	public static void main(String[] args) {
		Random r = new Random();
		long seed = r.nextInt(1000);
		r.setSeed(seed);
		System.out.println("Using seed " + seed);
		int n = 10000;
		if (args.length == 1)
			n = Integer.parseInt(args[0]);
		int p, e;
		IntIntPtyQueue pq = new IntIntPtyQueue(n);
		for (int i = 0; i < 10 * n; i++) {
			p = r.nextInt(n);
			pq.enqueue(p, p);
		}
		e = Integer.MIN_VALUE;
		for (int i = 0; i < 10 * n; i++) {
			p = pq.dequeue();
			ok(p >= e);
			e = p;
		}
		ok(pq.isEmpty());
		for (int i = 0; i < 10 * n; i++) {
			p = r.nextInt(n);
			pq.enqueue(p, p);
			p = r.nextInt(n);
			pq.enqueue(p, p);
			pq.dequeue();
		}
		e = Integer.MIN_VALUE;
		while (!pq.isEmpty()) {
			p = pq.dequeue();
			ok(p >= e);
			e = p;
		}
		System.out.println("Test passed successfully");
	}

	// ------------------------------------------------------------
	static void ok(boolean b) {
		if (b)
			return;
		throw new RuntimeException("property not verified: ");
	}
}
