package model;

import java.util.ArrayList;

public class SalesConta extends Sales {
	private TypePaymen typa;
	private SalesConta left;
	private SalesConta right;
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
	public SalesConta getLeft() {
		return left;
	}
	public void setLeft(SalesConta left) {
		this.left = left;
	}
	public SalesConta getRight() {
		return right;
	}
	public void setRight(SalesConta right) {
		this.right = right;
	}

}
