import java.util.ArrayList;

public class Omenapuu {
	
	int istutusVuosi;
	ArrayList<Omena> omenoita;
	ArrayList<Otokka> tuholaiset;
	
	public Omenapuu() {
		this.istutusVuosi = 0;
		this.omenoita = new ArrayList<>();
		this.tuholaiset = new ArrayList<>();
	}
	
	public Omenapuu(int istutusVuosi) {
		this.istutusVuosi = istutusVuosi;
		this.omenoita = new ArrayList<>();
		this.tuholaiset = new ArrayList<>();
	}
	
	public void omenat(Omena omena) {
		this.omenoita.add(omena);
		
	}
	
	

	/**
	 * @return the istutusVuosi
	 */
	public int getIstutusVuosi() {
		return istutusVuosi;
	}



	/**
	 * @param istutusVuosi the istutusVuosi to set
	 */
	public void setIstutusVuosi(int istutusVuosi) {
		this.istutusVuosi = istutusVuosi;
	}



	/**
	 * @return the omenoita
	 */
	public ArrayList<Omena> getOmenoita() {
		return omenoita;
	}



	/**
	 * @param omenoita the omenoita to set
	 */
	public void setOmenoita(ArrayList<Omena> omenoita) {
		this.omenoita = omenoita;
	}



	/**
	 * @return the tuholaiset
	 */
	public ArrayList<Otokka> getTuholaiset() {
		return tuholaiset;
	}



	/**
	 * @param tuholaiset the tuholaiset to set
	 */
	public void setTuholaiset(ArrayList<Otokka> tuholaiset) {
		this.tuholaiset = tuholaiset;
	}

	@Override
	public String toString() {
		return "Omenapuu [istutusVuosi=" + istutusVuosi + ", omenoita=" + omenoita + ", tuholaiset=" + tuholaiset + "]";
	}

	

}
