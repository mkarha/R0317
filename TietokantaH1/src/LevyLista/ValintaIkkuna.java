package LevyLista;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ValintaIkkuna extends Ikkuna{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValintaIkkuna() throws ParseException {
		
		//M‰‰ritell‰‰n ikkunan layoutiksi BorderLayout
		BorderLayout sijoittelija = new BorderLayout();  
		this.setLayout(sijoittelija);
		
		
		LisaysIkkuna lisaa = new LisaysIkkuna();
		ArrayList<Levy> levyt = SQLLevytManager.kaikkiLevyt();
		NaytaTulokset naytaTulos = new NaytaTulokset(levyt);
		
		
		JPanel nappipaneeli = new JPanel();
		GridLayout napit = new GridLayout(1,3);
		nappipaneeli.setLayout(napit);
		
		JPanel ohjepaneeli = new JPanel();
		BoxLayout ohjeet = new BoxLayout(ohjepaneeli, BoxLayout.Y_AXIS);
		ohjepaneeli.setLayout(ohjeet);
		
		
		
		//Esittelyteksti	
		JLabel rivi0 = new JLabel("Tervetuloa Levytietokantaan!");
		JLabel rivi1 = new JLabel("Ohjelman avulla voit selata levytietokantaa");
		JLabel rivi2 = new JLabel("ja tallettaa uusia levyj‰ tietokantaan.");

		rivi0.setFont(rivi0.getFont().deriveFont((float) 20.0));
		rivi1.setFont(rivi1.getFont().deriveFont((float) 20.0));
		rivi2.setFont(rivi2.getFont().deriveFont((float) 20.0));

		
		//Lis‰t‰‰n sis‰ltˆ ohjepaneeliin
		ohjepaneeli.setBorder(new EmptyBorder(new Insets(30, 100, 0, 30)));
		ohjepaneeli.add(rivi0);
		ohjepaneeli.add(rivi1);
		ohjepaneeli.add(rivi2);

		//Luodaan sis‰llˆt
		JLabel otsikko = new JLabel("Levytietokanta");
		otsikko.setFont(otsikko.getFont().deriveFont((float) 30.0));
		otsikko.setBorder(new EmptyBorder(new Insets(30, 100, 0, 30)));
		JButton poistu = new JButton("Poistu");
		JButton haeLevy = new JButton("Hae levy‰");
		JButton lisaaLevy = new JButton("Lis‰‰ levy");
		
		
		//M‰‰ritell‰‰n poistu-napin toiminnallisuus
		poistu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//paaikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				setVisible(true);
				System.exit(0);
			}
			
		});

		//M‰‰ritell‰‰n arvo sana-napin toiminnallisuus
		haeLevy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				naytaTulos.nayta();
				//peli.nayta();
				//paaikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				setVisible(false); //Suljetaan p‰‰ikkuna
				
			}
			
		});
		
		//M‰‰ritell‰‰n uuden sanan luomisen toiminnallisuus
		lisaaLevy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lisaa.nayta();
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
				setVisible(false);
			}
			
		});
		
		//Lis‰t‰‰n napit paneeliin
		nappipaneeli.add(haeLevy);
		nappipaneeli.add(lisaaLevy);
		nappipaneeli.add(poistu);
				
		//Lis‰t‰‰n sis‰ltˆ p‰‰ikkunaan
		this.add(otsikko, BorderLayout.NORTH);
		this.add(ohjepaneeli, BorderLayout.CENTER);
		this.add(nappipaneeli, BorderLayout.SOUTH);

		
	}


	
}
