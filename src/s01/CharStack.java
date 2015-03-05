package s01;

public class CharStack {
  private int              topIndex;
  private char[]           buffer;
  // -------------------------------------
  private static final int DEFAULT_SIZE = 10;

  // -------------------------------------
  public CharStack() {
    this(DEFAULT_SIZE);
  }

  // -------------------------------------
  public CharStack(int estimatedSize) {
    buffer = new char[estimatedSize];
    topIndex = -1;
  }

  // -------------------------------------
  public boolean isEmpty() {
    boolean resultat = false;
    if (topIndex == -1) {
      resultat = true;
    }
    return resultat;
  }

  // -------------------------------------
  public char top() {
    char resultat = '\0';
    if (topIndex >= 0){
    resultat = buffer[topIndex];
    }
    return resultat;
  }

  // -------------------------------------
  public char pop() {
    char result = buffer[topIndex];
    buffer[topIndex] = '\0';
    topIndex--;
    return result;
  }

  // -------------------------------------
  public void push(char x) {
    if (topIndex == buffer.length - 1) {
      char[] tabResult = new char[buffer.length * 2];
      int newTopIndex = topIndex;
      for (int i = buffer.length - 1; i >= 0; i--) {
        tabResult[i] = this.pop();
      }
      buffer = new char[tabResult.length];
      buffer = tabResult;
      topIndex = ++newTopIndex;
      buffer[topIndex] = x;
    } else {
      buffer[++topIndex] = x;
    }
  }

  // -------------------------------------

  public static void main(String[] args) {
    CharStack myStack = new CharStack();

    myStack.push('A');
    myStack.push('M');
    myStack.push('U');
    myStack.push('S');
    myStack.push('E');
    myStack.push('R');

    myStack.push('J');
    myStack.push('A');
    myStack.push('I');
    myStack.push('M');
    myStack.push('E');

    char c;
    c = myStack.pop();
    if (c != 'R')
      System.out.println("Perdu!1");
    c = myStack.pop();
    if (c != 'E')
      System.out.println("Perdu!2");

    if (myStack.isEmpty())
      System.out.println("Perdu!3");
    System.out.println(myStack.top());
  }
}
