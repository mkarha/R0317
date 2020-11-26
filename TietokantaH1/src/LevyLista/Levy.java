package LevyLista;

public class Levy extends Teos {
	
	private String formaatti;
	private String genre;
	
	public Levy() {
		
	}
	
	public Levy(String levynNimi, String esittaja, int julkaisuvuosi, String genre, String formaatti) {
		super(levynNimi, esittaja, julkaisuvuosi);
		setFormaatti(formaatti);
		setGenre(genre);
	}

	public String getFormaatti() {
		return formaatti;
	}

	public void setFormaatti(String formaatti) {
		this.formaatti = formaatti;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
