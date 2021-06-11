package model;

public class ProviderCredit extends Provider {
	private static final long serialVersionUID = 1L;
	private int term;
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name
	 * @param phone
	 * @param address
	 * @param id
	 * @param term
	 */
	public ProviderCredit(String name, String phone, String address,String id,int term) {
		super(name, phone, address,id);
		this.setTerm(term);
	}

	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>
	 * @return term
	 */
	public int getTerm() {
		return term;
	}

	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b>
	 * @param term
	 */
	public void setTerm(int term) {
		this.term = term;
	}
}
