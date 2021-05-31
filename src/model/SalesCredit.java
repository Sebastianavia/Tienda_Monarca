package model;

import java.util.ArrayList;

public class SalesCredit extends Sales {
	private int payment;
	private int should;
	public SalesCredit(Clients client,ArrayList<Product> pr, int price,int payment,int should) {
		super(client, pr, price);
		this.setPayment(payment);
		this.setShould(should);
		
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getShould() {
		return should;
	}
	public void setShould(int should) {
		this.should = should;
	}

}
