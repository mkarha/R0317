import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class Automaatti extends Ikkuna{
	private ImageIcon kahviKuva;
	private ImageIcon teeKuva;
	private ImageIcon kaakaoKuva;

	public Automaatti(int width, int height, String title) {
		super(width, height, title);
		
		JPanel ylavalikko = new JPanel();
		BoxLayout ylavalikkoBox = new BoxLayout(ylavalikko, BoxLayout.X_AXIS);
		ylavalikko.setLayout(ylavalikkoBox);
		/*
		JComboBox valikko = new JComboBox(); 	
		JLabel lisaa = new JLabel("Lisää");
		valikko.add(lisaa);
		
		ylavalikko.add(valikko);
		*/
		
		JPanel automaattiOsio = new JPanel();
		BoxLayout automaattiEtulevy = new BoxLayout(automaattiOsio, BoxLayout.Y_AXIS);
		automaattiOsio.setLayout(automaattiEtulevy);
			
		JPanel tuoteKahvi = new JPanel();
		BorderLayout kahviAsettelu = new BorderLayout();
		tuoteKahvi.setLayout(kahviAsettelu);
		JPanel tuoteTee = new JPanel();
		BorderLayout teeAsettelu = new BorderLayout();
		tuoteTee.setLayout(teeAsettelu);
		JPanel tuoteKaakao = new JPanel();
		BorderLayout kaakaoAsettelu = new BorderLayout();
		tuoteKaakao.setLayout(kaakaoAsettelu);
		
				
		Kahvi kahvi = new Kahvi("Kahvi", 50);
		Tee tee = new Tee("Tee", 50);
		Kaakao kaakao = new Kaakao("Kaakao", 50);
		
		JButton kahviNappi = new JButton();
		kahviNappi.setSize(280, 190);
		kahviNappi.setIcon(kahvi.getKuva());
		JLabel kahviLabel =new JLabel(kahvi.getNimi());
		kahviLabel.setBorder(new EmptyBorder(new Insets(0, 140, 10, 0)));
		kahviLabel.setFont(kahviLabel.getFont().deriveFont((float) 20.0)); 
		JLabel kahviMaara = new JLabel("" + kahvi.getLkm());
		kahviMaara.setBorder(new EmptyBorder(new Insets(0, 20, 0, 20)));
		kahviMaara.setFont(kahviMaara.getFont().deriveFont((float) 20.0));
		JButton teeNappi = new JButton();
		teeNappi.setSize(280, 190);
		teeNappi.setIcon(tee.getKuva());
		JLabel teeLabel =new JLabel(tee.getNimi());
		teeLabel.setBorder(new EmptyBorder(new Insets(0, 142, 10, 0)));	
		teeLabel.setFont(teeLabel.getFont().deriveFont((float) 20.0));
		JLabel teeMaara = new JLabel("" + tee.getLkm());
		teeMaara.setBorder(new EmptyBorder(new Insets(0, 20, 0, 20)));
		teeMaara.setFont(teeMaara.getFont().deriveFont((float) 20.0));
		JButton kaakaoNappi = new JButton("");
		kaakaoNappi.setSize(280, 190);
		kaakaoNappi.setIcon(kaakao.getKuva());
		JLabel kaakaoLabel =new JLabel(kaakao.getNimi());
		kaakaoLabel.setBorder(new EmptyBorder(new Insets(0, 138, 10, 0)));
		kaakaoLabel.setFont(kaakaoLabel.getFont().deriveFont((float) 20.0));
		JLabel kaakaoMaara = new JLabel("" + kaakao.getLkm());
		kaakaoMaara.setFont(kaakaoMaara.getFont().deriveFont((float) 20.0));
		kaakaoMaara.setBorder(new EmptyBorder(new Insets(0, 20, 0, 20)));
		
		kahviNappi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kahvi.osta();
				if (kahvi.getLkm()>9) {
					kahviMaara.setText("" + kahvi.getLkm());
				}else
					kahviMaara.setText(" " + kahvi.getLkm() + " ");
			}			
		});
		
		teeNappi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tee.osta();
				if (tee.getLkm()>9) {
					teeMaara.setText("" + tee.getLkm());
				}else
					teeMaara.setText(" " + tee.getLkm() +" ");
			}			
		});
		
		kaakaoNappi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kaakao.osta();
				if (kaakao.getLkm()>9) {
					kaakaoMaara.setText("" + kaakao.getLkm());
				}else
					kaakaoMaara.setText(" " + kaakao.getLkm() + " ");
			}			
		});
		
		tuoteKahvi.add(kahviNappi, BorderLayout.CENTER);
		tuoteKahvi.add(kahviLabel, BorderLayout.SOUTH);
		tuoteKahvi.add(kahviMaara, BorderLayout.EAST);
		tuoteTee.add(teeNappi, BorderLayout.CENTER);
		tuoteTee.add(teeLabel, BorderLayout.SOUTH);
		tuoteTee.add(teeMaara, BorderLayout.EAST);
		tuoteKaakao.add(kaakaoNappi, BorderLayout.CENTER);
		tuoteKaakao.add(kaakaoLabel, BorderLayout.SOUTH);
		tuoteKaakao.add(kaakaoMaara, BorderLayout.EAST);
		
		automaattiOsio.add(tuoteKahvi);
		automaattiOsio.add(tuoteTee);
		automaattiOsio.add(tuoteKaakao);
				
		BorderLayout ikkunaAsettelu = new BorderLayout();
		getContentPane().setLayout(ikkunaAsettelu);
		
		getContentPane().add(ylavalikko, BorderLayout.NORTH);
		getContentPane().add(automaattiOsio, BorderLayout.CENTER);
		
	}
	
	
	
}
