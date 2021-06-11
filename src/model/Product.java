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
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name
	 * @param valuepay
	 * @param valuesale
	 * @param cuantity
	 * @param p
	 */
    public Product(String name, int valuepay, int valuesale,int cuantity,Provider p){
    	pr= p;
        this.name = name;
        this.valuepay = valuepay;
        this.setValuesale(valuesale);
        this.cuantity=cuantity;
    }

    public String getValuesale() {
		String out = valuesale+"";
		return out ;
	}

	public void setValuesale(int valuesale) {
		this.valuesale = valuesale;
	}
    public String getValuepay() {
    	String out = valuepay+"";
		return out;
	}

	public void setValuepay(int valuepay) {
		this.valuepay = valuepay;
	}
    /**
     * get method <br>
	 * <b> pre: constructor method </b> 
     * @return name
     */
    public String getName() {
        return this.name;
        }

    
    /**
     * set method <br>
	 * <b> pre: constructor method </b>
     * @param name
     */
    public void setName(String name) {
        this.name = name;
        }


    /**
     * set method <br>
	 * <b> pre: constructor method </b>
     * @param valuepay
     */
    public void setvaluepay(int valuepay) {
        this.valuepay = valuepay;
        }

    /**
     * get method <br>
	 * <b> pre: constructor method </b> 
     * @return valuepay
     */
    public int getsetvaluepay() {
        return this.valuepay;
        }

    
    /**
     * set method <br>
	 * <b> pre: constructor method </b>
     * @param valuesale
     */
    public void setvaluesale (int valuesale){
        this.valuesale = valuesale;
        }

    
    /**
     * get method <br>
	 * <b> pre: constructor method </b> 
     * @return valuesale
     */
    public int getvaluesale() {
        return this.valuesale;
        }

    
    /**
     * get method <br>
	 * <b> pre: constructor method </b> 
     * @return cuantity
     */
	public int getCuantity() {
		return cuantity;
	}

	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param cuantity
	 */
	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}

	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return
	 */
	public Product getLeft() {
		return left;
	}

	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param left
	 */
	public void setLeft(Product left) {
		this.left = left;
	}

	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return right
	 */
	public Product getRight() {
		return right;
	}

	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param right
	 */
	public void setRight(Product right) {
		this.right = right;
	}

	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return out
	 */
	public String getPr() {
		String out = pr.getName();
		return out;
	}

    
}