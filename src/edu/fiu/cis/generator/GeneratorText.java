package edu.fiu.cis.generator;

public class GeneratorText implements Generator, StreamIterable{
	private StreamIterator records;

	public GeneratorText() {
		records = new ChatSourceTextImpl();
	}
	
	public StreamIterator iterator(){
		return records;
	}
	
	/**
	 * Gets the maximum number of iterations before stopping.
	 */
	public int getMaximumIterations(){
		return records.getMaximumIterations();
	}
	
	/**
	 * Sets the maximum number of iterations before stopping.<br>
	 * If maximum number is zero, then it its defaulted to all the records
	 */
	public void setMaximumIterations(int maximumIterations){
		records.setMaximumIterations(maximumIterations);
	}
}
