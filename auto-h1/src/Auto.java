
public class Auto {
	String valmistaja;
	String rekNro;
	String vari;
	int nopeus;
	int tankki;
	
	public Auto(String valmistaja, String rekNro, String vari, int nopeus, int tankki) {
		this.valmistaja = valmistaja;
		this.rekNro = rekNro;
		this.vari = vari;
		this.nopeus = nopeus;
		this.tankki = tankki;
	}
	
	@Override
	public String toString() {
		return "Auto [valmistaja=" + valmistaja + ", rekNro=" + rekNro + ", vari=" + vari + ", nopeus=" + nopeus
				+ ", tankki=" + tankki + "]";
	}

}
