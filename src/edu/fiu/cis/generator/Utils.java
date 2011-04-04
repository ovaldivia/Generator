package edu.fiu.cis.generator;

import org.apache.log4j.Logger;


public class Utils {
	
	public static String trim_comma_end(String sourceString) {
		String s = "";

		if (sourceString != null && !sourceString.equals("")) {
			s = sourceString.trim();
			int l = s.length();

			if (l > 1 && s.charAt(l - 1) == ',') {
				s = sourceString.substring(0, sourceString.length() - 1);
			} else
				s = sourceString.trim();
		}
		return s;
	}

	public static String comma_setter(String sourceString) {

		return (sourceString != null && !sourceString.trim().equals("") ? ","
				: "");
	}

	public static void logDebug(String msg, Class cl){
		Logger.getLogger(cl).debug(msg);
	}
	
	public static void logError(String msg, Class cl){
		Logger.getLogger(cl).error(msg);
	}
	
	public static void logInfo(String msg, Class cl){
		Logger.getLogger(cl).info(msg);
	}
	
	
	
}
