package model;

public class ProviderCredit extends Provider {
	private static final long serialVersionUID = 1L;
	private int term;
	
	public ProviderCredit(String name, String phone, String address,String id,int term) {
		super(name, phone, address,id);
		this.setTerm(term);
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}
}
