package model;

import org.junit.jupiter.api.Test;

public class providerContaCreated {
	
	private static final long serialVersionUID = 1L;
	private String numAcount ;
	private TiendaMonarca td;
	
	public void setupScenary1() {
		td = new TiendaMonarca();
		numAcount= "35351351";
		
		
	}
	@Test
	void test() {
		setupScenary1();
		//td.createDebtors( numAcount);
	}

}
