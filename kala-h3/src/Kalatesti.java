
public class Kalatesti {

	public static void main(String[] args) {

		Kala kala1 = new Kala();
		Kala kala2 = new Kala("Sardiini", 150);
		
		Mustekala mustekala1 = new Mustekala();
		Mustekala mustekala2 = new Mustekala("Sekstopussi", 350, 6);
		Mustekala mustekala3 = new Mustekala(9);
		
		Keuhkokala keuhkokala1 = new Keuhkokala();
		Keuhkokala keuhkokala2 = new Keuhkokala("Keuhkis", 5);
		
		keuhkokala2.getVarsievia();
		mustekala2.getLonkeroita();
		
		System.out.println(kala2);
		System.out.println(mustekala1);
		System.out.println(keuhkokala2);

		
	}

}
