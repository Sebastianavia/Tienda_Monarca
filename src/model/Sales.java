package model;

import java.util.ArrayList;


public abstract class Sales implements ValueTotal {
	private ArrayList<Product> pr  ;
	private int price;
	private Clients client;
	
	private ArrayList<Integer> num;
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param cl
	 * @param pr
	 * @param price
	 */
	public Sales(Clients cl,ArrayList<Product> pr,ArrayList<Integer>nums ,int price) {
		this.pr = pr;
		this.price = price;
		setNum(nums);
		setClient(cl);
		calculeTotalPrice();
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return pr
	 */
	public ArrayList<Product> getPr() {
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
	public int getPrice() {
		return price;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
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
		int newVal =0;
		for (int i=0;i<pr.size();i++) {
			newVal+= pr.get(i).getsetvaluepay()*num.get(i);
			
		}
		setPrice(newVal);
	}
}
