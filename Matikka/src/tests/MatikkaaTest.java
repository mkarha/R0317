package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Matikkaa;

class MatikkaaTest {

	//Kirjoita luokkaan MatikkaTest potenssi()-metodille testi ja suorita se.

	@Test
	void testPotenssi() {
		assertEquals(25, Matikkaa.potenssi(5, 2));
		assertEquals(1, Matikkaa.potenssi(4, 0));
		assertEquals(0.25, Matikkaa.potenssi(2, -2));
		//fail("Not yet implemented"); // TODO
	}

	
	//Kutsu metodia ekaSuurempiKuin erilaisilla syötteillä: kun arvot ovat erisuuret ja yhtäsuuret. 
	@Test
	void testiEkaSuurempiKuin() {
		assertTrue(Matikkaa.ekaSuurempiKuin(2, 1));
		assertFalse(Matikkaa.ekaSuurempiKuin(2, 2));
		assertFalse(Matikkaa.ekaSuurempiKuin(1, 2));
		assertTrue(Matikkaa.ekaSuurempiKuin(-1, -3));
	}

	//pinta-ala luokan testi
	
	@Test
	void testiPintaAla() {
		assertEquals(0, Matikkaa.pintaAla(-1, 3));
		assertEquals(0, Matikkaa.pintaAla(2, -2));
		assertEquals(0, Matikkaa.pintaAla(0, 2));
		assertEquals(0, Matikkaa.pintaAla(1, 0));
		assertEquals(6, Matikkaa.pintaAla(2, 3));
		assertEquals(0, Matikkaa.pintaAla(-2, -2));
	}
}
