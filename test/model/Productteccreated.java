package model;


import org.junit.jupiter.api.Test;


public class Productteccreated {

	private static final long serialVersionUID = 1L;
	private TypeTech typ;
	private String brand;
	private int capacity;
	private TiendaMonarca td;
	
	
	public void setupScenary1() {
		td = new TiendaMonarca();
		typ= TypeTech.valueOf("CEL");
		brand = "sansung";
		capacity = 100;
		
	}
	@Test
	void test() {
		setupScenary1();
	//	td.createProvider( typ, brand, capacity);
	}
}
