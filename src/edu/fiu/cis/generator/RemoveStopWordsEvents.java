package edu.fiu.cis.generator;

import java.util.Iterator;

import edu.fiu.cis.wordUtils.StopWords;

public class RemoveStopWordsEvents {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generator generator = new GeneratorText();
		
		Iterator<Event> iterator = generator.iterator();
        
        
        while (iterator.hasNext()) {
        	Event event = iterator.next();
        	if (event == null)
        		continue;
        	
        	String id = event.getId() + "";
			
			
            //event.setContent(StopWords.remove(event.getContent()));
            if (event.getContent() == null || "".equals(event.getContent()))
            	System.out.print("");
            	//CommonUtils.saveEvent(event, id);
        }
	}

}
