
public class AutoOhjelma {

	public static void main(String[] args) {
		
		Auto auto1 = new Auto("Audi", "ABC-123", "hopea", 249, 80);
		Auto auto2 = new Auto("Kia", "DOM-572", "ruskea", 185, 50);
		Auto auto3 = new Auto("Volvo", "KGB-486", "punainen", 205, 65);
		
		System.out.println("Auto1: ");
		System.out.println(auto1.valmistaja + ", " + auto1.rekNro);
		System.out.println("Väri: " + auto1.vari);
		System.out.println("Huippunopeus: " + auto1.nopeus + " km/h");
		System.out.println("Tankin tilavuus: " + auto1.tankki + " litraa");
		System.out.println();
		
		System.out.println("Auto2: ");
		System.out.println(auto2.valmistaja + ", " + auto2.rekNro);
		System.out.println("Väri: " + auto2.vari);
		System.out.println("Huippunopeus: " + auto2.nopeus + " km/h");
		System.out.println("Tankin tilavuus: " + auto2.tankki + " litraa");
		System.out.println();
		
		System.out.println("Auto3: ");
		System.out.println(auto3.valmistaja + ", " + auto3.rekNro);
		System.out.println("Väri: " + auto3.vari);
		System.out.println("Huippunopeus: " + auto3.nopeus + " km/h");
		System.out.println("Tankin tilavuus: " + auto3.tankki + " litraa");
		System.out.println();
	}

}
