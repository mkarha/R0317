import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Pelaaja {
	
	private String tiedosto = "pelaajat.txt";
	private String kayttaja, nimi;
	private int arvo; //pelaajan käden arvo
	private int lkm; //pelaajan kortttien lkm
	private double raha; //pelaajan pinkka
	private String kuvaLahde;
	private ImageIcon kuva;
	
	public Pelaaja() {
		this.lkm = 0;
		this.arvo = 0;
		this.raha = 0;
	}

	public Pelaaja(String nimi) {
		this.nimi = nimi;
		this.lkm = 0;
		this.arvo = 0;
		this.raha = 0;
		try { //yritetään ladata pelaajan kuva
			this.kuva = new ImageIcon(this.getClass().getResource(kuvaLahde));
		}
		catch (Exception e) {
			
		}
	}
	
	public Pelaaja(String nimi, int lkm, int arvo) {
		this.nimi = nimi;
		this.lkm = lkm;
		this.arvo = arvo;
		this.raha = 0;
		try { //yritetään ladata pelaajan kuva
			this.kuva = new ImageIcon(this.getClass().getResource(kuvaLahde));
		}
		catch (Exception e) {
			
		}
	}
	
	public String getKayttaja() {
		return this.kayttaja;
	}
	
	public void setKayttaja(String kayttaja) {
		this.kayttaja = kayttaja;
	}
	
	public String getNimi() {
		return this.nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public ImageIcon getKuva() {
		return this.kuva;
	}
	
	public void setKuva(String kuvaLahde) {
		this.kuvaLahde = kuvaLahde;
	}
	
	public String getKuvaLahde() {
		return this.kuvaLahde;
	}
	
	public void setRaha(double raha) {
		this.raha = raha;
	}
	
	public double getRaha() {
		return this.raha;
	}
	
	public void otaKortti(int arvo) {
		this.lkm += 1;
		this.arvo += arvo;
	}
	
	public int getKorttienMaara() {
		return this.lkm;
	}
	
	public int getArvo() {
		return this.arvo;
	}
	
	public void setArvo(int arvo) {
		this.arvo = arvo;
	}
	
	//Asiemmin talletetun pelaajan lataaminen tiedostosta
	public Pelaaja lataaPelaaja(String pelaajanTunnus) {
		JFrame ponnahdus = new JFrame();
		Pelaaja pelaaja = new Pelaaja();
		try(Scanner tiedostonLukija = new Scanner(Paths.get(tiedosto))){  
			
			while(tiedostonLukija.hasNextLine()){
				String rivi = tiedostonLukija.nextLine(); //luetaan tiedostosta pelaajien tunnukset
				String[] palat = rivi.split("= "); 
				String p = palat[0];
				
				if (p.equals(pelaajanTunnus)) {			//mikäli tiedostosta löytyy käyttäjätunnus, jonka nimi täsmää haettavaan,			      
					pelaaja.setKayttaja(p);
					String tiedot = palat[1];				//ladataan kyseisen pelaajan tiedot
					String[] palaset = tiedot.split(", ");	//erotetaan käyttäjän tiedot toisistaan					
					
					//Asetetaan ladatut tiedot
					pelaaja.setNimi(palaset[0]);			
					pelaaja.setKuva(palaset[1]);
					try {
						Double rahamaara = Double.valueOf(palaset[2]);
						pelaaja.setRaha(rahamaara);
					}
					catch (Exception x) {
						System.out.println(x);
					}
						
					//Palautetaan pelaaja, kun lataus onnistuu
					return pelaaja;
		
				}
			}
			
			
			/*
	        JOptionPane.showMessageDialog(ponnahdus,""+pelaajanTunnus+" nimistä pelaajaa ei ole olemassa.","Alert",JOptionPane.WARNING_MESSAGE);
	        ponnahdus.setVisible(false); 
	        */
			
		} 		
		catch (Exception x){  
			
        	JOptionPane.showMessageDialog(ponnahdus,"Tiedoston lataaminen epäonnistui","Alert",JOptionPane.WARNING_MESSAGE);
        	ponnahdus.setVisible(false);            
        }
		//Mikäli lataus ei onnistu palatetaan null
		return null;	
		
	}
	
	public void tallennaPelaaja(Pelaaja pelaaja) {
		//Tarkistetaan onko jo olemassa kyseisen nimistä automaattia
				JFrame ponnahdus = new JFrame();
				if (onkoPelaajaJoOlemassa(pelaaja.getKayttaja())==true) {
					JOptionPane.showMessageDialog(ponnahdus,"Käyttäjätunnus on jo käytössä. Ole hyväja valitse toinen käyttäjätunnus.","Alert",JOptionPane.WARNING_MESSAGE);
					ponnahdus.setVisible(false);
				        return; 		            	
				}            
				String lisattava = "";
				//yritetään kirjoittaa tiedostoon
				try {
					FileWriter fileWriter = new FileWriter(tiedosto, true);
				    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);     
				    //tallenteen muotoilua
				    lisattava += pelaaja.getKayttaja() +"= ";  //erotetaan pelaajan tunnus kuvasta ja rahamäärästä välilyönnillä ja =-merkillä
				    lisattava += pelaaja.getNimi() + ", " + pelaaja.getKuvaLahde() + ", " + pelaaja.getRaha() +"\n";		//Lisätään kuva ja rahamäärä pilkulla erotettuna
				           
				    bufferedWriter.write(lisattava); 								//kirjoitetaan tiedot tiedostoon
				    bufferedWriter.close();                							//suljetaan kirjoittaja
				    JOptionPane.showMessageDialog(ponnahdus,"Tallennus onnistui","Alert",JOptionPane.WARNING_MESSAGE);
				    return;                                        
				}            		
				catch (Exception x){
				  	JOptionPane.showMessageDialog(ponnahdus,"Tallennus epäonnistui","Alert",JOptionPane.WARNING_MESSAGE);   
				  	x.printStackTrace();
				}
	}
	
	public boolean onkoPelaajaJoOlemassa(String nimi){
    	try(Scanner tiedostonLukija = new Scanner(Paths.get(tiedosto))){
            while(tiedostonLukija.hasNextLine()){
                String rivi = tiedostonLukija.nextLine();
                String[] palat = rivi.split("= ");                               
                String p = palat[0];						
                	if (p.equals(nimi)) {		//verrataan automaatin nimeä käyttäjän syöttämään nimeen
                		return true;
                	}
            }
        } catch (Exception e){  
        	
        	return false; 	
        }    	
        return false;    		
	}
}
