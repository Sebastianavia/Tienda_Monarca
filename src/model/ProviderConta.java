package model;

public class ProviderConta extends Provider {
	private static final long serialVersionUID = 1L;
	private String numAcount ;
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name
	 * @param phone
	 * @param address
	 * @param id
	 * @param numAcount
	 */
	public ProviderConta(String name, String phone, String address,String id,String numAcount) {
		super(name, phone, address,id);
		this.setNumAcount(numAcount);
		
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return numAcount
	 */
	public String getNumAcount() {
		return numAcount;
	}
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param numAcount
	 */
	public void setNumAcount(String numAcount) {
		this.numAcount = numAcount;
	}

	
	
}
