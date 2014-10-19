package model;
/**
 * The sudoku's grid model,
 * check if a played move is correct and keep the values in memory
 * @author robin
 *
 */
public class GrilleModel {

	private Integer[][] grille;
	
	public GrilleModel (){
		grille = new Integer[9][9];
	}
	
/**
 * Tell if a move is correct and change the value if it's the case, 
 * so be careful this method have sides effects
 * @param x the abscissa value of the square in the grid
 * @param y the ordinate value of the square in the grid
 * @param value the new value we try to add to the grid
 * @return true if the move is correct
 */
	// A REFAIRE !!!
	public boolean coupValide (int x, int y, String value){
		int valeur;
		// on transforme et verifie que la valeur est bien un int
		try{valeur = Integer.parseInt(value);}
		catch(NumberFormatException e){
			grille[x][y]= null;
			return false;
		}
		// on verifie que la valeur suit les regles du sudoku
		if(valeur<10 && valeur>0){
			// si la valeur n'a pas changé on ne fait rien et on retourne true
			if(grille[x][y]!=null && grille[x][y] == valeur){
				return true;
			}
			//on verifie que la valeur n'est pas déjà sur la ligne ou sur la même colone
			for(int i= 0; i<9; i++){
				if (grille[x][i]!= null && grille[x][i] == valeur){
					grille[x][y]= null;
					return false;
				}
				if (grille[i][y]!= null &&grille[i][y]== valeur){
					grille[x][y]= null;
					return false;
				}
			}
			//on verifie que la valeur n'est pas déjà dans le carré
				//on recupère les coordonées du carré
			int abs = x/3;
			int ord = y/3;
			for (int i=0;i<3;i++){
				for(int i2=0; i2<3;i2++){
					if (grille[i+abs*3][i2+ord*3]!= null && grille[i+abs*3][i2+ord*3] == valeur){
						grille[x][y]= null;
						return false;
					}
				}
			}
			// tous les tests on réussit, on change la valeur dans la grille et on renvoi true
			grille[x][y]=valeur;
			return true;
		}else{
			grille[x][y]= null;
			return false;
		}
	}

	/** 
	 * return a table with the values from the sudoku grid, the value null is change into 0
	 * @return table with the values from the sudoku grid, the value null is change into 0
	 */
	public int[] valeurs (){
		int [] rez = new int [81];
		for(int x=0; x<9; x++){
			for(int y=0; y<9; y++){
				if(grille[x][y] == null){
					rez[x*9+y] = 0;
				}else {
					rez[x*9+y] = grille[x][y];
				}
			}
		}
		return rez;
	}
	
	/** reset the sudoku grid*/
	public void reset (){
		for(int x=0; x<9; x++){
			for(int y=0; y<9; y++){
				grille[x][y] = null;
			}
		}
	}
}
