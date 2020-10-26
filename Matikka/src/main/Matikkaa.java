package main;

public class Matikkaa {

	public static int summa(int eka, int toka) {
		return eka + toka;
	}
	public static double potenssi(int eka, int toka) {
		return Math.pow(eka, toka);
	}
	
	/*Lis‰‰ luokkaan Matikka metodi ekaSuurempiKuin(int eka, int toka). 
	 * Metodi palauttaa arvon true, jos eka on suurempi kuin toka.
	 */
	
	public static boolean ekaSuurempiKuin(int eka, int toka) {
		if (eka > toka) {
			return true;
		}else {
			return false;
		}
	}
	
	/*Lis‰‰ luokkaan Matikka metodi pintaAla(int pituus, int leveys), 
	 * joka palauttaa suorakulmion pinta-alan. 
	 * Jos pituus tai leveys on negatiivinen, metodi palauttaa nolla. 
	 */
	
	public static double pintaAla(int eka, int toka) {
		if(eka<0 || toka<0) {
			return 0;
		}else {
			return eka*toka*1.0; 
		}
		
	}
	
public static void main(String[] args) {

		System.out.println( Matikkaa.summa(2, 3) );
		System.out.println( Matikkaa.potenssi(4, 2) );

	}
}