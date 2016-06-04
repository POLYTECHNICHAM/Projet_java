package sixcouleurs;

import edu.princeton.cs.introcs.StdDraw;

public class Grille1 {

	// attributs de la grille
	
	double size=0;
	
	// Constructeur par défault
	
	public Grille1 (){	
		size=13;
	}

	// Constructeur avec paramètres
	public Grille1(double Psize){
		
		size=Psize;
		double k=0;
		double pas=0;
		pas=0.9/(size);
		
		StdDraw.setPenColor(StdDraw.BLACK);		
		StdDraw.setPenRadius(0.009);

		while (k<0.9){
		StdDraw.line(0, k, 0.9, k);
		StdDraw.line(k, 0, k, 0.9);
		k=k+pas;
		StdDraw.show();
		}
	}	
}