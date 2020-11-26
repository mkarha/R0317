package LevyLista;

import javax.swing.JFrame;

public class Ikkuna extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	//konstruktori
	public Ikkuna (int width, int height, String title) {
		this.setSize(width, height);;
		this.setTitle(title);
		this.setLocationRelativeTo(null);
	}
	
	//konstruktori
	public Ikkuna () {
		this.setSize(800, 400);
		this.setTitle("Levytietokanta");
		this.setLocationRelativeTo(null);
	}
		
	//n‰yt‰-metodilla n‰ytet‰‰n ikkuna
	public void nayta() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		this.setVisible(true);
	}	
	

	//Leveyden setteri
	public void setWidth(int width) {
	}


	//Korkeuden setteri
	public void setHeight(int height) {
	}

	

	//Piilottaa ikkunan sulkematta ohjelmaa kokonaan
	public void piilota() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		this.setVisible(false);
	}
	
	//Sulkee ikkunan
	public void sulje() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(false);
	}
	
	
	//Poistuu koko ohjelmasta ja sulkee kaikki ohjelmaan liittyv‰t kuuntelijat
	public void poistu() {
		System.exit(0);
	}
	

}

	

