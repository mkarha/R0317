
public class Kala {
	static int parvenKoko = 0;
	private String laji;
	private double paino;
	

	public Kala() {
		this.laji = "Tuntematon";
		this.paino = -1;
		this.parvenKoko++;
	}


	public Kala(String laji, double paino) {
		this.laji = laji;
		this.paino = paino;
		this.parvenKoko++;
	}

	
	

	/**
	 * @return the parvenKoko
	 */
	public static int getParvenKoko() {
		return parvenKoko;
	}


	/**
	 * @param parvenKoko the parvenKoko to set
	 */
	public static void setParvenKoko(int parvenKoko) {
		Kala.parvenKoko = parvenKoko;
	}


	/**
	 * @return the laji
	 */
	public String getLaji() {
		return laji;
	}


	/**
	 * @param laji the laji to set
	 */
	public void setLaji(String laji) {
		this.laji = laji;
	}


	/**
	 * @return the paino
	 */
	public double getPaino() {
		return paino;
	}


	/**
	 * @param paino the paino to set
	 */
	public void setPaino(double paino) {
		this.paino = paino;
	}


	@Override
	public String toString() {
		return "Kala [laji=" + laji + ", paino=" + paino + ", parven koko:" + this.parvenKoko +"]";
	}
	
	
	
	
}
