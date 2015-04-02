package s07;
import java.io.*;

public class ExternalSorting {
  public static void main(String [] args) {
    String filename = "myFile.txt";
    if (args.length > 0) filename=args[0];
    mergeSort2(filename);
  }
  //------------------------------------------------------------
  // ------------------------------------------------------------
  private static boolean isMonotone(String crt, String prev) {
    if (crt  == null) return false;
    if (prev == null) return true;
    return (crt.compareTo(prev) >= 0);
  }
  // ------------------------------------------------------------
  private static void merge(String a, String b, String c) throws IOException {
    BufferedReader fa = new BufferedReader(new FileReader(a));
    BufferedReader fb = new BufferedReader(new FileReader(b));
    PrintWriter    fc = new PrintWriter(new FileWriter(c));
    String sa = fa.readLine(); String saPrev = sa;
    String sb = fb.readLine(); String sbPrev = sb;
    while (sa != null || sb != null) {
      // if needed, go to the next two monotone squences
      if (!isMonotone(sa, saPrev) && !isMonotone(sb, sbPrev)) {
        saPrev = sa; sbPrev = sb;
      }
      if (!isMonotone(sb, sbPrev) ||
           isMonotone(sa, saPrev) && sa.compareTo(sb) <= 0) {
        fc.println(sa); saPrev = sa; sa = fa.readLine();
      } else {
        fc.println(sb); sbPrev = sb; sb = fb.readLine();
      }
    }
    fa.close(); fb.close(); fc.close();
    // Un pseudo-code possible :
    //  tant qu'il reste des éléments à traiter
    //    si les 2 monotonies sont "en cours"
    //      choisir le plus petit élément
    //    si une des monotonies est terminée
    //      prendre l'élément de l'autre
    //    si les deux monotonies sont terminées
    //      en commencer 2 nouvelles
  }
  // ------------------------------------------------------------
  private static int split(String a, String b, String c) throws IOException {
    BufferedReader fa = new BufferedReader(new FileReader(a));
    PrintWriter    fb = new PrintWriter   (new FileWriter(b));
    PrintWriter    fc = new PrintWriter   (new FileWriter(c));
    return 0; // TODO: A COMPLETER
  }
  // ------------------------------------------------------------
  public static void mergeSort2(String filename) {
    String tmp1 = filename + ".tmp1"; // somewhat...
    String tmp2 = filename + ".tmp2"; // ...dangerous...
    int monotoneSeq;
    try {
      monotoneSeq = split(filename, tmp1, tmp2);
      while (monotoneSeq > 1) {
        merge(tmp1, tmp2, filename);
        monotoneSeq = split(filename, tmp1, tmp2);
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  // ------------------------------------------------------------
}
