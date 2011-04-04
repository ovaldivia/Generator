package edu.fiu.cis.generator;


/**
 * 
 * Generates chat streams.
 * 
 * @author omvaldiv
 */

public class GeneratorDB implements Generator, StreamIterable{
	private StreamIterator records;
	
	public GeneratorDB(StreamIterator records){
		this.records = records;
	}
	
	public GeneratorDB() {
		records = new ChatSourceImplEnron();
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