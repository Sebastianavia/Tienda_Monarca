package model;

public interface ProgressGadget {
	public void advance();
	public String getState();
	public boolean finished();
	public String getPercentage();
}
