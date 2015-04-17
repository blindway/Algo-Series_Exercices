package s07;
import java.io.*;

public class ExternalSorting {
  public static void main(String [] args) {
    String filename = "myText.txt";
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
      // if needed, go to the next two monotone sequences
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
  }
  // ------------------------------------------------------------
  private static int split(String a, String b, String c) throws IOException {
	    BufferedReader fa = new BufferedReader(new FileReader(a));
	    PrintWriter    fb = new PrintWriter   (new FileWriter(b));
	    PrintWriter    fc = new PrintWriter   (new FileWriter(c));
	    
	    String line;
	    String linePrev = fa.readLine();
	    boolean inB = true;
	    int monotonieCount = 1;
	    
	    // test si c'est la 1ère ligne du fichier source
	    if (linePrev != null){
	      fb.println(linePrev);
	    }
	    
	    // Lis toutes les lignes du fichier
	    while((line = fa.readLine()) != null) {
	      
	      // si la ligne ne fait plus partie de la monotonie
	      if(!isMonotone(line, linePrev)){
	        inB = !inB;
	        monotonieCount++;
	      }
	      
	      // insertion de la ligne dans le fichier B ou C
	      if(inB){
	        fb.println(line);
	      }else{
	        fc.println(line);
	      }
	      
	      // la ligne "courante" devient la ligne précédente
	      linePrev = line;
	    
	    }
	    
	    
	    // fermeture des fichiers
	    fa.close(); fb.close(); fc.close();
	    System.out.println(linePrev);
	    return monotonieCount;
	    
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
      System.out.println(monotoneSeq);
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  // ------------------------------------------------------------
}
