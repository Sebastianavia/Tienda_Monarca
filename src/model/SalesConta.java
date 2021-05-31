package model;

import java.util.ArrayList;

public class SalesConta extends Sales {
	private TypePaymen typa;
	public SalesConta(Clients client,ArrayList<Product> pr, int price,String ty) {
		super(client, pr, price);
		setTypa(TypePaymen.valueOf(ty));
	}
	public TypePaymen getTypa() {
		return typa;
	}
	public void setTypa(TypePaymen typa) {
		this.typa = typa;
	}

}
