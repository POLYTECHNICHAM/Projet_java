package sixcouleurs;

import edu.princeton.cs.introcs.StdDraw;

public class Palette1 {
	int couleur_joueur1;
	int couleur_joueur2;
	int couleur_joueur3;
	int couleur_joueur4;
	int size=0;
	int [][] tableau_color;
	int joueur;
	int menu_select;
	
	public Palette1(int Pcouleur_joueur1, int Pcouleur_joueur2, int Pcouleur_joueur3, int Pcouleur_joueur4, int Psize, int [][] ptableau_color,int  pjoueur, int pmenu_select){
		couleur_joueur1=Pcouleur_joueur1;
		couleur_joueur2=Pcouleur_joueur2;
		couleur_joueur3=Pcouleur_joueur3;
		couleur_joueur4=Pcouleur_joueur4;
		size=Psize;
		tableau_color=ptableau_color;
		joueur=pjoueur;
		menu_select=pmenu_select;
		affichage_palette(palette(couleur_joueur1, couleur_joueur2, couleur_joueur3, couleur_joueur4));

		//4 joueurs
		Jouer1 jouer1 = new Jouer1 (size, joueur,menu_select);
		
		
	}
	

	public static int [] palette(int couleur_joueur1, int couleur_joueur2, int couleur_joueur3, int couleur_joueur4){
		int [] palette=new int [2];
		int i=0;
		int j=0;
		while(i<2){
			if(j!=couleur_joueur1 && j!=couleur_joueur2 && j!=couleur_joueur3 && j!=couleur_joueur4 ){
				palette[i]=j;
				i=i+1;
				j=j+1;
			}
			else{
				j=j+1;
			}
		}
		
		return palette;}
	// on génére une palette de couleur sans les couleurs controlées par le joueur et son adverssaire
	public static void affichage_palette(int [] palette){

		
		for(int i=0;i<2;i++){
				if(palette[i]==0){
					
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.filledSquare(0.1,0.95,0.03);
						
				}
				if(palette[i]==1){
					
					StdDraw.setPenColor(StdDraw.GREEN);	
					StdDraw.filledSquare(0.2,0.95,0.03);
				}
				if(palette[i]==2){
					
					StdDraw.setPenColor(StdDraw.CYAN);	
					StdDraw.filledSquare(0.3,0.95,0.03);
				}
				if(palette[i]==3){
					
					StdDraw.setPenColor(StdDraw.ORANGE);	
					StdDraw.filledSquare(0.4,0.95,0.03);
				}
				if(palette[i]==4){
					
					StdDraw.setPenColor(StdDraw.BLUE);	
					StdDraw.filledSquare(0.5,0.95,0.03);
				}
				if(palette[i]==5){
					
					StdDraw.setPenColor(StdDraw.MAGENTA);	
					StdDraw.filledSquare(0.6,0.95,0.03);
				}
			}
		}
	}


