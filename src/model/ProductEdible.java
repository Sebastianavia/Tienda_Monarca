package model;

public class ProductEdible extends Product {
	private static final long serialVersionUID = 1L;
	private TypeProduct typr;
	
	public ProductEdible(String name, int valuepay, int valuesale,int cuantity,Provider pr,String typ) {
		super(name, valuepay, valuesale,cuantity,pr);
		typr = TypeProduct.valueOf(typ);
	}

	public TypeProduct getTypr() {
		return typr;
	}

	public void setTypr(TypeProduct typr) {
		this.typr = typr;
	}

	

}
