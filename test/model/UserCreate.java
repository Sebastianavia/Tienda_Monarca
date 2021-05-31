package model;


import org.junit.jupiter.api.Test;

class UserCreate {
	private TiendaMonarca td;
	private String name;
	private String  lastName;
	private String id;
	private String nameU;
	private String password;
	public void setupScenary1() {
		td = new TiendaMonarca();
		name= "andres";
		lastName ="gutierrez";
		id = "114123112";
		nameU = "andre";
		password = "12345";
	}
	@Test
	void test() {
		setupScenary1();
		td.creatUser(name, lastName, id, nameU, password);
	}

}
