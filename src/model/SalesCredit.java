package model;

import java.util.ArrayList;

public class SalesCredit extends Sales {
	private int payment;
	private int should;
	private Status stat;

	
	public SalesCredit(Clients client,ArrayList<Product> pr, int price,int payment,int should) {
		super(client, pr, price);
		this.setPayment(payment);
		this.setShould(should);
		stat = Status.valueOf("SHOULD");
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

	public Status getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = Status.valueOf(stat);
	}

}
