package graphismes.listeners;

import graphismes.GrilleG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveGameListener implements ActionListener {

	GrilleG grille;
	FileOutputStream saveFile;
	String saveName;
	
	public SaveGameListener (GrilleG grille){
		this.grille = grille;
		saveName = "test";
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// ouvrir un fichier de pour la sauvegarde
		try {
			saveFile =  new FileOutputStream(new File(saveName+".save"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// on recupère les valeurs du tableau
		int[] valeurs = grille.getValeurs();
		// on ecrit dans le fichier 
		for (int i = 0; i<81; i++){
			try {
				saveFile.write(valeurs[i]); } catch (IOException e1) {}
		}
		

	}

}
