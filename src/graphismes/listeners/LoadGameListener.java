package graphismes.listeners;

import graphismes.GrilleG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/** 
 * Listener qui charge les données d'un fichier save sudoku et les charges dans la grille  
 * @author robin
 *
 */
public class LoadGameListener implements ActionListener  {

	private String fileName;
	private FileInputStream file;
	private GrilleG grille;
	
	public LoadGameListener (GrilleG grille){
		this.grille = grille;
		fileName = "test";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// on ouvre le fichier à charger
		try {
			file = new FileInputStream( new File(fileName+".save"));
		} catch (FileNotFoundException e1) {
			System.out.println("fichier "+fileName+" non trouvé"); // a changer par un pop-up qui envoit le mess
		}
		//on charge les données en memoire
		int[] valeur = new int[81];
		for (int i = 0; i<81; i++){
			try {
				valeur[i] = file.read();
			} catch (IOException e1) {}
		}
		//on renvoit les données a la grille
		grille.setValeurs(valeur);
	}

}
