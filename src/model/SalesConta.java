package model;

import java.io.Serializable;
import java.util.ArrayList;

public class SalesConta extends Sales implements ValueTotal,Serializable {
	private static final long serialVersionUID = 1L;
	private TypePaymen typa;
	private SalesConta left;
	private SalesConta right;
	private double ganancy;
	private String pro;
	
	/**
	 * constructor method <br>
     * <b> pre: we need the atributes </b> 
	 * @param client
	 * @param pro 
	 * @param pr
	 * @param price
	 * @param ty
	 */
	public SalesConta(Clients client,String pro, ArrayList<Product> pr, ArrayList<Integer> nums,String ty) {
		super(client, pr, nums,0);
		setTypa(TypePaymen.valueOf(ty));
		ganancy =0;
		this.pro=pro;
		setGanancy();
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
		double out = 0;
		double value =0;
		if(typa== TypePaymen.CARD) {
			ArrayList<Product> n = getPr2();
			ArrayList<Integer> nm = getNum();
			for(int i=0;i<n.size();i++ ) {
				out+= n.get(i).getvaluesale()*nm.get(i);
			}
			value = out* 0.15;
			out = out+value;
			setPrice(out);
		}else {
			ArrayList<Product> n = getPr2();
			ArrayList<Integer> nm = getNum();
			for(int i=0;i<n.size();i++ ) {
				out+= n.get(i).getvaluesale()*nm.get(i);
			}
			setPrice(out);
		}
	}


	public String  getGanancy() {
		String out = ganancy+"";
		return out;
	}


	public void setGanancy() {
		double out =0;
		double out2 = 0;
		ArrayList<Product> n = getPr2();
		ArrayList<Integer> nm = getNum();
		for(int i=0;i<n.size();i++ ) {
			out+= n.get(i).getvaluesale()*nm.get(i);
		}
		for(int i=0;i<n.size();i++ ) {
			out2+= n.get(i).getsetvaluepay()*nm.get(i);
		}
		out = out-out2;
		ganancy += out;
	}


	public String getPro() {
		return pro;
	}


	public void setPro(String pro) {
		this.pro=pro;
		
	}

}
