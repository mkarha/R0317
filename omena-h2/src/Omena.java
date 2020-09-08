
public class Omena {
	String lajike;
	String vari;
	int paino;
	
	
	
	public Omena() {
		this.lajike = "Tuntematon";
		this.vari = "Väritön";
		this.paino = -1;
	}



	public Omena(String lajike, String vari, int paino) {
		this.lajike = lajike;
		this.vari = vari;
		this.paino = paino;
	}
	
	
	
	/**
	 * @return the lajike
	 */
	public String getLajike() {
		return lajike;
	}


	
	/**
	 * @param lajike the lajike to set
	 */
	public void setLajike(String lajike) {
		this.lajike = lajike;
	}

	

	/**
	 * @return the vari
	 */
	public String getVari() {
		return vari;
	}



	/**
	 * @param vari the vari to set
	 */
	public void setVari(String vari) {
		this.vari = vari;
	}



	/**
	 * @return the paino
	 */
	public int getPaino() {
		return paino;
	}



	/**
	 * @param paino the paino to set
	 */
	public void setPaino(int paino) {
		this.paino = paino;
	}



	@Override
	public String toString() {
		return "Omena [lajike=" + lajike + ", vari=" + vari + ", paino=" + paino + "]";
	}
	
	

}
