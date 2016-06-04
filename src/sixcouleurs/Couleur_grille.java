package sixcouleurs;

import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Couleur_grille {
	
	// attributs de la grille
	
	double size=0;
	int [][]valeur_grille;
	int joueur;
	int menu_select;
	// Constructeur par défault
	
	public Couleur_grille (){	
		size=13;
		
	}

	// Constructeur avec paramètres
	public Couleur_grille(double Psize, int [][] pvaleur_grille, int pjoueur, int pmenu_select){
		joueur=pjoueur;
		menu_select=pmenu_select;
		size=Psize;
		valeur_grille=pvaleur_grille;
		
		affichage_graphique(size,valeur_grille, joueur, menu_select);
		
		affichage_console(valeur_grille);	

}

	public static void affichage_graphique(double size, int [][] tableau_color, int joueur, int menu_select){

		int size_int=(int)size;

		double pas=0;
		
		pas=0.9/(size);	
		//
		double x=0;
		double y=0;
 
		for(int i=0; i<size;i++){
			for(int j=0; j<size; j++){
				
				x=(j*pas);
				y=0.9-pas-(i*pas);

				if(tableau_color[i][j]==0){
				
					StdDraw.setPenColor(StdDraw.RED);	
				}	
				
				if(tableau_color[i][j]==1){
					
					StdDraw.setPenColor(StdDraw.GREEN);	
				}
				if(tableau_color[i][j]==2){
					
					StdDraw.setPenColor(StdDraw.CYAN);	
				}
				if(tableau_color[i][j]==3){
					
					StdDraw.setPenColor(StdDraw.ORANGE);	
				}
				if(tableau_color[i][j]==4){
					
					StdDraw.setPenColor(StdDraw.BLUE);	
				}
				if(tableau_color[i][j]==5){
					
					StdDraw.setPenColor(StdDraw.MAGENTA);	
				}

				StdDraw.filledSquare(x+(pas/2),y+(pas/2),((pas/2)-0.005));


			}}	

			// 2 joueurs
		if(menu_select==0 || menu_select==1){
			Palette palette1 = new Palette(tableau_color[0][0],tableau_color[size_int-1][size_int-1],size_int, tableau_color, joueur, menu_select);
		}
		
			// 4 joueurs
		if(menu_select==2){
			Palette1 palette2 = new Palette1(tableau_color[0][0],tableau_color[size_int-1][0],tableau_color[size_int-1][size_int-1], tableau_color[0][size_int-1],size_int, tableau_color, joueur,menu_select);
	}
		}
	public static void affichage_console(int [][] tableau_color){
	for (int i=0; i<tableau_color.length;i++){
		for (int j=0; j<tableau_color.length;j++){
			System.out.print("|"+tableau_color[i][j]+"|");
		}
		System.out.println();
	}
	System.out.print(tableau_color[0][0]);
	}
	

}