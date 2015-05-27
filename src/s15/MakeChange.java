package s15;
public class MakeChange {
  //============================================================
  static final int coins[] = {1, 2, 5, 10, 21, 25};
  //============================================================
  // Change Problem : Recursive Version
  //============================================================
  public static int makeChange(int k) {
    int minCoins = k+1;
    if (k==0)    return 0;
    for (int j=0; j<coins.length; j++) {             //
      if (k - coins[j] < 0) continue;                //
      int thisCoins = makeChange(k - coins[j]);      //
      if (thisCoins < minCoins)                      //
        minCoins = thisCoins;                        //
    }                                                //
    return minCoins + 1;
  }
  //============================================================
  // Change Problem : Dynamic Programming Version
  //============================================================
  public static int makeChangeDyn(int k0) {
    int [] makeChangeSol = new int[k0+1];
    makeChangeSol[0] = 0;
    for (int k=1; k<=k0; k++) {
      int minCoins = k0+1;
      for (int j=0; j<coins.length; j++) {           //
        if (k - coins[j] < 0) continue;              //
        int thisCoins = makeChangeSol[k - coins[j]]; //
        if (thisCoins < minCoins)                    //
          minCoins = thisCoins;                      //
      }                                              //
      makeChangeSol[k] = minCoins + 1;
      //System.out.println(k + "  " + (minCoins+1));
    }
    return makeChangeSol [k0];
  }
  //============================================================
  // Main
  //============================================================
  public static void main (String [] args) {
    int [] t = {12,19,21,46,63};
    for (int i=0; i<t.length; i++) {
      int r = makeChangeDyn(t[i]);
      System.out.println(t[i]+ " change in "+r+" coins");
    }
  }
}
