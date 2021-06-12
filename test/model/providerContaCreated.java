package model;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class providerContaCreated {
	
	private static final long serialVersionUID = 1L;
	private String numAcount ;
	private TiendaMonarca td;
	
	public void setupScenary1() throws ClassNotFoundException, IOException {
		td = new TiendaMonarca();
		numAcount= "35351351";
		
		
	}
	@Test
	void test() throws ClassNotFoundException, IOException {
		setupScenary1();
		//td.createDebtors( numAcount);
	}

}
