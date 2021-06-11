package model;

public class EmployeUser extends Employee {
	private String nameUser;
	private String password;
	private EmployeUser next;
	
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param n
	 * @param l
	 * @param i
	 * @param nameU
	 * @param pas
	 */
	public EmployeUser(String n, String l, String i,String nameU,String pas) {
		super(n, l, i);
		nameUser = nameU;
		password = pas;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return password 
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return nameUser 
	 */
	public String getNameUser() {
		return nameUser;
	}
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param nameUser
	 */
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return next 
	 */
	public EmployeUser getNext() {
		return next;
	}
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param next
	 */
	public void setNext(EmployeUser next) {
		this.next = next;
	}
	

}
