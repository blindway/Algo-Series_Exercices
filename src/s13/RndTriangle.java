package s13;

import java.util.Random;
import javafx.geometry.Point2D;
public class RndTriangle {
	public static void main(String[] args) {
		int nbOfExperiments = 1000000;
		Random r = new Random();
		if (args.length > 0)
			nbOfExperiments = Integer.parseInt(args[0]);
		System.out.println(rndTriangleAvgArea(r, nbOfExperiments));
	}

	// ============================================================
	public static double rndTriangleAvgArea(Random r, int nbOfExperiments) {
		double rslt = 0;
		int cmpt = 0;
		while (cmpt <= nbOfExperiments) {
			
			Point2D ptn1 = new Point2D(r.nextDouble(), r.nextDouble());
			Point2D ptn2 = new Point2D(r.nextDouble(), r.nextDouble());
			Point2D ptn3 = new Point2D(r.nextDouble(), r.nextDouble());
			
			rslt += 0.5 * Math.abs(ptn1.getX() * (ptn2.getY() - ptn3.getY())
					+ ptn2.getX() * (ptn3.getY() - ptn1.getY()) + ptn3.getX()
					* (ptn1.getY() - ptn2.getY()));
			cmpt++;
		}
		return rslt / nbOfExperiments;
	}
}