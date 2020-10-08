import javax.swing.ImageIcon;

public class Juoma {
	
	private String nimi;
	private int lkm;
	private ImageIcon kuva;

	
	public Juoma (String nimi, int lkm) {
		this.nimi = nimi;
		this.lkm = lkm;
		try {
			kuva = new ImageIcon(this.getClass().getResource("/" + this.nimi.toLowerCase() + ".jpg"));
		}
		catch (Exception e) {
			
		}
	}
	
	public void osta() {
		if(this.lkm>0) {
			this.lkm -= 1;
		}
	}

	public void lataa (int lkm) {
		this.lkm += lkm;
	}
	
	public void setLkm(int lkm) {
		if(lkm>0 ) {
			this.lkm = lkm;
		}
	}
	
	public int getLkm() {
		return this.lkm;
	}
	
	public String getNimi() {
		return this.nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public ImageIcon getKuva() {
		return this.kuva;
	}
	
}
