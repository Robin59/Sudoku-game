package graphismes;

import graphismes.menu.LoadGameItem;
import graphismes.menu.NewGameItem;
import graphismes.menu.SaveGameItem;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * This class contain the JMenuBar use in this game, the different JMenus and their items. 
 * @author robin
 *
 */
public class MenuG {
	
	private JMenuBar menu;
	private JMenu file;
	
	public MenuG (GrilleG grille){
		menu =new JMenuBar(); 
		file = new JMenu("fichier");
		menu.add(file, BorderLayout.WEST);
		//ajout des items du menu file
		file.add(new NewGameItem(grille));
		file.add(new SaveGameItem(grille));
		file.add(new LoadGameItem(grille));
	}
	
	/**
	 * return the JMenuBar menu
	 * @return the JMenuBar menu
	 */
	public Container getMenu (){
		return menu;
	}
	
}
