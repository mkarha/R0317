public class PuunIstuttaja {

	public static void main(String[] args) {

		// Luodaan olio
		Omena ekaOmena = new Omena();
		Omena tokaOmena = new Omena();
		Omena kolmasOmena = new Omena();
		
		Omenapuu omaPuu = new Omenapuu();

		// Asetetaan arvot
		ekaOmena.vari = "vihreä";
		ekaOmena.lajike = "Valkeakuulas";

		tokaOmena.vari = "Punainen";
		tokaOmena.lajike = "Ida Red";

		kolmasOmena.vari = "Keltainen";
		kolmasOmena.lajike = "Tuntematon";
 
	
		omaPuu.omenoita[0] = ekaOmena;
		omaPuu.omenoita[1] = tokaOmena;
		omaPuu.omenoita[2] = kolmasOmena;
		
		System.out.println( omaPuu );
		
		Omenapuu puu2 = new Omenapuu(1975);
		
		puu2.omenat(ekaOmena);
		puu2.omenat(tokaOmena);
		puu2.omenat(kolmasOmena);
		puu2.omenat(kolmasOmena);
		
		System.out.println(puu2);

	}
}
