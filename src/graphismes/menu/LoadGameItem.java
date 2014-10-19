package graphismes.menu;

import graphismes.GrilleG;
import graphismes.listeners.LoadGameListener;

import javax.swing.JMenuItem;

public class LoadGameItem extends JMenuItem {

	public LoadGameItem (GrilleG grille){
		super("charger une Grille");
		this.addActionListener(new LoadGameListener(grille));
	}
}
