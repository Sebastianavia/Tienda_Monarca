package model;

import java.io.Serializable;

public abstract class Clients implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name; 
    private String documentType;
    private String id;
    private String phone;
  
		public Clients(String name, String documentType, String id, String phone) {
		super();
		this.name = name;
		this.documentType = documentType;
		this.id = id;
		this.phone = phone;
	}
		public String getDocumentType() {
			return documentType;
		}
		public String getName() {
			return name;
		}
		public String getId() {
			return id;
		}
		public String getPhone() {
			return phone;
		}
		
}
