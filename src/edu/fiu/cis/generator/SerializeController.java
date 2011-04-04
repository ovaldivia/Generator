package edu.fiu.cis.generator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Class that serializes objects
 * @author omvaldiv
 *
 */
public class SerializeController {
	
	
	
	/**
	 * Serialize a object to a file whose name is specified by the parameter id
	 * @param o Object
	 * @param id File id
	 * @return Id of the object just serialized
	 */
	public String serialize(Object o, String id){
		ObjectOutputStream out = null;
		if (id==null)
			Utils.logError("Invalid ID", this.getClass());
		
		try {
			
			out = new ObjectOutputStream (
								new FileOutputStream(id));
			
			out.writeObject (o);
			
		} catch (Exception e) {
			id = null;
			e.printStackTrace();
		}finally{
			try {
				out.close();
				out = null;
			} catch (Exception e) {}
		}
		
		return id;
		
	}
	
	/**
	 * Returns a serialize object given an id. 
	 * Returns null if there is no object serialize with the specified id.
	 * @param id Object id
	 * @return Object
	 */
	public Object getObject(String id){
		Object o = null;
		ObjectInputStream in = null;
		try {
			
			in = new ObjectInputStream (
								new FileInputStream(id));
			o = in.readObject();
			
		} catch (Exception e) {
			//e.printStackTrace();
		}finally{
			try {
				in.close();
				in = null;
			} catch (Exception e) {}
		}
		
		if (o==null)
			System.out.print("No event");
		return o;
		
	}
	
	
	
	
	
}
