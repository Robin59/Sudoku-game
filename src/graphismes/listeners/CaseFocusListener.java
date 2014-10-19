package graphismes.listeners;

import graphismes.CaseG;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import model.GrilleModel;
/**
 * Cette classe gere la perte du focus clavier par une case et 
 * considère qu'on a fait la même action que si on apuyer sur enter (cad verifie la validité du coup joué)  
 * @author robin
 *
 */
public class CaseFocusListener implements FocusListener {
	
	private CaseG laCase;
	private GrilleModel grilleA;
	
	public CaseFocusListener (GrilleModel grilleA){
		this.grilleA = grilleA;
	}
	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		laCase = ((CaseG) e.getSource());
		if(!grilleA.coupValide(laCase.getx(), laCase.gety(), laCase.getText())){
			laCase.setText("");
		}
	}

}
