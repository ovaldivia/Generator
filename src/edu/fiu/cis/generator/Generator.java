package edu.fiu.cis.generator;

public interface Generator extends StreamIterable{
	public StreamIterator iterator();
	
	public int getMaximumIterations();
	
	public void setMaximumIterations(int maximumIterations);
}
