
public class Mustekala extends Kala {
	
	private int lonkeroita;

	public Mustekala() {
		super();
		this.lonkeroita = 8;
	}
	
	

	public Mustekala(int lonkeroita) {
		super();
		this.lonkeroita = lonkeroita;
	}



	public Mustekala(String laji, int paino, int lonkeroita) {
		super(laji, paino);
		this.lonkeroita = lonkeroita;
	}

	
	
	/**
	 * @return the lonkeroita
	 */
	public int getLonkeroita() {
		vapautaMustetta();
		return lonkeroita;
	}

	/**
	 * @param lonkeroita the lonkeroita to set
	 */
	public void setLonkeroita(int lonkeroita) {
		this.lonkeroita = lonkeroita;
	}

	private void vapautaMustetta() {
		System.out.println(this.getLaji());
		for(int i=0; i<this.lonkeroita; i++){
			System.out.println("squirt");
		}
	}

}
