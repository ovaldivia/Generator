package edu.fiu.cis.generator;

import java.util.ArrayList;



public class SerializeEvents {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GeneratorDB generator = new GeneratorDB();
		generator.setMaximumIterations(Constants.MAXIMUM_ITERATIONS);
		
		ArrayList indexEvents = new ArrayList<String>();
		int k = 0;
		for (Event event : generator) {
			k++;
			//if (k > 10613){
				String id = event.getId() + "";
				
				CommonUtils.saveEvent(event, id);
				indexEvents.add(id);
			//}
		}
		CommonUtils.saveArrayList(indexEvents, "my");
	}

}
