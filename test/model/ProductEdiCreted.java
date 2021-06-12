package model;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ProductEdiCreted {

	private static final long serialVersionUID = 1L;
	private TypeProduct typr;
	private TiendaMonarca td;
	
	public void setupScenary1() throws ClassNotFoundException, IOException {
		td = new TiendaMonarca();
		typr = TypeProduct.valueOf("CANDYS");
	}
	@Test
	void test() throws ClassNotFoundException, IOException {
		setupScenary1();
		//td.creatProductComes( td,  typr);
	}
	
}
