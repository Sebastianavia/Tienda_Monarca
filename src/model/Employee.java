package model;

public abstract class Employee {
	private String name;
	private String lastName;
	private String id;
	public Employee(String n,String l,String i) {
		name = n;
		lastName = l;
		id = i;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public String getId() {
		return id;
	}
}
