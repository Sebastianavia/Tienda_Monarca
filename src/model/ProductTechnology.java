package model;

public class ProductTechnology extends Product {
	private static final long serialVersionUID = 1L;
	private TypeTech typ;
	private String brand;
	private int capacity;
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name
	 * @param valuepay
	 * @param valuesale
	 * @param cuantity
	 * @param pr
	 * @param ty
	 * @param br
	 * @param cap
	 */
	public ProductTechnology(String name, int valuepay, int valuesale,int cuantity,Provider pr,String ty,String br,int cap) {
		super(name, valuepay, valuesale,cuantity, pr);
		typ = TypeTech.valueOf(ty);
		brand = br;
		capacity= cap;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method 
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return typ
	 */
	public TypeTech getTyp() {
		return typ;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param typ
	 */
	public void setTyp(TypeTech typ) {
		this.typ = typ;
	}

}
