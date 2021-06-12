package model;

public class Vendors extends Employee {
	private String phone;
	private TypeVendors typeV;
	private Vendors next;

	
	
	/**
	 * constructor method <br>
     * <b> pre: we need the atributes </b> 
	 * @param n
	 * @param l
	 * @param i
	 * @param p
	 * @param t
	 */
	public Vendors(String n, String l, String i, String p, String t) {
		super(n, l, i);
		phone = p;
		typeV = TypeVendors.valueOf(t);
	}

	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return typeV
	 */
	public TypeVendors getTypeV() {
		return typeV;
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
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return next
	 */
	public Vendors getNext() {
		return next;
	}

	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param next
	 */
	public void setNext(Vendors next) {
		this.next = next;
	}

}
