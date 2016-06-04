package sixcouleurs;

import edu.princeton.cs.introcs.StdDraw;

public class Jouer {
	
	int joueur;
	int size;
	int[][] tab_color;
	int couleur_adverssaire=0;
	int couleur_joueur=0;
	int [][] tab_actuel_test;
	int menu_select;
	
	public Jouer(int psize, int pjoueur, int [][]ptableau, int pmenu_select){
		size=psize;
		joueur=pjoueur;
		tab_color=ptableau;
		tab_actuel_test=ptableau;
		menu_select=pmenu_select;
		int stop;
		int couleur_a_jouer=0;
		double positionX=0;
		double positionY=0;
		int start_cell=0;
		
		StdDraw.setPenColor(StdDraw.BLACK);	
		StdDraw.rectangle(0.945,0.95,0.05,0.05);
		StdDraw.text(0.945, 0.95, "MENU");

		while(true){
		
			if(joueur==2 && menu_select==1){

				StdDraw.setPenColor(StdDraw.WHITE);	
				StdDraw.filledRectangle(0.97,0.5,0.04,0.1);
				StdDraw.setPenColor(StdDraw.BLACK);	
				StdDraw.text(0.95,0.5,"joueur 1",90);
				
				IA ia = new IA(size,tab_color,2,menu_select);
			}
				
			if (StdDraw.mousePressed()){

				if (positionX==0 && positionY==0){
				positionX=StdDraw.mouseX();
				positionY=StdDraw.mouseY();
				

				if(positionX>0.895 && positionX<1 && positionY>0.9 && positionY<1){
					StdDraw.clear();
					Menu menu = new Menu();
				}

				if(joueur==1){
				
				StdDraw.setPenColor(StdDraw.WHITE);						
				StdDraw.filledRectangle(0.97,0.5,0.04,0.1);
				
				StdDraw.setPenColor(StdDraw.BLACK);	
				StdDraw.text(0.95,0.5,"joueur 2",90);	
				
				start_cell=0;
				int [][] case_controle=new int [size][size];
				case_controle [start_cell][start_cell]=1;	
				
				joueur=2;
				
				case_controle=proximité(start_cell,start_cell,size,tab_color,case_controle, start_cell);
				stop=fin_du_jeu(case_controle,size,0);
				if(stop>85){
					StdDraw.setPenColor(StdDraw.GREEN);	
					StdDraw.text(0.8,0.95,"joueur 1");	
				}
				couleur_choisie(tab_color, case_controle, positionX, positionY, tab_color[0][0], tab_color[start_cell][start_cell], start_cell, joueur, menu_select);
				}
				
				
				if(joueur==2 && menu_select==0){

					StdDraw.setPenColor(StdDraw.WHITE);						
					StdDraw.filledRectangle(0.97,0.5,0.04,0.1);
					
					StdDraw.setPenColor(StdDraw.BLACK);	
					StdDraw.text(0.95,0.5,"joueur 1",90);
					
					
					start_cell=size-1;
					int [][] case_controle=new int [size][size];
					case_controle [start_cell][start_cell]=1;
					
					positionX=StdDraw.mouseX();
					positionY=StdDraw.mouseY();		
					joueur=1;
					case_controle=proximité(start_cell,start_cell,size,tab_color,case_controle, start_cell);
					stop=fin_du_jeu(case_controle,size,0);
					if(stop>85){
						StdDraw.setPenColor(StdDraw.GREEN);	
						StdDraw.text(0.8,0.95,"joueur 2");	
					}
					couleur_choisie(tab_color, case_controle, positionX, positionY, tab_color[0][0],tab_color[start_cell][start_cell], start_cell, joueur,menu_select);
					}
				}
				}
			}
		}

	public static void couleur_choisie (int [][] tableau, int [][] case_controle, double positionX,double positionY, int couleur_joueur, int couleur_adverssaire, int start_cell,int joueur, int menu_select){
		
		double x=0.05;
		
		if(positionX > (0.1-x) && positionX < (0.1+x) && positionY > (0.95-x) && positionY < (0.95+x) && couleur_joueur!=0 && couleur_adverssaire!=0 ){
			tableau=next_tab(0,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);	
			StdDraw.filledRectangle(0.3,0.95,0.4,0.04);
			Couleur_grille couleur_grille = new Couleur_grille(13,tableau,joueur,menu_select);
		}
		
		if(positionX > (0.2-x) && positionX < (0.2+x) && positionY > (0.95-x) && positionY < (0.95+x) && couleur_joueur!=1 && couleur_adverssaire!=1 ){
			tableau=next_tab(1,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.3,0.95,0.4,0.04);
			Couleur_grille couleur_grille = new Couleur_grille(13,tableau,joueur,menu_select);
		}
		
		if(positionX > (0.3-x) && positionX < (0.3+x) && positionY > (0.95-x) && positionY < (0.95+x) && couleur_joueur!=2 && couleur_adverssaire!=2 ){
			tableau=next_tab(2,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.3,0.95,0.4,0.04);
			Couleur_grille couleur_grille = new Couleur_grille(13,tableau,joueur,menu_select);
		}
		
		if(positionX > (0.4-x) && positionX < (0.4+x) && positionY > (0.95-x) && positionY < (0.95+x) && couleur_joueur!=3 && couleur_adverssaire!=3 ){
			tableau=next_tab(3,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.3,0.95,0.4,0.04);
			Couleur_grille couleur_grille = new Couleur_grille(13,tableau,joueur,menu_select);
		}
		
		if(positionX > (0.5-x) && positionX < (0.5+x) && positionY > (0.95-x) && positionY < (0.95+x) && couleur_joueur!=4 && couleur_adverssaire!=4 ){
			
			tableau=next_tab(4,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.3,0.95,0.4,0.04);
			Couleur_grille couleur_grille = new Couleur_grille(13,tableau, joueur,menu_select);
		}
		
		if(positionX > (0.6-x) && positionX < (0.6+x) && positionY > (0.95-x) && positionY < (0.95+x) && couleur_joueur!=5 && couleur_adverssaire!=5 ){
			tableau=next_tab(5,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.3,0.95,0.4,0.04);
			Couleur_grille couleur_grille = new Couleur_grille(13,tableau, joueur,menu_select);
		}
	}
	public static int [][] proximité(int i , int j, int size, int [][]tab, int [][]case_controle, int start_cell){
		if(i<case_controle.length-1 && j<case_controle.length)
		if (tab[i+1][j]==tab[start_cell][start_cell] && case_controle[i+1][j]!=1){
			case_controle[i+1][j]=1;
			proximité(i+1,j,size,tab,case_controle, start_cell);
		}
		if(i>0 && j<case_controle.length){
		if (tab[i-1][j]==tab[start_cell][start_cell] && case_controle[i-1][j]!=1){
			case_controle[i-1][j]=1;
			proximité(i-1,j,size,tab,case_controle, start_cell);
		}}
		if(i<case_controle.length && j<case_controle.length-1){
		if (tab[i][j+1]==tab[start_cell][start_cell] && case_controle[i][j+1]!=1){
			case_controle[i][j+1]=1;
			proximité(i,j+1,size,tab,case_controle, start_cell);
		}}
		
		if(i<case_controle.length && j>0){
		if (tab[i][j-1]==tab[start_cell][start_cell] && case_controle[i][j-1]!=1){
			case_controle[i][j-1]=1;
			proximité(i,j-1,size,tab,case_controle, start_cell);
		}}
		
		return case_controle;
	}
	
	public static int [][] next_tab(int couleur_choisie, int [][]tableau, int [][] case_controle){
		
		for(int i=0; i< tableau.length; i++ ){
			for(int j=0; j< tableau.length; j++){
				if (case_controle[i][j]==1){
					tableau[i][j]=couleur_choisie;
				}
			}
		}
		return tableau;
	}
	
	public static int fin_du_jeu(int [][] case_controle, int size,int Nb_case_controle){
		
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if (case_controle[i][j]==1){
					Nb_case_controle=Nb_case_controle+1;
				}
			}
		}
		return Nb_case_controle;
	}
}
