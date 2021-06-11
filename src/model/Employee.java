package model;

public abstract class Employee {
	private String name;
	private String lastName;
	private String id;
	
	/**
	 * constructor method <br>
     * <b> pre: we need the atributes </b> 
	 * @param n
	 * @param l
	 * @param i
	 */
	public Employee(String n,String l,String i) {
		name = n;
		lastName = l;
		id = i;
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
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return id 
	 */
	public String getId() {
		return id;
	}
}
