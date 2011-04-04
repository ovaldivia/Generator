package edu.fiu.cis.generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




abstract class ChatSourceImpl implements StreamIterator {
	ResultSet rs;
	Connection conn;
	String[] query;
	int size;
	int counter = 0;
	int maximumIterations;
	
	
	static String JDBC_CONNECTION_STRING;
	
	static String JDBC_CLASS_STRING;
	
	static String SELECT_SIZE_RECORDS;
	
	static String SELECT_RECORDS;
	
	
	public ChatSourceImpl() {
		try {
			Class.forName(JDBC_CLASS_STRING).newInstance();
			conn = DriverManager.getConnection(JDBC_CONNECTION_STRING);
			Statement stmt = null;
			stmt = conn.createStatement();
			
			// Set size of recordset
			if (stmt.execute(SELECT_SIZE_RECORDS)) {
				rs = stmt.getResultSet();
				if (rs.next()) {
					size = rs.getInt(1);
					maximumIterations = size;
				}
			}
			
			
			// Sets recordset
			if (stmt.execute(SELECT_RECORDS)) {
				rs = stmt.getResultSet();
			}
			
			Utils.logInfo("DB records ready", this.getClass());
			
		} catch (Exception ex) {
			Utils.logError(ex.getMessage(), this.getClass());
		}

	}
	
	
	
	public int getMaximumIterations() {
		return maximumIterations;
	}



	public void setMaximumIterations(int maximumIterations) {
		//If maximum = 0, default to all the records
		if (maximumIterations == 0)
			maximumIterations = size;
		
		this.maximumIterations = maximumIterations;
	}



	public void setQuery(String[] query) {
		this.query = query;
	}
	
	public boolean hasNext() {
		return size > 0 && counter <= maximumIterations;
	}
	
	
	abstract public Event next();
	
	/**
	 * Get the query keywords presented in the content parameter
	 * 
	 * @param content
	 *            String
	 * @return String[] query keywords
	 */
	String[] getQueryKeywords(String content) {
		String result[] = null;

		if (content == null || content.length() <= 0)
			return null;

		ArrayList<String> containedKeywords = new ArrayList<String>();
		// Check if content has query keywords
		for (int i = 0; query != null && i < query.length; i++) {
			if (content.indexOf(query[i]) > 0) {
				containedKeywords.add(query[i]); // add to containedKeywords
			}
		}
		if (containedKeywords.size() > 0) {
			result = containedKeywords.toArray(new String[containedKeywords
					.size()]);
		}

		return result;
	}
	
	public void remove() {

	}

	public int getSize() {
		return size;
	}

	public int getCounter() {
		return counter;
	}

}