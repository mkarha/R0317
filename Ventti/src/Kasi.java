import java.util.ArrayList;

public class Kasi {
	
	private int arvo, monesko;
	private ArrayList<Kortti> kortit;
	private Kortti kortti;
	
	public Kasi() {
		this.arvo = 0;
		this.monesko = 0;
		this.kortit = new ArrayList<>();
	}
	
	public void lisaaKortti(Kortti kortti) {
		
		this.kortit.add(kortti);
	    if(monesko>0)  {//Mik‰li ei ensimm‰inen kortti, j‰rjestet‰‰n pienin kortti k‰dess‰ viimeiseksi.
	        //Tarkoituksena saada ‰ss‰ viimeiseen laskettavaan soluun, jotta voidaan m‰‰ritt‰‰ ‰ss‰lle
	        //vaihtoehtoiset arvot 1 tai 14
	    
	        //tarkistetaan onko jaettu kortti pienempi kuin edellisess‰ solussa oleva kortti
	        if(kortit.get(monesko).getArvo()>kortit.get(monesko-1).getArvo()) {
	            Kortti korttiPieni = kortit.get(monesko-1);
	            kortit.remove(monesko-1);
	            kortit.add(korttiPieni);
	        }
	    }
	    
	    //this.laskeArvo(kortti.getArvo());
	    monesko++;
		
	}
	
	public int getKorttienMaara() {
		monesko = this.kortit.size();
		return monesko;
	}
		
	public Kortti getKortti(int indeksi) {
		this.kortti = this.kortit.get(indeksi);
		return this.kortti;
	}
	
	public void laskeArvo(int arvo) {
		this.arvo += arvo;
		
	}
	
	public void setArvo(int arvo) {
		this.arvo = arvo;
	}

	
	public int getArvo() {
		arvo = 0;
	    for(int i=0; i<this.kortit.size(); i++)
	    {
	        this.kortti = this.kortit.get(i);
	        //Mik‰li kortti on ‰ss‰, tarkistetaan kuinka toimitaan
	        if(this.kortti.getArvo()==1)
	        {
	            //Jos k‰den arvo on 7 tai alle ja kyseess‰ on viimeinen kortti annetaan
	            //‰ss‰lle arvo 14. Muuten 1.
	            if(21-arvo>=14)// && i==kortteja-1)
	            {
	                arvo += 14;
	            }
	            else
	            {
	                arvo += 1;
	            }
	        }
	        //Muiden korttien arvo lis‰t‰‰n k‰ten sellaisenaan
	        else
	        {
	            arvo += kortti.getArvo();
	        }
	    }

	    return arvo;
	}
	
	public ArrayList<Kortti> palautaKasi() {
		return this.kortit;
	}

}
