package graphismes.menu;

import graphismes.GrilleG;
import graphismes.listeners.NewGameListener;
import graphismes.listeners.SaveGameListener;

import javax.swing.JMenuItem;
/**
 * Un Item pour la sauvegarde d'une partie
 * @author robin
 *
 */
public class SaveGameItem extends JMenuItem {
	
	public SaveGameItem(GrilleG grille){
		super("Sauvegarde");
		this.addActionListener(new SaveGameListener(grille));
	}
}
