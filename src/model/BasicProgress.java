package model;

public abstract class BasicProgress  implements ProgressGadget{
	protected String template = "[                 ]";
	
	protected int current;
	protected int maximum;
	
	public BasicProgress(int max) {
		current = 0;
		maximum = max;
	}

	@Override
	public String getPercentage() {
		return String.format("%3d",(int)(current*100.0/maximum));
	}
	
	@Override
	public boolean finished() {
		return current>=maximum;
	}
	
	protected String getStateWithPercentaje(String state) {
		return state+getPercentage()+"%";
	}	
}