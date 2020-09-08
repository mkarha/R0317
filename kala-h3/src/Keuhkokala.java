
public class Keuhkokala extends Kala{
	
	private int varsievia;

	public Keuhkokala() {
		super();
		this.varsievia = 2;
	}

	public Keuhkokala(String laji, int varsievia) {
		super(laji, 200);
		this.varsievia = varsievia;
		
	}
	
	private void hengittele() {
		System.out.println(this.getLaji() + ": huoh, huoh, puli, puli");
	}

	/**
	 * @return the varsievia
	 */
	public int getVarsievia() {
		hengittele();
		return varsievia;
	}

	/**
	 * @param varsievia the varsievia to set
	 */
	public void setVarsievia(int varsievia) {
		this.varsievia = varsievia;
	}
	
	
	
	

}
