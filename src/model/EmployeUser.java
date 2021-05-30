package model;

public class EmployeUser extends Employee {
	private String nameUser;
	private String password;
	private EmployeUser next;
	
	public EmployeUser(String n, String l, String i,String nameU,String pas) {
		super(n, l, i);
		nameUser = nameU;
		password = pas;
	}
	public String getPassword() {
		return password;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public EmployeUser getNext() {
		return next;
	}
	public void setNext(EmployeUser next) {
		this.next = next;
	}
	

}
