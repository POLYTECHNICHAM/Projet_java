package sixcouleurs;

import java.util.Random;

public class Valeur_grille {
	
		int size;
		static int [] [] valeur_grille;
		int joueur;
		int menu_select;
	
		public Valeur_grille(int psize, int pjoueur, int pmenu_select){
			
			size=psize;
			joueur=pjoueur;
			menu_select=pmenu_select;
			valeur_grille=tableau_grille(size);
			
			Couleur_grille couleur_grille1 = new Couleur_grille(size,valeur_grille,joueur,menu_select);
			
			
		}
		
		public static int [][] tableau_grille(int size){

			int [][] grille= new int [size][size];
			
			for(int i=0; i<size;i++){
				for(int j=0; j<size; j++){
					Random rand = new Random();
					int nb = rand.nextInt(5 - 0 + 1) + 0;
					
					grille[i][j]=nb;
				}
			}
			
			return grille;}
}
