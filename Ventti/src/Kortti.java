import java.awt.Component;

import javax.swing.ImageIcon;

public class Kortti {

	private int arvo;
	private int maa;
	private ImageIcon kuvaIso;

	private String kuvaLahde;
	
	public Kortti() {
		this.maa = 0;
		this.arvo = 0;
		this.kuvaLahde = "/kuvat" + this.getMaa() + this.arvo;
	}
	
	public Kortti (int maa, int arvo) {
		this.maa = maa;
		this.arvo = arvo;
		this.kuvaLahde = "/kuvat/" + this.getMaa().toLowerCase() + this.arvo + ".png";
		try { //yritet‰‰n ladata kortin kuva
			this.kuvaIso = new ImageIcon(this.getClass().getResource(kuvaLahde));
		}
		catch (Exception e) {
			
		}

	}
	
	public int getArvo() {
		return this.arvo;
	}
	
	//Kortin maan hakeminen
	public String getMaa(){
	    if (this.maa == 0)
	    {
	        return "ruutu";
	    }
	    else if (this.maa == 1)
	    {
	        return "risti";
	    }
	    else if (this.maa == 2)
	    {
	        return "hertta";
	    }
	    else
	    {
	        return "pata";
	    }
	}
	
	public ImageIcon getKuva() {
		return this.kuvaIso;
	}

	public String getKuvaLahde() {
		return this.kuvaLahde;
	}
	

	
	@Override
	public String toString() {
		return this.getMaa() + " " + this.arvo;
	}
}
