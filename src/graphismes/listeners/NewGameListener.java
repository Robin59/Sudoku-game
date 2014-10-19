package graphismes.listeners;

import graphismes.GrilleG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**listener qui lance la methode newGame de la grille passé en constructeur*/
public class NewGameListener implements ActionListener {

	private GrilleG grille;
	
	public NewGameListener (GrilleG grille) {
		this.grille = grille;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		grille.newGame();
	}

}
