package sixcouleurs;

import edu.princeton.cs.introcs.StdDraw;

public class Menu {
	
	public Menu(){
		
		
		StdDraw.text(0.5, 0.9, "LE JEU DES 6 COULEURS");
		StdDraw.rectangle(0.5,0.8,0.3,0.05);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.text(0.5, 0.8, "MENU");
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.rectangle(0.5,0.7,0.3,0.05);
		StdDraw.text(0.5, 0.7, "Human player V.S. Human player");
		StdDraw.rectangle(0.5,0.6,0.3,0.05);
		StdDraw.text(0.5, 0.6, "Human player V.S. Computer");
		StdDraw.rectangle(0.5,0.5,0.3,0.05);
		StdDraw.text(0.5, 0.5, "4 Human players");
		
		double positionX=0;
		double positionY=0;
		
		while(true){

			if (StdDraw.mousePressed()){

				positionX=StdDraw.mouseX();
				positionY=StdDraw.mouseY();				

				if(positionX<0.7 && positionX >0.3 && positionY<0.75 && positionY>0.65){
					StdDraw.clear();
					Grille1 grille_1 = new Grille1(13);
					Valeur_grille valeur_grille = new Valeur_grille(13,1,0);	
					
				}
				if(positionX<0.7 && positionX >0.3 && positionY<0.65 && positionY>0.55){
					StdDraw.clear();
					Grille1 grille_1 = new Grille1(13);	
					Valeur_grille valeur_grille = new Valeur_grille(13,1,1);
					
				}
				if(positionX<0.7 && positionX >0.3 && positionY<0.55 && positionY>0.45){
					StdDraw.clear();
					Grille1 grille_1 = new Grille1(13);
					Valeur_grille valeur_grille = new Valeur_grille(13,1,2);
					
				}
			}
		}
	}
	}
