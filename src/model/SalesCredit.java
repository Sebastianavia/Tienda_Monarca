package model;

import java.util.ArrayList;

public class SalesCredit extends Sales {
	private int payment;
	private int should;
	private Status stat;

	
	/**
	 * constructor method <br>
     * <b> pre: we need the atributes </b> 
	 * @param client
	 * @param pr
	 * @param price
	 * @param payment
	 * @param should
	 */
	public SalesCredit(Clients client,ArrayList<Product> pr, int price,int payment,int should) {
		super(client, pr, price);
		this.setPayment(payment);
		this.setShould(should);
		stat = Status.valueOf("SHOULD");
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return payment
	 */
	public int getPayment() {
		return payment;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>  
	 * @param payment
	 */
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return should
	 */
	public int getShould() {
		return should;
	}
	
	/**
	 * set method <br>
     * <b> pre: constructor method </b> 
	 * @param should
	 */
	public void setShould(int should) {
		this.should = should;
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return stat
	 */
	public Status getStat() {
		return stat;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param stat
	 */
	public void setStat(String stat) {
		this.stat = Status.valueOf(stat);
	}

}
