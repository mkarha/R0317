package LevyLista;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToimintoIkkuna extends JFrame{
	
	private String function;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToimintoIkkuna(String title, String function) {
		super(title);
		this.function = function;
		
		
		

		JPanel paneeli = new JPanel();
		GridLayout paneeliLayout = new GridLayout(5, 1);
		paneeli.setLayout(paneeliLayout);
		
		JPanel nimiPaneeli = new JPanel();
		GridLayout nimiLayout = new GridLayout(1, 2);
		nimiPaneeli.setLayout(nimiLayout); 
		JLabel nimiLabel = new JLabel("Nimi");
		JTextField nimiField = new JTextField();
		nimiPaneeli.add(nimiLabel);
		nimiPaneeli.add(nimiField);
		
		JPanel ISBNPaneeli = new JPanel();
		GridLayout ISBNLayout = new GridLayout(1, 2);
		ISBNPaneeli.setLayout(ISBNLayout);
		JLabel ISBNLabel = new JLabel("ISBN");
		JTextField ISBNField = new JTextField();
		ISBNPaneeli.add(ISBNLabel);
		ISBNPaneeli.add(ISBNField);
		
		JPanel tekijaPaneeli = new JPanel();
		GridLayout tekijaLayout = new GridLayout(1, 2);
		tekijaPaneeli.setLayout(tekijaLayout);
		JLabel tekijaLabel = new JLabel("Tekija");
		JTextField tekijaField = new JTextField();
		tekijaPaneeli.add(tekijaLabel);
		tekijaPaneeli.add(tekijaField);
		
		JPanel julkaisuPaneeli = new JPanel();
		GridLayout julkaisuLayout = new GridLayout(1, 2); 
		julkaisuPaneeli.setLayout(julkaisuLayout);
		JLabel julkaisuLabel = new JLabel("Julkaisuvuosi");
		JTextField julkaisuField = new JTextField();
		julkaisuPaneeli.add(julkaisuLabel);
		julkaisuPaneeli.add(julkaisuField);

		JButton nappi = new JButton(this.function);
		
		if (function.equals("Hae")) {
			nappi.addActionListener(new ActionListener () {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			
			});
		}else {
			nappi.addActionListener(new ActionListener () {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
				
			});
		}
		
		
		paneeli.add(nimiPaneeli);
		paneeli.add(ISBNPaneeli);
		paneeli.add(tekijaPaneeli);
		paneeli.add(julkaisuPaneeli);
		paneeli.add(nappi);
	
		this.add(paneeli);
	}
}
