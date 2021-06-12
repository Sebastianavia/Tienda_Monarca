package model;


import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ProviderCreated {

	
	private static final long serialVersionUID = 1L;
	private TiendaMonarca td;
	private String name;
	private String phone;
	private String address;
	private String id;
	
	
	public void setupScenary1() throws ClassNotFoundException, IOException {
		td = new TiendaMonarca();
		name= "andres";
		phone = "3206377493";
		address = "calle 3c";
		id = "114123112";
	}
	@Test
	void test() throws ClassNotFoundException, IOException {
		setupScenary1();
	//	td.createProvider( name, phone, address, id);
	}
}
