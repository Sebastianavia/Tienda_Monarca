package model;

import java.io.Serializable;

public abstract class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int cuantity;
    private int valuepay;
    private int valuesale;
	private Product left;
	private Product right;
	private Provider pr;
    public Product(String name, int valuepay, int valuesale,int cuantity,Provider p){
    	pr= p;
        this.name = name;
        this.valuepay = valuepay;
        this.valuesale= valuesale;
        this.setCuantity(cuantity);
    }

    public String getName() {
        return this.name;
        }

    public void setName(String name) {
        this.name = name;
        }


    public void setvaluepay(int valuepay) {
        this.valuepay = valuepay;
        }

    public int getsetvaluepay() {
        return this.valuepay;
        }

    public void setvaluesale (int valuesale){
        this.valuesale = valuesale;
        }

    public int getvaluesale() {
        return this.valuesale;
        }

	public int getCuantity() {
		return cuantity;
	}

	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}

	public Product getLeft() {
		return left;
	}

	public void setLeft(Product left) {
		this.left = left;
	}

	public Product getRight() {
		return right;
	}

	public void setRight(Product right) {
		this.right = right;
	}

	public Provider getPr() {
		return pr;
	}

    
}