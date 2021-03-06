package s09;

public class IntStack {

	private int buf[];
	private int top;

	public IntStack() {
		this(10);
	}

	// PRE: cap must be > 0
	public IntStack(int cap) {
		assert(cap > 0);
		buf = new int[cap];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	// PRE: stack must not be empty
	public int top() {
		assert(!isEmpty());
		return buf[top];
	}

	// PRE: stack must not be empty
	public int pop() {
		assert(!isEmpty());
		int a = buf[top];
		top--;
		return a;
	}

	public void push(int x) {
		checkSize();
		top++;
		buf[top] = x;
	}

	private void checkSize() {
		if (top == buf.length - 1) {
			int[] t = new int[2 * buf.length];
			for (int i = 0; i < buf.length; i++)
				t[i] = buf[i];
			buf = t;
		}
	}
}
