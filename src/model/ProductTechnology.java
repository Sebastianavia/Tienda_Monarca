package model;

public class ProductTechnology extends Product {
	private static final long serialVersionUID = 1L;
	private TypeTech typ;
	private String brand;
	private int capacity;
	public ProductTechnology(String name, int valuepay, int valuesale,int cuantity,String ty,String br,int cap) {
		super(name, valuepay, valuesale,cuantity);
		typ = TypeTech.valueOf(ty);
		brand = br;
		capacity= cap;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public TypeTech getTyp() {
		return typ;
	}
	public void setTyp(TypeTech typ) {
		this.typ = typ;
	}

}
