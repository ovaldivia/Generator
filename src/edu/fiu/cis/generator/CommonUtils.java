package edu.fiu.cis.generator;

import java.io.File;
import java.io.FileInputStream;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Properties;


public class CommonUtils {
	
	public static Properties loadProperties(String path){
		
		Properties properties = new Properties();
		try {
			
			properties.load(new FileInputStream(new File(path)));
		} catch (Exception e) {
			properties = null;
		}
		
		return properties;
		
	}
	
	
	
	//loads arraylist
	public static ArrayList loadArrayList(String id){
		//Utils.logInfo("Load List: " + id + "list",CommonUtils.class);
		return (ArrayList)new SerializeController().getObject(Constants.DEFAULT_FOLDER + "sslist"  +  id + Constants.EXT);
	}
	
	public static void saveArrayList(ArrayList list, String id){
		
		new SerializeController().serialize(list,Constants.DEFAULT_FOLDER + "sslist"  +  id + Constants.EXT);
	}
	
	//loads event
	public static Event loadEvent(String id){
		return (Event)new SerializeController().getObject(id + "event");
	}
	
	
	public static void saveEvent(Event event, String id){
		new SerializeController().serialize(event, id + "event");
	}
	
	/**
	 * Gets UID without characters that are invalid for a system file name
	 * @return UID
	 */
	public static String getUID(){
		String uid = new UID().toString();
		uid = uid.replaceAll(":", "");
		uid = uid.replaceAll("-", "");
		
		return uid;
	}
	
	
	
	
	
}
