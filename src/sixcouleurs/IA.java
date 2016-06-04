package sixcouleurs;

import edu.princeton.cs.introcs.StdDraw;

public class IA {

	int size;
	int [][] tab_color;
	int [][] tab_actuel_test;
	int couleur_a_jouer=0;
	int menu_select;
	int player=0;
	
	
	public IA(int psize, int [][] ptab_color, int pplayer, int pmenu_select){
		
		size=psize;
		tab_color=ptab_color;
		tab_actuel_test=ptab_color;
		menu_select=pmenu_select;
		player=pplayer;
		int start_cellX=0;
		int start_cellY=0;
		int stop;
		if(menu_select==1 && player==1){
			start_cellX=0;
			start_cellY=0;
		}
		if(menu_select==1 && player==2){
			start_cellX=size-1;
			start_cellY=size-1;
		}

		int [][] case_controle=new int [size][size];
		case_controle [start_cellX][start_cellY]=1;
		
		
		case_controle=proximité(start_cellX,start_cellY,size,tab_color,case_controle, start_cellX, start_cellY);
		stop=fin_du_jeu(case_controle,size,0);
		if(stop>85){
			StdDraw.setPenColor(StdDraw.GREEN);	
			StdDraw.text(0.8,0.95,"joueur 2");	
		}
		couleur_a_jouer=couleur_choisie_test(tab_actuel_test,case_controle, tab_actuel_test[0][0], tab_actuel_test[start_cellX][start_cellY],start_cellX,start_cellY,size);
		couleur_choisie1(tab_color,case_controle, couleur_a_jouer,tab_actuel_test[0][0], tab_actuel_test[start_cellX][start_cellY],start_cellX,start_cellY,1,menu_select);
	}
	
	public static int [][] proximité(int i , int j, int size, int [][]tab, int [][]case_controle, int start_cellX, int start_cellY){
		if(i<case_controle.length-1 && j<case_controle.length)
		if (tab[i+1][j]==tab[start_cellX][start_cellY] && case_controle[i+1][j]!=1){
			case_controle[i+1][j]=1;
			proximité(i+1,j,size,tab,case_controle, start_cellX,start_cellY);
		}
		if(i>0 && j<case_controle.length){
		if (tab[i-1][j]==tab[start_cellX][start_cellY] && case_controle[i-1][j]!=1){
			case_controle[i-1][j]=1;
			proximité(i-1,j,size,tab,case_controle, start_cellX, start_cellY);
		}}
		if(i<case_controle.length && j<case_controle.length-1){
		if (tab[i][j+1]==tab[start_cellX][start_cellY] && case_controle[i][j+1]!=1){
			case_controle[i][j+1]=1;
			proximité(i,j+1,size,tab,case_controle, start_cellX, start_cellY);
		}}
		
		if(i<case_controle.length && j>0){
		if (tab[i][j-1]==tab[start_cellX][start_cellY] && case_controle[i][j-1]!=1){
			case_controle[i][j-1]=1;
			proximité(i,j-1,size,tab,case_controle, start_cellX,start_cellY);
		}}
		
		return case_controle;
	}
	public static int Nb_case_controle (int [][] case_controle, int size){
		int Nb_case_controle=0;
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if (case_controle[i][j]==1){
					Nb_case_controle=Nb_case_controle+1;
				}
			}
		}
		return Nb_case_controle;
	}
	public static int couleur_choisie_test (int [][] tableau, int [][] case_controle, int couleur_joueur, int couleur_adverssaire, int start_cellX,int start_cellY, int size){
		int [][]tab_fils;
		int [] nb_case_controle=new int [6];
		int couleur_a_jouer;
		
		// je tesste toute les couleurs
		for(int k=0;k<6;k++){
			int [][]new_case_controle=new int[size][size];
			int [][]case_controle_fils=new int[size][size];
			case_controle_fils[start_cellX][start_cellY]=1;

			if(k!=couleur_joueur && k!=couleur_adverssaire){
				
				tab_fils=next_tab1(k,tableau,case_controle);

				new_case_controle=proximité(start_cellX,start_cellY,size,tab_fils,case_controle_fils,start_cellX,start_cellY);

				nb_case_controle[k]=Nb_case_controle(new_case_controle,size);
			}
			
			else{
				nb_case_controle[k]=0;
			}
		}
		
		couleur_a_jouer=indice_valeurmax(nb_case_controle);
		return couleur_a_jouer;
	}	
	public static int [][] next_tab1(int couleur_choisie, int [][]tableau, int [][] case_controle){
		int [][] tableau_fils;
		tableau_fils=tableau;
		for(int i=0; i< tableau.length; i++ ){
			for(int j=0; j< tableau.length; j++){
				if (case_controle[i][j]==1){
					tableau_fils[i][j]=couleur_choisie;
				}
			}
		}
		return tableau_fils;
	}
	public static int indice_valeurmax(int [] tab){
		int indice_max=0;
		int valeur_max=0;
		
		for(int k =0; k<6; k++){
			if(tab[k] >= valeur_max){
				valeur_max=tab[k];
				indice_max=k;
			}
			
		}
		return indice_max;
	}
	public static void couleur_choisie1 (int [][] tableau, int [][] case_controle, int couleur_a_jouer, int couleur_joueur, int couleur_adverssaire, int start_cellX, int start_cellY, int joueur, int menu_select){
		
		double x=0.05;
		
		if(couleur_a_jouer ==0){
			tableau=next_tab(0,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);	
			StdDraw.filledRectangle(0.25,0.95,0.4,0.04);
			Couleur_grille couleur_grille1 = new Couleur_grille(13,tableau,joueur,menu_select);
		}
		
		if(couleur_a_jouer ==1){
			tableau=next_tab(1,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.25,0.95,0.4,0.04);
			Couleur_grille couleur_grille1 = new Couleur_grille(13,tableau,joueur,menu_select);
		}
		
		if(couleur_a_jouer ==2){
			tableau=next_tab(2,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.25,0.95,0.4,0.04);
			Couleur_grille couleur_grille1 = new Couleur_grille(13,tableau,joueur,menu_select);
		}
		
		if(couleur_a_jouer ==3 ){
			tableau=next_tab(3,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.25,0.95,0.4,0.04);
			Couleur_grille couleur_grille1 = new Couleur_grille(13,tableau,joueur,menu_select);
		}
		
		if(couleur_a_jouer ==4){
			
			tableau=next_tab(4,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.25,0.95,0.4,0.04);
			Couleur_grille couleur_grille1 = new Couleur_grille(13,tableau, joueur,menu_select);
		}
		
		if(couleur_a_jouer ==5 ){
			tableau=next_tab(5,tableau,case_controle);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.25,0.95,0.4,0.04);
			Couleur_grille couleur_grille1 = new Couleur_grille(13,tableau, joueur,menu_select);
		}

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
	public static int fin_du_jeu(int [][] case_controle, int size, int Nb_case_controle){
		
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