package lampotilamuunnin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Ikkuna {
 
	private JFrame ikkuna;

	public Ikkuna (int leveys, int korkeus) {
		ikkuna = new JFrame();
		ikkuna.setSize(leveys, korkeus);  
		ikkuna.setTitle("Celsius to Fahrenheit Converter");
		ikkuna.setLocationRelativeTo(null);	
	}
	
	public Ikkuna() {
		
		//Luodaan 400x150 kokoinen ikkuna
		ikkuna = new JFrame();
		ikkuna.setSize(500, 80);  
		ikkuna.setTitle("Celsius to Fahrenheit Converter");
		ikkuna.setLocationRelativeTo(null);	
	
		//m��ritell��n layout 2x2 grid
		GridLayout ruutupohja = new GridLayout(2, 2);
				
		//asetetaan luotu gridi ikkunan layoutiksi
		ikkuna.setLayout(ruutupohja);
		
		BorderLayout reunaLayout = new BorderLayout();
		
		
			
		//Luodaan sis�lt�
		JPanel paneeli = new JPanel();
		paneeli.setLayout(reunaLayout);
		JLabel celsius = new JLabel("Please input the temperature in Celsius:   ");		
		JTextField celsiukset = new JTextField();
		JButton muunna = new JButton("Convert");
		JLabel fahrenheit = new JLabel("  Fahrenheit: ");
		
		paneeli.add(celsius, BorderLayout.EAST);

			
		//Napin toiminnallisuus
		muunna.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(celsiukset.getText());
					double c = Double.parseDouble(celsiukset.getText());
					System.out.println(c);
					double tulos = c*1.8+32;
					System.out.println(tulos);
					fahrenheit.setText("  Fahrenheit: " + tulos);
				}
				catch (Exception x) {
					fahrenheit.setText("Sy�t� vain numeroita desimaalimuodossa!");	
				}
				
			}

		});
		
		
		//Lis�t��n sis�lt� ikkunaan
		ikkuna.add(paneeli);
		ikkuna.add(celsiukset);
		ikkuna.add(muunna);
		ikkuna.add(fahrenheit);
		
		ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		ikkuna.setVisible(true);		
				
	}
	
	public void naytaIkkuna() {
		this.ikkuna.setDefaultCloseOperation(this.ikkuna.EXIT_ON_CLOSE);
		this.ikkuna.setVisible(true);
	}
	
	public void lisaaKomponentti(JComponent component) {
		this.ikkuna.add(component);
	}
	
	public JFrame luoIkkuna() {
		return this.ikkuna;
	}

}
