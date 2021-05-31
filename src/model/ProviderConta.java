package model;

public class ProviderConta extends Provider {
	private static final long serialVersionUID = 1L;
	private String numAcount ;
	public ProviderConta(String name, String phone, String address,String numAcount) {
		super(name, phone, address);
		this.setNumAcount(numAcount);
		
	}
	public String getNumAcount() {
		return numAcount;
	}
	public void setNumAcount(String numAcount) {
		this.numAcount = numAcount;
	}

	
	
}
