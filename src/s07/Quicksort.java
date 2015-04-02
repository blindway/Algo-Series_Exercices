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
	  //choisir le premier élément comme pivot
	  // pour chaque case suivante i de left+1 à right{
	  //   si l'élément courant doit aller dans la partie grisée
	  //     agrandir la partie grisée, en échangeant les cases k+1 et i
	  //  }
	  //mettre le pivot à la fin de la partie grisée
	  //retourner la poistion de l'extrémité droite de la partie grisée
	  
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
