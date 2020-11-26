package LevyLista;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;


import LevyLista.SQLLevytManager;
import LevyLista.ToimintoIkkuna;
import LevyLista.NaytaTulokset;

public class Main {
	
	// Alustetaan taulukko
	static ArrayList<Levy> levyHylly;

	public static void main(String[] args) throws ParseException{
		
		// Ladataan kirjat tietokannasta ja sijoitetaan kirjaHylly -muuttujaan
		levyHylly = SQLLevytManager.kaikkiLevyt();

				// Uutta ikkunaa piirrettäessä, välitetään kirjahyllyn sisältö mukana
				//JFrame ikkuna = new NaytaTulokset( levyHylly );
				//ikkuna.setVisible(true);
				
			
		ValintaIkkuna valinta = new ValintaIkkuna();
		
		valinta.nayta();

	}

}
