package model;

import org.junit.jupiter.api.Test;

public class ProviderCreditCreated {
	private static final long serialVersionUID = 1L;
	private int term;
	private TiendaMonarca td;
	
	
	public void setupScenary1() {
		td = new TiendaMonarca();
		term= 351;
		
		
	}
	@Test
	void test() {
		setupScenary1();
		//td.createDebtors( term);
	}

}
