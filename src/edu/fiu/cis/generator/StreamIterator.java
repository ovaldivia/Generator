package edu.fiu.cis.generator;

import java.util.Iterator;

public interface StreamIterator extends Iterator<Event>{
	public int getMaximumIterations();

	public void setMaximumIterations(int maximumIterations);
}
