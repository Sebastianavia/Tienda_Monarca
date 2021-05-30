package model;

public class Debtors extends Clients {
	private static final long serialVersionUID = 1L;
	private String address;
	private int payment;

	public Debtors(String name, String documentType, String id, String address, String phone, int cuantity,
			int payment) {
		super(name, documentType, id, phone);
		this.address = address;
		this.payment = payment;

	}

	public String getAddress() {
		return address;
	}

	public int getPayment() {
		return payment;
	}

}