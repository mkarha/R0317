import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PelaajatIkkuna extends Ikkuna{
	
	private Pelaaja pelaaja;
	private String tiedosto;
	private JFrame ponnahdus;
	private String nimiSyote, kuvaSyote;
	private KeyEvent k;
	private JTextField kayttaja, nimi, kuva;
	private HashMap<Pelaaja, ArrayList<String>> pelaajat;
	private ArrayList<String> tiedot; 	
	private ImageIcon tyhjaRuutu;

	//Luodaan ikkuna kieroksen pelaajatietoja varten
	public PelaajatIkkuna (int width, int height, String title, int monesko, int lkm, ArrayList<String> pelaajaTunnukset) {
		super(width, height, title);

		
		//luodaan uusi pelaajolio
		pelaaja = new Pelaaja();
		//Määritellään tiedosto pelaajatietojen tallennusta varten
		tiedosto = "pelaajat.txt";
		
		//Pneeli pääikkunan komponenttien asemointia varten
		JPanel paneeli = new JPanel();
		BoxLayout paneeliAsettelu = new BoxLayout(paneeli, BoxLayout.Y_AXIS); //Komponentit päällekkäin
		paneeli.setLayout(paneeliAsettelu);
		
		//Käyttäjätunnusosio. Käyttäjätunnuksen tulee olla yksilöllinen
		JLabel kayttajaLabel = new JLabel("Käyttäjätunnus: ");		//Infolabel
		kayttaja = new JTextField();								//Tekstikenttä tietoja varten
		JPanel kayttajaPaneeli = new JPanel();						//Asettelupaneeli
		BorderLayout kayttajaPaneeliAsettelu = new BorderLayout();	//Asemointityyli
		kayttajaPaneeli.setLayout(kayttajaPaneeliAsettelu);			//Asetetaan tyyli paneeliin
		kayttajaPaneeli.add(kayttajaLabel, BorderLayout.WEST);		//Label vasempaan reunaan
		kayttajaPaneeli.add(kayttaja, BorderLayout.CENTER);			//syöttökenttä keskelle
		kayttajaPaneeli.setBorder(new EmptyBorder(20, 50, 20, 50));	//Tyhjää reunoille
		
		//Nimiosio
		JLabel nimiLabel = new JLabel("Nimi: ");
		nimi = new JTextField();
		JPanel nimiPaneeli = new JPanel();
		BorderLayout nimiPaneeliAsettelu = new BorderLayout();
		nimiPaneeli.setLayout(nimiPaneeliAsettelu);
		nimiPaneeli.add(nimiLabel, BorderLayout.WEST);
		nimiPaneeli.add(nimi, BorderLayout.CENTER);
		nimiPaneeli.setBorder(new EmptyBorder(20, 50, 20, 50));
		
		//Pelaajan ikonikuvan osoite. Ikonikuvan kooksi määritellään jotain myöhemmin
		JLabel kuvaLabel = new JLabel("Pelaajaikonikuvan osoite: ");
		kuva = new JTextField();
		JPanel kuvaPaneeli = new JPanel();
		BorderLayout kuvaPaneeliAsettelu = new BorderLayout();
		kuvaPaneeli.setLayout(kuvaPaneeliAsettelu);
		kuvaPaneeli.add(kuvaLabel, BorderLayout.WEST);
		kuvaPaneeli.add(kuva, BorderLayout.CENTER);
		kuvaPaneeli.setBorder(new EmptyBorder(20, 50, 20,50));
		
		//Pelaajan pelivaluutan määrä. Alkuvaiheessa kaikille tervetuliaisbonuksena 50 raha
		JLabel rahaLabel = new JLabel("Rahatalletus: ");
		JLabel raha = new JLabel("Saat 50 rahaa tervetuliaisbonuksena");
		JPanel rahaPaneeli = new JPanel();
		BorderLayout rahaPaneeliAsettelu = new BorderLayout();
		rahaPaneeli.setLayout(rahaPaneeliAsettelu);
		rahaPaneeli.add(rahaLabel, BorderLayout.WEST);
		rahaPaneeli.add(raha, BorderLayout.CENTER);
		rahaPaneeli.setBorder(new EmptyBorder(20, 50, 20, 50));
		
		//Alareunan napit
		JButton lataa = new JButton("Lataa pelaaja");									//Käyttäjä voi ladata tallennetun hahmon käyttäjätunnuksella
		JButton tallenna = new JButton("Tallenna tiedot");								//Tallettaa hahmon käyttäjän syöttämillä tiedoilla
		JButton poistu = new JButton("Poistu");											//Paluu Tervetuloa ikkunaan
		JPanel nappiPaneeli = new JPanel();							
		BoxLayout nappiPaneeliAsettelu = new BoxLayout(nappiPaneeli, BoxLayout.X_AXIS);	//Asemoidaan napit vierekkäin
		nappiPaneeli.setLayout(nappiPaneeliAsettelu);
		nappiPaneeli.add(poistu);
		nappiPaneeli.add(lataa);
		nappiPaneeli.add(tallenna);

		//Luodaan syöttökenttien toiminnallisuus lisäämällä KeyListener	
		kayttaja.addKeyListener
	      (new KeyAdapter() {
	          public void keyPressed(KeyEvent k) {
	            int key = k.getKeyCode();	//otetaan näppäinkoodi talteen
	            lueKirjain(kayttaja, key);	//ajetaan luekirjain-aliohjelma muuttujina tekstikentän nimi sekä syötetty kirjain
	         }
	      
	      });
		
		nimi.addKeyListener
	      (new KeyAdapter() {
	          public void keyPressed(KeyEvent k) {
	            int key = k.getKeyCode();
	            lueKirjain(nimi, key);
	         }
	      
	      });
		
		kuva.addKeyListener
	      (new KeyAdapter() {
	          public void keyPressed(KeyEvent k) {
	            int key = k.getKeyCode();
	            lueKirjain(kuva, key);
	         }
	      
	      });
		
		//Luodaan toiminnallisuus napeille
		lataa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame ponnahdus = new JFrame();
				String pelaajanTunnus = JOptionPane.showInputDialog(ponnahdus, "Anna ladattavan pelaajan käyttäjätunnus.");
				
				if (pelaajanTunnus.length()>0) { //Mikäli ei anneta nimeä, ei lähdetä yrittämään latausta
					if (pelaaja.lataaPelaaja(pelaajanTunnus)==null){ 
						JOptionPane.showMessageDialog(ponnahdus,"Lataaminen epäonnistui.","Alert",JOptionPane.WARNING_MESSAGE);
		           		ponnahdus.setVisible(false);   
					}else {
						pelaaja = pelaaja.lataaPelaaja(pelaajanTunnus);
						JOptionPane.showMessageDialog(ponnahdus,"Pelaaja ladattu onnistuneesti.","Alert",JOptionPane.WARNING_MESSAGE);
		           		ponnahdus.setVisible(false); 
		           		jatketaan(monesko, lkm, pelaajaTunnukset);
					}
				}		
	
			}
						
		});
		
		tallenna.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int key= KeyEvent.VK_ENTER;						//Otetaan viimeinen kirjain syöttökentästä talteen näppäilemällä loppuun enter
				pelaaja.setKayttaja(lueKirjain(kayttaja, key));	//Käydään kunkin tekstikentän syöte läpi enterin kanssa
				pelaaja.setNimi(lueKirjain(nimi, key));
				pelaaja.setKuva(lueKirjain(kuva, key));
				pelaaja.setRaha(50);							//Asetetaan rahamäärä
				pelaaja.tallennaPelaaja(pelaaja);			//Talletetaan hahmon tiedot tiedostoon
				
				jatketaan(monesko, lkm, pelaajaTunnukset);				
			}			
		});
		
		poistu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TervetuloIkkuna tervetuloa = new TervetuloIkkuna(600, 400, "Tervetuloa Venttiin");
				tervetuloa.nayta();
				piilota();
			}			
		});
		
		paneeli.add(kayttajaPaneeli);
		paneeli.add(nimiPaneeli);
		paneeli.add(kuvaPaneeli);
		paneeli.add(rahaPaneeli);
		paneeli.add(nappiPaneeli);
		
		this.add(paneeli);
	}
	
		
	
	public String lueKirjain(JTextField textF, int key) {
		String syote;
        if (key == KeyEvent.VK_ENTER) {
        	syote = textF.getText().replace("\n", "");
        	textF.setText(syote);
        }else {
        	syote = textF.getText();
            System.out.println(syote);
        }
        return syote;
	}
	
	
	public void jatketaan(int monesko, int lkm, ArrayList<String> pelaajaTunnukset) {
		pelaajaTunnukset.add(pelaaja.getKayttaja());
		monesko++;
		if(lkm>1) {
			PelaajatIkkuna pelaajaNext = new PelaajatIkkuna(600, 400, "Pelaaja" + monesko, monesko, lkm-1, pelaajaTunnukset);
			pelaajaNext.nayta();
			piilota();		
		} else {
			pelaajaTunnukset.add("Jakaja");			
			Peli peli = new Peli(pelaajaTunnukset);
			peli.naytaPeli();
			piilota();										//piilotetaan ikkuna
		}
	}

}
