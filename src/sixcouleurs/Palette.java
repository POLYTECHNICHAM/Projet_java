package sixcouleurs;

import edu.princeton.cs.introcs.StdDraw;

public class Palette {

	int couleur_adverssaire=0;
	int couleur_joueur=0;
	int size=0;
	int [][] tableau_color;
	int joueur;
	int menu_select;
	public Palette(int Pcouleur_joueur, int Pcouleur_adversaire, int Psize, int [][] ptableau_color,int  pjoueur, int pmenu_select){
		couleur_adverssaire=Pcouleur_adversaire;
		couleur_joueur=Pcouleur_joueur;
		size=Psize;
		tableau_color=ptableau_color;
		joueur=pjoueur;
		menu_select=pmenu_select;
		
		affichage_palette(palette(couleur_joueur,couleur_adverssaire));
		
		//2 joueurs
		if(menu_select==0 || menu_select==1){
		Jouer jouer = new Jouer (size, joueur, tableau_color,menu_select);
		}
		//4 joueurs
		if(menu_select==2){
		Jouer1 jouer1 = new Jouer1 (size, joueur,menu_select);
		}
	}
	

	public static int [] palette(int couleur_joueur, int couleur_adverssaire){
		int [] palette=new int [4];
		int i=0;
		int j=0;
		while(i<4){
			if(j!=couleur_adverssaire && j!=couleur_joueur){
				palette[i]=j;
				i=i+1;
				j=j+1;
			}
			else{
				j=j+1;
			}
		}
		
		return palette;}
	// on génére une palette de couleur sans les couleurs controlées par le joueur et sans ceux de l'adverssaire
	public static void affichage_palette(int [] palette){

		
		for(int i=0;i<4;i++){
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
				else{
					
				}
						
			}
		StdDraw.show();
		}
	}

