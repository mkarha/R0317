package arvaaSanaGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PeliIkkuna {
	
	private JFrame ikkuna;
	private JLabel ratkaistava; //-----
	private JLabel ohje;	//Ohjeteksti
	private JButton tarkista;
	private JTextArea arvaus; //kirjoitusalue
	private JLabel kuva; //Kuva-alue
	private JLabel arvatut; //Arvatut kirjaimet
	private Kuva kuvat;
	private Sana sanat;
	private Paaikkuna paaikkuna;
	private JButton poistu;
	
	public void luoPeliIkkuna(String sana) { 
		this.kuvat = new Kuva();
		this.sanat = new Sana();
		this.paaikkuna = new Paaikkuna();
				
		//Luodaan 800x500 pikselin kokoinen ikkuna,
		//Sijoitetaan ikkuna keskelle näyttöä
		this.ikkuna = new JFrame();  
		this.ikkuna.setSize(800, 500);  
		this.ikkuna.setLocationRelativeTo(null);
		this.ikkuna.setTitle("Arvaa sana");
		
		//Luodaan paneeli kirjaimen valitsemiselle ja siihen liittyvälle ohjeelle sekä tarkistusnapille
		JPanel paneeli = new JPanel();
		BoxLayout paneeliasettelu = new BoxLayout(paneeli, BoxLayout.Y_AXIS);
		paneeli.setLayout(paneeliasettelu);
		
		//Luodaan alapaneeli arvatuille kirjaimille ja poistumisnapille
		JPanel alapaneeli = new JPanel();
		BorderLayout alaAsettelu = new BorderLayout();
		alapaneeli.setLayout(alaAsettelu);
		
		String piilosana = sanat.luoPiilosana(sana.length()); //luodaan arvotun sanan mittainen "viivasana"
			
		//Luodaan sisällöt	
		this.ratkaistava = new JLabel(piilosana);
		this.ratkaistava.setFont(ratkaistava.getFont().deriveFont((float) 60.0)); //----- koko
		this.ratkaistava.setBorder(new EmptyBorder(new Insets(10, 200, 0, 0))); //------n ympärille tyhjää reunaa
		this.ohje = new JLabel("syötä arvattava kirjain tekstikenttään");
		this.arvaus = new JTextArea();
		this.arvaus.setRows(1);
		this.arvatut = new JLabel("Arvattu: " + sanat.getArvatut());
		this.tarkista = new JButton("Tarkista"); //Tarkistusnamiska
		this.kuva = new JLabel(kuvat.getKuva());
		this.arvatut.setFont(arvatut.getFont().deriveFont((float) 30.0)); //arvattujen koko
		this.arvatut.setBorder(new EmptyBorder(new Insets(0, 20, 10, 0))); //reunat arvattujen ympärille
		this.poistu = new JButton("Palaa alkuun"); //Paluu nappi
		
		//Määritellään tyhjät reunat tekstinsyötön ympärille ja lisätään sisältö paneeliin
		paneeli.setBorder(new EmptyBorder(new Insets(150, 75, 150, 75)));
		paneeli.add(ohje);
		paneeli.add(arvaus);
		paneeli.add(tarkista);
			
		//Lisätään sisältö alapaneeliin
		alapaneeli.add(arvatut, BorderLayout.WEST);
		alapaneeli.add(poistu, BorderLayout.EAST);		
		
		//Mikäli arvauskentässä painetaan entteriä, suoritetaan tarkasta napin painallista vastaava toiminnallisuus
		this.arvaus.addKeyListener
	      (new KeyAdapter() {
	          public void keyPressed(KeyEvent k) {
	            int key = k.getKeyCode();	            
	            if (key == KeyEvent.VK_ENTER) {	            	           	
	            	String syote = arvaus.getText().replace("\n", "");
	            	arvaus.setText(syote);
	            	enter(sana);
	            }
	         }
	      });
		
		
		//Määritellään tarkista-napin toiminnallisuus
		this.tarkista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tarkistaPainettu(sana);
			}			
		});
			
		//määritellään poistu napin toiminnallisuus
		this.poistu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paaikkuna.luoIkkuna();
				paaikkuna.naytaIkkuna();
				ikkuna.setVisible(false);			
			}			
		});
		
		//Lisätään sisältö peli-ikkunaan
		this.ikkuna.add(ratkaistava, BorderLayout.NORTH);
		this.ikkuna.add(paneeli, BorderLayout.WEST);
		this.ikkuna.add(kuva, BorderLayout.EAST);
		this.ikkuna.add(alapaneeli, BorderLayout.SOUTH);
					
		this.ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.ikkuna.setVisible(true);		
	}
	
	
	
	//Enterin painalluksen määrittely
	private void enter(String sana) {
		if (sana.equals(this.sanat.getPiilosana()) || this.kuvat.getVirheet()==10) {
			poistu.doClick();
		}else
			tarkista.doClick();		
	}
	
	
	//Tarkista-napin ja arvauskentässä enterin käytännön toiminnnallisuus
	private void tarkistaPainettu(String sana) throws StringIndexOutOfBoundsException{ ////Poikkeuksen heitto muotoilunkäsittelyn vuoksi (Enterin poisto)
		String kirjain = this.arvaus.getText();
		kirjain = kirjain.replace("\n", "");
		char k = kirjain.charAt(0);
		if (kirjain.length()>1) {
			this.ohje.setText("Syötä vain yksi kirjain kerrallaan");
		}					
		else if (sanat.tarkastaSana(kirjain, 1)==false) {
			this.ohje.setText("Syötä ainoastaan kirjaimia a-z");
		}
		else if(sanat.getArvatut().contains(kirjain)) {
			this.ohje.setText("Olet jo arvannut " + kirjain + ":n. Valitse toinen kirjain");
		}
		else if (sanat.onkoKirjainta(sana.length(), k, sana)==false) {
			this.kuvat.lisaaVirhe();
			this.kuva.setIcon(kuvat.getKuva());
			this.arvatut.setText("Arvattu: " + sanat.getArvatut());
		}else {
			this.ratkaistava.setText(sanat.getPiilosana());
			this.arvatut.setText("Arvattu: " + sanat.getArvatut());
		}
		this.arvaus.setText(""); //Tyhjennetään arvaus-kentän teksti
		
		//Jos sana vastaa arvauksista muodostunutta sanaa
		if(sana.equals(this.sanat.getPiilosana())) {
			this.kuva.setIcon(kuvat.voitto()); //Haetaan voitto-kuva
			this.tarkista.setAction(null); //Poistetaan tarksita-napin toiminnallisuus
		}
		
		//jos virheraja saavutetaan
		if(this.kuvat.getVirheet()==10) {
			this.ratkaistava.setText(sana);
			this.tarkista.setAction(null);
			this.arvaus.setActionMap(null);
		}
		
		/*
		//Tarkistetaan onko enteristä jäänyt jämiä
		String testi = this.arvaus.getText();
		if(testi.charAt(0)==(KeyEvent.VK_ENTER)){
			this.arvaus.remove(KeyEvent.VK_ENTER);
		}
		*/
	}
	

}
