package edu.fiu.cis.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;



public class ChatSourceTextImpl implements StreamIterator{
	private List list;
	private int counter=0;
	private int maximumIterations;
	private int size;
	private static String EVENT_PATH = "event_path";
	private static String PROPERTIES = "generator.properties";
	private Properties properties;
	private String path;
	private String separator="\\";
	public ChatSourceTextImpl(){
		
		properties = CommonUtils.loadProperties(PROPERTIES);
		path = properties.getProperty(EVENT_PATH);
		
		if (path.contains("/"))
			separator = "/";
		
		File folder = new File(path);
		int eventId;
		list = new ArrayList<String>();
		for(String name:folder.list()){
			
			if (name.contains("event")){
				eventId = Integer.parseInt(name.replace("event", ""));
				list.add(eventId);
			}
		}
		
		Collections.sort(list);
		
		size = list.size() - 1;
		maximumIterations = size;
	}
	
	public boolean hasNext() {
		return size > 0 && counter <= maximumIterations;
	}
	
	public Event next() {
		return CommonUtils.loadEvent(path+ separator + list.get(counter++));
	}
	
	public void remove(){
		
	}
	
	public int getMaximumIterations() {
		return maximumIterations;
	}



	public void setMaximumIterations(int maximumIterations) {
		//If maximum = 0, default to all the records
		if (maximumIterations == 0)
			maximumIterations = size-1;
		
		this.maximumIterations = maximumIterations;
	}

}
