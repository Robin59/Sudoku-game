package graphismes;


import javax.swing.JTextField;

/**
 * A JTextField that represent a sudoku square
 * @author robin
 *
 */
public class CaseG extends JTextField {
	// les coordonées de la case dans le tableau (de 0 a 8)
	private int x;
	private int y;
	
	public CaseG (int x, int y){
		super();
		this.x = x;
		this.y = y;
		//this.setSize(10, 10);
	}
	
	public int getx (){
		return x;
	}
	public int gety (){
		return y;
	}
	

}
