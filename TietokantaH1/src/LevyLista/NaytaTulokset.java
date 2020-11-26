package LevyLista;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LevyLista.SQLLevytManager;
import LevyLista.Levy;

public class NaytaTulokset extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	// Sarakkeiden nimet

	String[] sarakkeet = { "Tekij‰n nimi", "Levyn nimi", "Julkaisuvuosi", "Genre", "Formaatti" };
	Object[][] data = {};

	/**
	 * Create the frame.
	 */

	public NaytaTulokset(ArrayList<Levy> levyhylly) {

		table = new JTable();

		setTitle("LevyLista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(table);

		contentPane.add(scrollPane);

		// Taulukon alustaminen

		table.setModel(new DefaultTableModel(data, sarakkeet));

		if (levyhylly != null)
			tiedotTaulukkoon(levyhylly);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("P‰‰valikkoon");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Lis‰‰ kirjan taulukkoon
				//lisaaLevy();
				ValintaIkkuna valinta;
				try {
					valinta = new ValintaIkkuna();
					valinta.nayta();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
				setVisible(false);

			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Poista valittu rivi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Poistaa kirjan taulukosta
				poistaValitutRivit(table);

			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("P‰ivit‰ taulukko");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_2);

		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);

		JMenu mnNewMenu_1 = new JMenu("Tiedosto");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Avaa");
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenu mnNewMenu = new JMenu("Tallenna");
		mnNewMenu_1.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Poistu");
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("Tietoja ohjelmasta");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Versio");
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("P‰ivitykset");
		mnNewMenu_2.add(mntmNewMenuItem_3);

	}

	protected void tiedotTaulukkoon(ArrayList<Levy>levyhylly) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// K‰yd‰‰n kirjahylly l‰pi 
		for (int row = 0; row < levyhylly.size(); row++) {

			if (levyhylly.get(row) != null) {
				// poimitaan tiedot muuttujiin				
				String tekija = levyhylly.get(row).getTekija();
				String nimi = levyhylly.get(row).getNimi();
				int vuosi = levyhylly.get(row).getJulkaisuvuosi();
				String genre = levyhylly.get(row).getGenre();
				String formaatti = levyhylly.get(row).getFormaatti();
				
				// Lis‰t‰‰n tiedot taulukkoon
				model.addRow(new Object[] { tekija, nimi, "" + vuosi, genre, formaatti});
				
				System.out.println("Lis‰ttiin: "+nimi);
			}

		}

	}



	// Poistaa valitut rivit
	private void poistaValitutRivit(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int[] rows = table.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			String tekija = (String) model.getValueAt(rows[i], 0);
			String levy = (String) model.getValueAt(rows[i], 1);
			String formaatti = (String) model.getValueAt(rows[i], 4);
			System.out.println("Poista " + tekija + " " + levy + " " + formaatti);
			boolean poistetaanko = SQLLevytManager.poistaLevy(tekija, levy, formaatti);
			if(poistetaanko) {
				model.removeRow(rows[i] - i);
			}
		}
	}
	
	//n‰yt‰-metodilla n‰ytet‰‰n ikkuna
			public void nayta() {
				this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
				this.setVisible(true);
			}	
	
		
	
}
