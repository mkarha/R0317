package LevyLista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import LevyLista.Ikkuna;
import LevyLista.SQLLevytManager;
import LevyLista.ValintaIkkuna;
import LevyLista.NaytaTulokset;

public class LisaysIkkuna extends Ikkuna{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField nimiKentta;
	private JTextField esittajaKentta;
	private JTextField julkaisuKentta;
	private JTextField genreKentta;
	private JTextField formaattiKentta;


	/**
	 * Create the panel.
	 *
	 */


	public LisaysIkkuna(String title) {
		
		this.setSize(800, 600);;
		this.setTitle(title);
		this.setLocationRelativeTo(null);
	}
	
	//n‰yt‰-metodilla n‰ytet‰‰n ikkuna
		public void nayta() {
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
			this.setVisible(true);
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
		
		
		
		public LisaysIkkuna() throws ParseException {

			setTitle("Levytietokanta");
			getContentPane().setLayout(null);
			
			JLabel lblLisaa = new JLabel("Lis‰‰ levy tietokantaan:");
			lblLisaa.setBounds(34, 9, 200, 20);
			getContentPane().add(lblLisaa);

			JLabel lblLevynNimi = new JLabel("Esitt‰j‰:");
			lblLevynNimi.setBounds(34, 54, 111, 20);
			getContentPane().add(lblLevynNimi);

			JLabel lblEsittaja = new JLabel("Nimi:");
			lblEsittaja.setBounds(34, 99, 111, 20);
			getContentPane().add(lblEsittaja);

			JLabel lblJulkaisuvuosi = new JLabel("Julkaisuvuosi:");
			lblJulkaisuvuosi.setBounds(34, 144, 111, 20);
			getContentPane().add(lblJulkaisuvuosi);
			
			JLabel lblGenre = new JLabel("Genre:");
			lblGenre.setBounds(34, 189, 111, 20);
			getContentPane().add(lblGenre);
			
			JLabel lblFormaatti = new JLabel("Formaatti:");
			lblFormaatti.setBounds(34, 234, 111, 20);
			getContentPane().add(lblFormaatti);

			nimiKentta = new JTextField();
			nimiKentta.setBounds(148, 51, 146, 26);
			getContentPane().add(nimiKentta);
			nimiKentta.setColumns(10);

			esittajaKentta = new JTextField();
			esittajaKentta.setColumns(10);
			esittajaKentta.setBounds(148, 96, 146, 26);
			getContentPane().add(esittajaKentta);

			julkaisuKentta = new JTextField();
			julkaisuKentta.setColumns(10);
			julkaisuKentta.setBounds(148, 141, 146, 26);
			getContentPane().add(julkaisuKentta);
			
			genreKentta = new JTextField();
			genreKentta.setColumns(10);
			genreKentta.setBounds(148, 186, 146, 26);
			getContentPane().add(genreKentta);
			
			formaattiKentta = new JTextField();
			formaattiKentta.setColumns(10);
			formaattiKentta.setBounds(148, 231, 146, 26);
			getContentPane().add(formaattiKentta);

			JButton lisaaNappi = new JButton("Tallenna levy");
			lisaaNappi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					tallennaLevy();
				}
			});
			lisaaNappi.setBounds(34, 276, 115, 29);
			getContentPane().add(lisaaNappi);

			JButton poistuNappi = new JButton("Poistu");
			poistuNappi.setBounds(192, 276, 115, 29);
			getContentPane().add(poistuNappi);
			poistuNappi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});

			
			ImageIcon kuva = new ImageIcon("../TietokantaH1/src/LevyLista/kokoelmaPieni.jpg");
			JLabel lblKuva = new JLabel("Levytietokanta");
			lblKuva.setIcon(kuva);
			lblKuva.setBounds(400, 78, 300, 181);
			getContentPane().add(lblKuva);

		}

		protected void tallennaLevy() {

			String nimi = nimiKentta.getText();
			String tekija = esittajaKentta.getText();
			String vuosi = julkaisuKentta.getText();
			String genre = genreKentta.getText();
			String formaatti = formaattiKentta.getText();
			
			Levy uusiLevy = new Levy(tekija, nimi, Integer.parseInt(vuosi), genre, formaatti );

			SQLLevytManager.lisaaLevy(uusiLevy);
			JOptionPane.showMessageDialog(this, "Tallennettu");
			SQLLevytManager.lataaLevyt();
			
			nimiKentta.setText("");
			esittajaKentta.setText("");
			julkaisuKentta.setText("");
			genreKentta.setText("");
			formaattiKentta.setText("");

		}

}
