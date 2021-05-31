package model;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int cuantity;
    private int valuepay;
    private int valuesale;


    public Product(String name, int valuepay, int valuesale,int cuantity){

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

    
}