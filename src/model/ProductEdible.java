package model;

public class ProductEdible extends Product {
	private static final long serialVersionUID = 1L;
	private TypeProduct typr;
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name
	 * @param valuepay
	 * @param valuesale
	 * @param cuantity
	 * @param pr
	 * @param typ
	 */
	public ProductEdible(String name, int valuepay, int valuesale,int cuantity,Provider pr,String typ) {
		super(name, valuepay, valuesale,cuantity,pr);
		typr = TypeProduct.valueOf(typ);
	}

	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return typr
	 */
	public TypeProduct getTypr() {
		return typr;
	}

	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param typr
	 */
	public void setTypr(TypeProduct typr) {
		this.typr = typr;
	}

	

}
