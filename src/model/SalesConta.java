package model;

import java.util.ArrayList;

public class SalesConta extends Sales implements ValueTotal {
	private TypePaymen typa;
	private SalesConta left;
	private SalesConta right;
	
	
	/**
	 * constructor method <br>
     * <b> pre: we need the atributes </b> 
	 * @param client
	 * @param pr
	 * @param price
	 * @param ty
	 */
	public SalesConta(Clients client,ArrayList<Product> pr, ArrayList<Integer> nums,String ty) {
		super(client, pr, nums,0);
		setTypa(TypePaymen.valueOf(ty));
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return typa
	 */
	public TypePaymen getTypa() {
		return typa;
	}
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param typa
	 */
	public void setTypa(TypePaymen typa) {
		this.typa = typa;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return
	 */
	public SalesConta getLeft() {
		return left;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param left
	 */
	public void setLeft(SalesConta left) {
		this.left = left;
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return
	 */
	public SalesConta getRight() {
		return right;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param right
	 */
	public void setRight(SalesConta right) {
		this.right = right;
	}


	@Override
	public void calculeTotalPrice() {
		
	}

}
