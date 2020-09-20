package myFirstGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Kayttoliittyma {

	public static void main(String[] args) {
		
		//Luodaan 300x200 pikselin kokoinen pääikkuna, jonka title on "Eka ikkuna"
		//Sijoitetaan ikkuna keskelle näyttöä
		JFrame ikkuna = new JFrame();  ikkuna.setSize(300, 200);  
		ikkuna.setTitle("Eka ikkuna");
		ikkuna.setLocationRelativeTo(null);
		
		//Määritellään pääikkunan layoutiksi BorderLayout
		BorderLayout sijoittelija = new BorderLayout();  
		ikkuna.setLayout(sijoittelija);
		
		//Luodaan komponenti otsikko. Sijoitetaan otsikko BorderLayoutin yläosaan
		JComponent otsikko = new JLabel("Welcome!");
		otsikko.setFont(new Font("Trebuchet", 0, 30));
				
		ikkuna.add(otsikko, BorderLayout.NORTH);
		
	
		//Luodaan paneeli muiden komponenttien sijoittelua varten
		//Määritellään paneelin layoutiksi FlowLayout
		JPanel paneeli = new JPanel();
		FlowLayout flow = new FlowLayout();
		paneeli.setLayout(flow);
		
		//Lisätään paneeli pääikkunaan
		ikkuna.add(paneeli);		
		
		//Määritellään syöttökenttiä varten ruudukko, johon kentät sijoitetaan
		//Määritellään layoutiksi GriLayout, jonka koko on 2x2 ruutua
		JComponent syottokentat = new JPanel();
		GridLayout ruudukko = new GridLayout(4, 3);
		syottokentat.setLayout(ruudukko);
		
		//Lisätään GridLayout Flowlayoutin sisälle
		paneeli.add(syottokentat);
		
		//Luodaan syöttökentät sisäänkirjautumista varten
		JComponent tekstiNimi = new JLabel("Name: ");
		JComponent syoteNimi = new JTextField("");
		syoteNimi.setSize(150, 30);
		JComponent tekstiSalasana = new JLabel("Password: ");
		JComponent salaSyote = new JPasswordField("");
		salaSyote.setSize(150, 30);
		JComponent tyhja = new JLabel("");
		JButton kirjaudu = new JButton("Log in");
		kirjaudu.setSize(40, 30);
		JButton unohdus = new JButton("Forgot passwd");
		kirjaudu.setSize(40, 30);
		JButton poistu = new JButton("Quit");
		kirjaudu.setSize(40, 30);
		
		
		//Lisätään syöttökentät GridLayoutiin
		syottokentat.add(tekstiNimi);
		syottokentat.add(syoteNimi);
		syottokentat.add(tekstiSalasana);
		syottokentat.add(salaSyote);
		syottokentat.add(tyhja);
		syottokentat.add(kirjaudu);	
		syottokentat.add(poistu);
		syottokentat.add(unohdus);
				
		
		ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		ikkuna.setVisible(true);


	}

}
