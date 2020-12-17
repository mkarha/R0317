package myFirstGui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Paaikkuna {
	
	public void luoIkkuna() {

		//Luodaan 800x500 pikselin kokoinen p‰‰ikkuna, jonka title on "Eka ikkuna"
		//Sijoitetaan ikkuna keskelle n‰yttˆ‰
		JFrame paaikkuna = new JFrame();  
		paaikkuna.setSize(800, 500);  
		paaikkuna.setTitle("Ventti");
		paaikkuna.setLocationRelativeTo(null);
		
		//M‰‰ritell‰‰n p‰‰ikkunan layoutiksi BorderLayout
		BorderLayout sijoittelija = new BorderLayout();  
		paaikkuna.setLayout(sijoittelija);
		
		JPanel paneeli = new JPanel();
		BorderLayout paneeliSijoittelija = new BorderLayout();
		
		//Esittelyteksti	
		String esittelyteksti = 
		"Tervetuloa ArvaaSana-peliin!\n"+
		"Pelin ideana on arvata kirjaimia ja niiden avulla selvitt‰‰\n"+
		"piilossa oleva sana.\n"+
		"Mik‰li arvaamaasi kirjainta ei lˆydy sanasta, virhetilisi karttuu.\n"+
		"Yli 10 v‰‰r‰‰ arvausta ja kuolo korjaa.\n"+
		"Onnea peliin!\n\n";
		
		JLabel otsikko = new JLabel("Arvaa sana");
		JLabel esittely = new JLabel(esittelyteksti);
		
		JButton poistu = new JButton("Poistu");
		JButton arvoSana = new JButton("Arvo sana");
		JButton omaSana = new JButton("Oma sana");


		
		paaikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		paaikkuna.setVisible(true);
			
	}

}
