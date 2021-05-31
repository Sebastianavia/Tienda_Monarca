package model;

import java.util.ArrayList;

public abstract class Sales {
	private ArrayList<Product> pr  ;
	private int price;
	private Clients client;
	
	public Sales(Clients cl,ArrayList<Product> pr, int price) {
		this.pr = pr;
		this.price = price;
		setClient(cl);
	}
	public ArrayList<Product> getPr() {
		return pr;
	}
	public void setPr(ArrayList<Product> pr) {
		this.pr = pr;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Clients getClient() {
		return client;
	}
	public void setClient(Clients client) {
		this.client = client;
	}
	
}
