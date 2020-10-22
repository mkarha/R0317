import java.util.ArrayList;

public class Pakka {

	private Kortti kortti;
	private ArrayList<Kortti> kortit;
	private int korttejaPakassa;
	
	public Pakka() {
		//maat
		//this.kortti = new Kortti();
		this.kortit = new ArrayList<>();
	    for(int i=0; i<4; i++)
	    {
	        //arvot
	        for(int j=1; j<14; j++)
	        {
	        	this.kortti = new Kortti(i, j);
	            this.kortit.add(kortti);
	           
	        }
	    }
		
		this.korttejaPakassa = this.kortit.size();
	}

	public int getKorttejaPakassa() {
		return this.korttejaPakassa;
	}
	
	public Kortti jaaKortti(int indeksi) { 
		Kortti jaettava = this.kortit.get(indeksi);
		return jaettava;
	}
	
	
	public void poistaKorttiPakasta(int indeksi) {
		this.kortit.remove(indeksi);
		this.korttejaPakassa = this.kortit.size();
	}
	
}
