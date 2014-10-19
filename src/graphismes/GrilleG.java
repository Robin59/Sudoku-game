package graphismes;

import graphismes.listeners.CaseFocusListener;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;


import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GrilleModel;




/**
 * 
 * @author robin
 * The main graphical representation of the sudoku's grid and is menu
 * 
 */
public class GrilleG {
	
	private JFrame laGrille;
	private Container conteneurGrille;
	private CaseG[][] cases;
	private CaseActionListener caseListener;
	private CaseFocusListener caseFocusListener;
	private GrilleModel grilleAbs;
	
	public GrilleG(){
		laGrille = new JFrame("Sudoku par Robin  0.1");
		laGrille.setSize(new Dimension(450,450));
		//construction d'une nouvelle grille abstraite
		grilleAbs = new GrilleModel();
		//menu
		laGrille.add((new MenuG(this)).getMenu(), BorderLayout.NORTH);
		//construction des listeners
		laGrille.addWindowListener(new FermeWindowEvent());
		caseListener =new CaseActionListener();
		caseFocusListener =new CaseFocusListener(grilleAbs);
		// construction de la grille 
		this.constructionGrille();
		
		//// on rend le tout visible
		laGrille.setVisible(true);
		
		
	}
	
	/*private method that is just use in the constructor*/
	private void constructionGrille () {
		// creation du JPanel qui contient la grille
		conteneurGrille = new JPanel();
		conteneurGrille.setPreferredSize(new Dimension(420,420));
		conteneurGrille.setLayout(new GridBagLayout());
		//l'outil pour positionner
		 GridBagConstraints gbc = new GridBagConstraints();
		 gbc.fill =GridBagConstraints.BOTH;
		 gbc.weightx=1;
		 gbc.weighty=1;
		 //La taille en hauteur et en largeur
		 gbc.gridheight = 1;
		 gbc.gridwidth = 1;
		 //compte les separateurs ajoutés
		 int sepX= 0;
		
		// we create and add the boxes
		cases = new CaseG[9][9];
		for(int x=0; x<9; x++){
			int sepY= 0;
			for(int y=0; y<9; y++){
				//on definit la position
				gbc.gridx = y+sepY;
			    gbc.gridy = x+sepX;
			    // la dim
			    gbc.ipady = 40; 
			    gbc.ipadx = 40; 
				// on créer la case
				cases[x][y] =new CaseG(x,y);
				cases[x][y].addActionListener(caseListener);
				cases[x][y].addFocusListener(caseFocusListener);
				conteneurGrille.add(cases[x][y],gbc);
				//ajouter la colonne de demarcation toutes les 3 cases
				if(y==2 || y==5){
					 gbc.ipady = 0; 
					 gbc.ipadx = 0; 
					sepY++;
					gbc.gridx = y+sepY;
				    gbc.gridy = x+sepX;
					conteneurGrille.add(new Label(), gbc);
				}
			}
			//ajouter la ligne de demarcation toutes les 3 cases
			if(x==2 || x==5){
				 gbc.ipady = 0; 
				 gbc.ipadx = 0; 
				sepX++;
				gbc.gridy = x+sepX;
				conteneurGrille.add(new Label(),gbc);
			}
		}
		// on ajoute la grille au JFrame
		laGrille.add(conteneurGrille);	
	}
	
	/** method that reset the grid*/
	public void newGame (){
		// on reinitialise graphiquement
		for(int x=0; x<9; x++){
			for(int y=0; y<9; y++){
				cases[x][y].setText("");
			}
		}
		// on reinitialise la grilleAbs
		grilleAbs.reset();
	}
	
	/**
	 * return the values of the grid
	 * @return the values of the grid 
	 */
	public int[] getValeurs(){
		return grilleAbs.valeurs();
	}
	
	/** change the values of the sudoku's grid, the value's validity is checked for each value
	 * @param valeurs the values that are load to the sodoku's grid, 81 numbers from left to right then bottom to top 
	 * the zero value is for the absence of value in a square
	 * */
	public void setValeurs(int[] valeurs){
		//on vide la grille
		this.newGame();
		// on met les nouvelles valeurs
		for (int i=0; i<81;i++){
			if(grilleAbs.coupValide(i/9, i%9, String.valueOf(valeurs[i]))){
				cases[i/9][i%9].setText(String.valueOf(valeurs[i]));
			}
		}
	}
	
	// pour le ENTRE sur le textfield
		private class CaseActionListener implements ActionListener {
			CaseG laCase;
			public void actionPerformed(ActionEvent e) {
				// on recupère la case qui a envoyée l'event
				laCase = ((CaseG) e.getSource());
				if(!grilleAbs.coupValide(laCase.getx(), laCase.gety(), laCase.getText())){
					laCase.setText("");
				}
			}
		}
	
		// classe Listener pour quitter le logiciel quand on click sur la  croix
		private class FermeWindowEvent extends WindowAdapter {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		} 
	
	
}
