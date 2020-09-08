import java.util.Arrays;

public class Omenapuu {
	
	int istutusVuosi;
	Omena[] omenoita;
	Otokka[] tuholaiset;
	
	public Omenapuu() {
		this.istutusVuosi = 0;
		this.omenoita = new Omena[10];
		this.tuholaiset = new Otokka[10];
	}
	
	public Omenapuu(int istutusVuosi) {
		this.istutusVuosi = istutusVuosi;
		this.omenoita = new Omena[1];
		this.tuholaiset = new Otokka[1];
	}
	
	public void omenat(Omena omena) {
		int i = 0;
		int koko = this.omenoita.length+1;
		Omena[] lisays = new Omena[koko];
		
		for(i=0; i<this.omenoita.length; i++) {
			lisays[i] = this.omenoita[i];
		}
		lisays[this.omenoita.length] = omena;
		
		this.omenoita = new Omena[i+1];
		koko = i+ 1;
		
		for(i=0; i<koko; i++) {
			this.omenoita[i] = lisays[i];
		}
		
		setOmenoita(this.omenoita);
		
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
	public Omena[] getOmenoita() {
		return omenoita;
	}



	/**
	 * @param omenoita the omenoita to set
	 */
	public void setOmenoita(Omena[] omenoita) {
		this.omenoita = omenoita;
	}



	/**
	 * @return the tuholaiset
	 */
	public Otokka[] getTuholaiset() {
		return tuholaiset;
	}



	/**
	 * @param tuholaiset the tuholaiset to set
	 */
	public void setTuholaiset(Otokka[] tuholaiset) {
		this.tuholaiset = tuholaiset;
	}



	@Override
	public String toString() {
		return "Omenapuu [istutusVuosi=" + istutusVuosi + ", omenoita=" + Arrays.toString(omenoita) + ", tuholaiset="
				+ Arrays.toString(tuholaiset) + "]";
	}
	
	

}
