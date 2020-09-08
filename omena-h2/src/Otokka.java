
public class Otokka {

	String nimi;

	public Otokka(String nimi) {
		this.nimi = nimi;
	}
	
	

	/**
	 * @return the nimi
	 */
	public String getNimi() {
		return nimi;
	}



	/**
	 * @param nimi the nimi to set
	 */
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}



	@Override
	public String toString() {
		return "Ötökka [nimi=" + nimi + "]";
	}
	
	
	
}
