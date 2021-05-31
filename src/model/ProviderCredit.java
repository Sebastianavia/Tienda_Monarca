package model;

public class ProviderCredit extends Provider {
	private static final long serialVersionUID = 1L;
	private int term;
	
	public ProviderCredit(String name, String phone, String address,int term) {
		super(name, phone, address);
		this.setTerm(term);
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}
}
