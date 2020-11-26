package LevyLista;

public class Teos {
	
	private String tekija;
	private String nimi;
	private int julkaisuvuosi;
	
	public Teos() {
		
	}
	 
	public Teos(String tekija, String nimi, int julkaisuvuosi) {
		setTekija(tekija);
		setNimi(nimi);
		setJulkaisuvuosi(julkaisuvuosi);
	}

	public String getNimi() {
		return this.nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getTekija() {
		return this.tekija;
	}

	public void setTekija(String tekija) {
		this.tekija = tekija;
	}

	public int getJulkaisuvuosi() {
		return this.julkaisuvuosi;
	}

	public void setJulkaisuvuosi(int julkaisuvuosi) {
		this.julkaisuvuosi = julkaisuvuosi;
	}

}
