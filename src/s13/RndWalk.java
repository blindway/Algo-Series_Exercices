package s13;
import java.util.Random;
public class RndWalk {
  public static void main(String [] args) {
    int nbOfExperiments = 100000;
    int n=20;
    int leftChoicePercentage = 50;
    Random r = new Random();
    System.out.println(rndWalkMirrorAvgLength(r, n, leftChoicePercentage,
                                              nbOfExperiments));
  }
  //============================================================
  static double rndWalkMirrorAvgLength(Random r, int pointToReach, 
                                       int leftChoicePercentage,
                                       int nbOfExperiments) {
    int x, nbOfSteps =0;
    int total=0;
    for (int i=0; i<nbOfExperiments; i++) {
      x=0; nbOfSteps=0;
      while(x!=pointToReach) {
        
    	  int e = r.nextInt(100);
    	  
    	  //droite
    	  if(e < 55){
    		  
    		  x++;
    	  }
    	  //gauche
    	  else if(x != 0){
    		  
    		  x--;
    	  }
    	  
        nbOfSteps++;
      }
      total+= nbOfSteps;
    }
    return total/(double)nbOfExperiments;
  }
}
