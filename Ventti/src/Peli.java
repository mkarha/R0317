import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Peli {
	
	private int pelaajia, vuoro, monesko;
	private String pelaaja, arvo;
	private ArrayList<String> pelaajat;
	private HashMap<String, Kasi> pelaajienKadet;
	private HashMap <Integer, JLabel> korttiRuudut;
	private Pakka pakka;
	private Kortti kortti;
	private Kasi kasi;
	private PeliIkkuna peliIkkuna;
	private ImageIcon kuva;
	private boolean loppu;
	
	//Luodaan uusi peli pelaajat taulukon pelaajilla
	public Peli(ArrayList<String> pelaajat) {
		this.pelaajia = pelaajat.size(); //montako pelaajaa
		this.pelaajat = pelaajat; //taulukko myös alametodien käyttöön		
		
		//luodaan pelaajille nimikohtaiset kädet 
		this.pelaajienKadet = new HashMap<>();
		for (int i=0; i<this.pelaajia; i++) {	//luodaan jokaiselle pelaajalle oma käsi
			this.kasi = new Kasi();
			this.kasi.setArvo(0); //Asetetaan kunkin pelaajan käden arvoksi 0
			this.pelaajienKadet.put(this.pelaajat.get(i), this.kasi); //pelaajat ja kädet talteen
		}
		
		//Luodaan näytettäville korteille ruudut, joita hallitaan pelistä
		korttiRuudut = new HashMap <>();
		for (int i=1; i<10; i++) { //max korttimäärä 9
			JLabel label = luoTyhjaRuutu(); //alustetaan kaikki ruudut tyhjiksi
			korttiRuudut.put(i, label); //korttiruudut talteen
		}
	
		
		this.pakka = new Pakka(); //otetaan uusi pakka
		this.vuoro = 0; //vuoro alussa 0
		this.monesko = 0; //korttimäärä alussa 0
		this.arvo = ""; //arvo palautetaan tekstimuodossa lab elille. Alku arvo tyhjä + int arvo 0
		this.peliIkkuna = new PeliIkkuna(1280, 800, "Ventti", pelaajat, korttiRuudut, this);  //luodaan uusi peli-ikkuna 
		this.loppu = false;
	}
	
		
		//Luodaan tyhjät ruudut korttien paikoille ennen jakoa
		public JLabel luoTyhjaRuutu() {
			try { //yritetään ladata tyhjä kuva
				kuva = new ImageIcon(this.getClass().getResource("/kuvat/tyhja.png"));
			}
			catch (Exception e) {
				
			}
			JLabel label = new JLabel(kuva);
			label.setBorder(new EmptyBorder(50, 20, 50, 10));
			return label;
		}
		
		
		public JLabel lisaaPelaajanKuva(Pelaaja pelaaja) {
			try { //yritetään ladata kuva
				kuva = pelaaja.getKuva();
			}
			catch (Exception e) {
				
			}
			JLabel label = new JLabel(kuva);
			return label;
		}
	
		
	//Ajetaan uusi peli-ikkuna ruutu
	public void naytaPeli() {
		peliIkkuna.nayta();
	}
	
	
	/*Pelimekaniikka
	*
	*Uuden kortin nostaminen. Suoritetaan kun pelaaja painaa peli-ikkunasa "nosta"-nappia
	*Jakaja suorittaa metodin jokaisen kortin kohdalla
	**/
	public void nostaKortti() {
		monesko++;													//lisätään kädessä olevien korttien määrää
		this.pelaaja = this.pelaajat.get(0);						//Pelaaja pelaajat vuorossa oleva pelaaja
		int indeksi = (int)(Math.random()*(this.pakka.getKorttejaPakassa()));	//Arvotaan indeksi pakassa jäljellä olevista korteista
		this.kortti = this.pakka.jaaKortti(indeksi);						//jaetan kortti
		korttiRuudut.put(monesko, peliIkkuna.lisaaPelaajanKuva(this.kortti.getKuvaLahde()));
		this.pakka.poistaKorttiPakasta(indeksi);							//poistetaan jaettu kortti pakasta
		this.kasi = this.pelaajienKadet.get(this.pelaaja);				//ladataan kierroksen pelaajan käsi
		this.kasi.lisaaKortti(this.kortti);									//Lisätään käteen jaettu kortti
		this.pelaajienKadet.put(this.pelaaja, this.kasi);				//Talletetaan pelaajatunnuksen mukaan käsi
		this.kasi = this.pelaajienKadet.get(this.pelaaja);				//ladataan kierroksen pelaajan käsi päivitettynä
		peliIkkuna.sulje();
		peliIkkuna = new PeliIkkuna(1280, 800, "Ventti", pelaajat, korttiRuudut, this);
		naytaPeli();
		//mikäli päivitetyn käden arvo on yli 21 vaihdetaan vuoroa
		if (this.kasi.getArvo()>21) {									
			lopetaVuoro();			
		}
	}
	
	
	
	/*Vuoron lopetus
	*suoritetaan kun pelaaja painaa"jää"-nappia peli-ikkunassa
	*
	*Katsotaan kuka on seuraavana vuorossa. Jos vuorossa on jakaja, suoritetaan jakajan toiminnot.
	*Uusi vuoro. Lisätään vuoro-muuttujan arvoa ja kerrotaan seuraava pelaaja ponnahdusikkunassa.
	*Järjestetään pelaajien järjestys uusiksi peli-ikkunan paikkojen vaihtoa varten
    *Siirretään ensimmäinen pelaaja taulukon loppuun.
    *Lopuksi määritetään kädessä olevien korttien määräksi 0 ja alustetaan korttiruudut tyhjiksi.
	**/
	public void lopetaVuoro() {
		pelaaja = this.pelaajat.get(1); 		
		if (this.pelaajat.get(0).equals("Jakaja")) {   			
			jakajanVuoro();
		}else if(this.vuoro<this.pelaajia) { 
			this.vuoro++;		
			JFrame ponnahdus = new JFrame(); 
			JOptionPane.showMessageDialog(ponnahdus, pelaaja, "Alert",JOptionPane.WARNING_MESSAGE);
       		ponnahdus.setVisible(false); 
			this.pelaajat.add(this.pelaajat.get(0));			
			this.pelaajat.remove(0);
			this.monesko = 0;
       		for (int i=0; i<korttiRuudut.size(); i++) {
       			ImageIcon kuva = null;
       			try { //yritetään ladata tyhjä kuva
       				kuva = new ImageIcon(this.getClass().getResource("/kuvat/tyhja.png"));
       			}
       			catch (Exception e) {
       				
       			}
       			JLabel label = new JLabel(kuva);
       			label.setBorder(new EmptyBorder(50, 20, 50, 10));
       			korttiRuudut.put(i, label);
       		}       		
       		peliIkkuna.sulje();
       		peliIkkuna = new PeliIkkuna(1280, 800, "Ventti", pelaajat, korttiRuudut, this);
    		naytaPeli();
		}
	}
	
	
	//Jakajan toiminta
	/*Alustetaan muuttujat isoinarvo ja verrokki käsien arvon vertailua varten ja isoin pelaaja muuttuja 
	 * voittajavertailua varten.
	 * Jakaja on pelaajat taulukon 0. alkio. Käydään läpi alkiot 1:stä taulukon loppuun.
	 * Kopioidaan kunkin luettavan alkion pelaajan käden arvo verrokki muuttujaan.
	 * Mikäli verrokki on suurempi kuin isoinarvo ja pienempi tai yhtäsuuri kuin 21, kopioidaan se 
	 * isoimmaksi arvoksi.
	 * Jakaja nostaa kortteja siihen saakka, kunnes jakajan käden arvo on sama tai suurempi kuin 
	 * isoin arvo tai jakaja menee yli 21.
	 * Lopuksi käynnistetään voittaja-metodi.
	 */
		public void jakajanVuoro() {
			int isoinArvo = 0;
			int verrokki = 0;
			for (int i=1; i<this.pelaajia; i++) {
				verrokki = this.pelaajienKadet.get(this.pelaajat.get(i)).getArvo();
				if (verrokki < 22 && verrokki > isoinArvo) {
					isoinArvo = verrokki;
				}
			}		
			while (isoinArvo > this.pelaajienKadet.get("Jakaja").getArvo() && this.pelaajienKadet.get("Jakaja").getArvo()<22){
				nostaKortti();
			}	
		voittaja();			
		}
		
		/*Tarkistetaan voittaja.
		 * Alustetaan isoin arvo, verrokki ja isoimman pelaajan nimi.
		 * Käydään läpi koko pelaajat-taulukko. 
		 * Mikäli kaksi pelaajaa päätyvät samaan käden arvoon, jaetaan voitto.
		 * Paitsi, jos jaettu voitto tulee samalla kädenarvolla kuin jakajalla, jolloin jakaja voittaa.
		 */
		public void voittaja() {
			int isoinArvo = 0;
			int verrokki;
			String isoinPelaaja = null;
			for (int i=0; i<this.pelaajia; i++) {
				verrokki = this.pelaajienKadet.get(this.pelaajat.get(i)).getArvo();
				if (verrokki < 22 && verrokki > isoinArvo) {
					isoinArvo = verrokki;
					isoinPelaaja = this.pelaajat.get(i);
				} else if (verrokki < 22 && verrokki == isoinArvo) {
					if (this.pelaajat.get(i).equals("Jakaja") || isoinPelaaja.equals("Jakaja")) {
						isoinPelaaja = this.pelaajat.get(i);
					}else {
						isoinPelaaja += " ja " + this.pelaajat.get(i);
					}
				}
				
			}
			
			//Asetetaan muuttuja loppu todeksi. Muuttaa nappien toiminnallisuutta poistumiseksi ja uudeksi peliksi
			setLoppu(true);
			
			//Ponnautetaan ikkuna, josta selviää voittaja
			//Ilmoituksen alle napit alkuun paluuta ja uutta peliä samoilla pelaajilla varten
			UIManager.put("OptionPane.noButtonText", "Alkuun");
		    UIManager.put("OptionPane.yesButtonText", "Uusi peli");
			JDialog.setDefaultLookAndFeelDecorated(false);
			
		    int response = JOptionPane.showConfirmDialog(null, isoinPelaaja + " voitti!", "Confirm",
		        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    
		    if (response == JOptionPane.NO_OPTION) {
		    	peliIkkuna.sulje();
		    	response = JOptionPane.CLOSED_OPTION;
				TervetuloIkkuna tervetuloa = new TervetuloIkkuna(600, 400, "Tervetuloa Venttiin");
				tervetuloa.nayta();
		    } else if (response == JOptionPane.YES_OPTION) {
		    	pelaajat.add(pelaajat.get(0));
				pelaajat.remove(0);
				Peli peli = new Peli(pelaajat);
				peliIkkuna.sulje();
				peli.naytaPeli();	
				response = JOptionPane.CLOSED_OPTION;
		    } else if (response == JOptionPane.CLOSED_OPTION) {
		      
		    }
		}
	
	//Kortti olion getteri	
	public Kortti getKortti() {
		return this.kortti;
	}
	
	
	//Vuoron numeron getteri. Ensimmäinen vuoro on 0
	public int getVuoro() {
		return this.vuoro;
	}
	
	
	//Käsi olion getteri
	public Kasi getKasi() {
		return this.kasi;  
	}
	
	
	//Tietyn pelaajan käden hakeminen
	public Kasi getPelaajanKasi(String nimi) {
		return this.pelaajienKadet.get(nimi);
	}
	
	
	//Käden arvon muuttaminen syötteeksi ylimeneviä tuloksia varten
	public String getSyote (int arvo) {
		if (arvo < 22) {
			this.arvo = "" + arvo;
		} else {
			this.arvo = "yli";
		}
		return this.arvo;
	}
	
	
	//Monesko kortti jaossa kysely
	public int moneskoKortti() {
		if (monesko<1) {
			return 1;
		}
		return this.monesko;
	}

	
	//Loppumuuttujan setteri
	public void setLoppu (boolean loppu) {
		this.loppu = loppu;
	}
	
	
	//Loppumuuttujan getteri
	public boolean getLoppu () {
		return this.loppu;
	}

}	
