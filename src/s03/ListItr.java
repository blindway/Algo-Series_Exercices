package s03;

public class ListItr {
  List list;
  ListNode pred, succ;

  // ----------------------------------------------------------
  public ListItr(List anyList) {
    list = anyList;
    goToFirst();
  }

  // ----------------------------------------------------------
  public void insertAfter(int e) {
    ListNode aux = new ListNode(e, pred, succ);
    if (pred == null && succ != null) {
      list.first = aux;
      succ.prev = aux;
    } else if (pred == null && succ == null) {
      list.first = aux;
      list.last = aux;
    } else if (pred != null && succ == null) {
      list.last = aux;
      pred.next = aux;
    } else {
      pred.next = aux;
      succ.prev = aux;
    }
    list.size++;
    succ = aux;
    pred = aux.prev;
  }

  // ----------------------------------------------------------
  public void removeAfter() {
    if (pred == null && succ != null && succ.next != null) {
      succ.next.prev = null;
      list.first = succ.next;
    } else if (pred == null && succ != null && succ.next == null) {
      list.first = null;
      list.last = null;
      succ = null;
    } else if (pred != null && succ != null && succ.next != null) {
      succ.next.prev = pred;
      pred.next = succ.next;
    } else if (pred != null && succ != null && succ.next == null) {
      list.last = pred;
      pred.next = null;
    }
    list.size--;
  }

  // ----------------------------------------------------------
  public int consultAfter() {
    return succ.elt;
  }

  public void goToNext() {
    pred = succ;
    succ = succ.next;
  }

  public void goToPrev() {
    succ = pred;
    pred = pred.prev;
  }

  public void goToFirst() {
    succ = list.first;
    pred = null;
  }

  public void goToLast() {
    pred = list.last;
    succ = null;
  }

  public boolean isFirst() {
    return pred == null;
  }

  public boolean isLast() {
    return succ == null;
  }
}

// When isFirst(), it is forbidden to call goToPrev()
// When isLast(), it is forbidden to call goToNext()
// When isLast(), it is forbidden to call consultAfter(), or removeAfter()
// For an empty list, isLast()==isFirst()==true
// For a fresh ListItr, isFirst()==true
// Using multiple iterators on the same list is allowed only
// if none of them modifies the list