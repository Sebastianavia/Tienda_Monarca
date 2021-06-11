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
	
	
	
	 /**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name
	 * @param documentType
	 * @param id
	 * @param address
	 * @param phone
	 * @param cuantity
	 * @param payment
	 */
	public Debtors(String name, String documentType, String id, String address, String phone, int cuantity,
			int payment) {
		this.name = name;
		this.documentType = documentType;
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.payment = payment;

	}

	
	
	 /**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return documentType
	 */
	public String getDocumentType() {
		return documentType;
	}

	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param documentType
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return next
	 */
	public Clients getNext() {
		return next;
	}

	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param next
	 */
	public void setNext(Clients next) {
		this.next = next;
	}

	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param payment
	 */
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	

	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return payment 
	 */
	public int getPayment() {
		return payment;
	}

}