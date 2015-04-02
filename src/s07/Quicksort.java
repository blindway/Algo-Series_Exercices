package s07;
public class Quicksort {
  public static void main(String [] args) {
    int [] t = {4, 3, 2, 6, 8, 7};
    int [] u = {2, 3, 4, 6, 7, 8};
    quickSort(t);
    for (int i=0; i<t.length; i++) 
      if(t[i] != u[i]) {
        System.out.println("Oups. Something is wrong...");
        System.exit(-1);
      }
    System.out.println("OK. Tiny test passed...");
  }
//------------------------------------------------------------
  private static int partition (int [] t, int left, int right) {
	  //choisir le premier �l�ment comme pivot
	  // pour chaque case suivante i de left+1 � right{
	  //   si l'�l�ment courant doit aller dans la partie gris�e
	  //     agrandir la partie gris�e, en �changeant les cases k+1 et i
	  //  }
	  //mettre le pivot � la fin de la partie gris�e
	  //retourner la poistion de l'extr�mit� droite de la partie gris�e
	  
    return 0; // A COMPLETER
  }
//------------------------------------------------------------
  private static void quickSort (int [] t, int left, int right) {
    if (left>right)
      return;
    int p = partition(t, left, right);
    quickSort(t, left, p-1);
    quickSort(t, p+1, right);
  }
//------------------------------------------------------------
  public static void quickSort (int [] t) {
    quickSort(t, 0, t.length - 1);
  }
}
