package model;

import java.io.Serializable;

public  class Clients implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name; 
    private String documentType;
    private String id;
    private String phone;
    private Clients next;
  
		public Clients(String name, String documentType, String id, String phone) {
		
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
		public Clients getNext() {
			return next;
		}
		public void setNext(Clients next) {
			this.next = next;
		}
		
}
