package model;

import org.junit.jupiter.api.Test;

public class ProductEdiCreted {

	private static final long serialVersionUID = 1L;
	private TypeProduct typr;
	private TiendaMonarca td;
	
	public void setupScenary1() {
		td = new TiendaMonarca();
		typr = TypeProduct.valueOf("CANDYS");
	}
	@Test
	void test() {
		setupScenary1();
		//td.creatProductComes( td,  typr);
	}
	
}
