package model;

import java.io.Serializable;

public  class Clients implements Serializable{

	
	
	
	private static final long serialVersionUID = 1L;
	private String name; 
    private String documentType;
    private String id;
    private String phone;
    private Clients next;
  
    
    	/**
    	 * constructor method <br>
    	 * <b> pre: we need the atributes </b> 
    	 * @param name
    	 * @param documentType
    	 * @param id
    	 * @param phone
    	 */
		public Clients(String name, String documentType, String id, String phone) {
		
		this.name = name;
		this.documentType = documentType;
		this.id = id;
		this.phone = phone;
	}
		
		
		/**
		 * get method <br>
		 * <b> pre: constructor method </b>  
		 * @return documentType
		 */
		public String getDocumentType() {
			return documentType;
		}
		
		/**
		 * get method <br>
		 * <b> pre: constructor method </b>  
		 * @return name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * get method <br>
		 * <b> pre: constructor method </b>  
		 * @return id
		 */
		public String getId() {
			return id;
		}
		
		/**
		 * get method <br>
		 * <b> pre: constructor method </b>  
		 * @return phone
		 */
		public String getPhone() {
			return phone;
		}
		
		/**
		 * get method <br>
		 * <b> pre: constructor method </b>
		 * @return next 
		 */
		public Clients getNext() {
			return next;
		}
		
		/**
		 * set method <br>
		 * <b> pre: constructor method </b> 
		 * @param next
		 */
		public void setNext(Clients next) {
			this.next = next;
		}
		
}
