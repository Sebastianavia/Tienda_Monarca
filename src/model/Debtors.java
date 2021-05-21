package model;

import java.io.Serializable;
//import java.util.Objects;


public class Debtors implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name; 
    private String documentType;
    private String id;
    private String address;
    private String phone;

    
   


    public Debtors(String name, String documentType, String id, String address, String phone) {
        this.name = name;
        this.documentType = documentType;
        this.id = id;
        this.address = address;
        this.phone = phone;
        
    }




    public String getFirstName() {
        return this.name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

  

    public String getDocumentType() {
		return documentType;
	}



	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}



	public String getId() {
        return this.id;
    }
	

    public void setId(String id) {
        this.id = id;
    }
    

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    

    public String toString() {
        return getFirstName();
    }


   

  



    //@Override
    /*public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Debtors)) {
            return false;
        }
        Debtors debtors = (Debtors) o;
        return Objects.equals(name, debtors.name)  && Objects.equals(documentType, debtors.documentType) && Objects.equals(id, debtors.id) && Objects.equals(address, debtors.address) && Objects.equals(phone, debtors.phone);
    }*/



}