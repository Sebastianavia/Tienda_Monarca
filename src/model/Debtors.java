package model;

import java.io.Serializable;

public class Debtors implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name; 
    private String documentType;
    private String id;
    private String phone;
    private Clients next;
	private String address;
	private int payment;

	public Debtors(String name, String documentType, String id, String address, String phone, int cuantity,
			int payment) {
		this.name = name;
		this.documentType = documentType;
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.payment = payment;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Clients getNext() {
		return next;
	}

	public void setNext(Clients next) {
		this.next = next;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getAddress() {
		return address;
	}

	public int getPayment() {
		return payment;
	}

}