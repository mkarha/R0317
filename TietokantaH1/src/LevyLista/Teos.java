package LevyLista;

public class Teos {
	
	private String nimi;
	private String tekija;
	private int julkaisuvuosi;
	
	public Teos() {
		
	}
	 
	public Teos(String nimi, String tekija, int julkaisuvuosi) {
		setNimi(nimi);
		setTekija(tekija);
		setJulkaisuvuosi(julkaisuvuosi);
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getTekija() {
		return tekija;
	}

	public void setTekija(String tekija) {
		this.tekija = tekija;
	}

	public int getJulkaisuvuosi() {
		return julkaisuvuosi;
	}

	public void setJulkaisuvuosi(int julkaisuvuosi) {
		this.julkaisuvuosi = julkaisuvuosi;
	}

}
