package edu.fiu.cis.generator;

public interface StreamIterable extends Iterable<Event>{
	public int getMaximumIterations();

	public void setMaximumIterations(int maximumIterations);
}
