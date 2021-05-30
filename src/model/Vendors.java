package model;

public class Vendors extends Employee {
	private String phone;
	private TypeVendors typeV;
	private Vendors next;

	public Vendors(String n, String l, String i, String p, String t) {
		super(n, l, i);
		phone = p;
		typeV = TypeVendors.valueOf(t);
	}

	public TypeVendors getTypeV() {
		return typeV;
	}

	public String getPhone() {
		return phone;
	}

	public Vendors getNext() {
		return next;
	}

	public void setNext(Vendors next) {
		this.next = next;
	}

}
