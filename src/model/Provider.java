package model;

import java.io.Serializable;

public abstract class Provider implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String phone;
	private String address;
	private String id;
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name
	 * @param phone
	 * @param address
	 * @param i
	 */
	public Provider(String name,String phone,String address,String i) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		setId(i);
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
	 * @return address
	 */
	public String getAddress() {
		return address;
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
}
