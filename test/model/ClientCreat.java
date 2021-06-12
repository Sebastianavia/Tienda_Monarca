package model;

import org.junit.jupiter.api.Test;

class ClientCreat {
	private TiendaMonarca td;
	private String name;
	private String  lastName;
	private String id;
	private String phone;
	public void setupScenary1() {
		td = new TiendaMonarca();
		name= "andres";
		lastName ="gutierrez";
		id = "114123112";
		phone = "3323223";
	}
	@Test
	void test() {
		setupScenary1();
		td.creatClient(name,lastName,"ti", id, phone);
	}

}
