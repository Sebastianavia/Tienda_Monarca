package model;

import java.util.ArrayList;


public abstract class Sales implements ValueTotal {
	private ArrayList<Product> pr  ;
	private double price;
	private Clients client;
	private String products;
	private ArrayList<Integer> num;
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param cl
	 * @param pr
	 * @param price
	 */
	public Sales(Clients cl,ArrayList<Product> pr,ArrayList<Integer>nums ,double price) {
		this.pr = pr;
		this.price = price;
		num =nums;
		setClient(cl);
		products = "1";
		calculeTotalPrice();
		
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return pr
	 */
	public ArrayList<Product> getPr2() {
		return pr;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param pr
	 */
	public void setPr(ArrayList<Product> pr) {
		this.pr = pr;
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return price 
	 */
	public double getPrice() {
		return price;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param out
	 */
	public void setPrice(double out) {
		this.price = out;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return client 
	 */
	public Clients getClient() {
		return client;
	}
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param client
	 */
	public void setClient(Clients client) {
		this.client = client;
	}


	public ArrayList<Integer> getNum() {
		return num;
	}


	public void setNum(ArrayList<Integer> num) {
		this.num = num;
	}
	@Override
	public void calculeTotalPrice() {
		
	}


	public String getPr() {
		String out = "";
		for(int i =0;i<pr.size();i++) {
			out += pr.get(i).getName()+"\n";
		}
		return out;
	}


	public String getProducts() {
		String out = "";
		for(int i =0;i<pr.size();i++) {
			out += pr.get(i).getName()+"\n";
		}
		products=out;
		return products;
	}


	public void setProducts(String products) {
		this.products = products;
	}
	

	
}
