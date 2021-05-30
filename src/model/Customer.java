package model;

public class Customer extends Clients {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypePaymen typ;

	public Customer(String name, String documentType, String id, String phone,String ty) {
		super(name, documentType, id, phone);
		typ = TypePaymen.valueOf(ty);

	}

	public TypePaymen getTyp() {
		return typ;
	}

}
