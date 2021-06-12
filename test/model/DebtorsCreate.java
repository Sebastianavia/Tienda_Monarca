package model;

import org.junit.jupiter.api.Test;

public class DebtorsCreate {
	
	private static final long serialVersionUID = 1L;
	private TiendaMonarca td;
	private String name; 
    private String documentType;
    private String id;
    private String phone;
	private String address;
	private int payment;
	
	public void setupScenary1() {
		td = new TiendaMonarca();
		name= "andres";
		documentType ="TI";
		id = "114123112";
		phone = "3206377493";
		address = "calle 3c";
		payment = 12200;
	}
	@Test
	void test() {
		setupScenary1();
		//td.createDebtors( name,  documentType,  id,  phone, address,    payment);
	}


}
