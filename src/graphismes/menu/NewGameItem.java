package graphismes.menu;

import graphismes.GrilleG;
import graphismes.listeners.NewGameListener;

import javax.swing.JMenuItem;
/**
 * Un MenuItem qui permet de faire une nouvelle partie de sudoku
 * @author robin
 *
 */
public class NewGameItem extends JMenuItem {

	public NewGameItem(GrilleG grille){
		super("Nouvelle partie");
		this.addActionListener(new NewGameListener(grille));
	}
	
	
	
}
