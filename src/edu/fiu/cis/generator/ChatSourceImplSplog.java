package edu.fiu.cis.generator;





class ChatSourceImplSplog extends ChatSourceImpl {
	
	
	static String JDBC_CONNECTION_STRING= "jdbc:oracle:thin:chatresearch/project@dbir.cis.fiu.edu:1521:orcl";
	
	static String JDBC_CLASS_STRING = "oracle.jdbc.driver.OracleDriver";
	
	static String SELECT_SIZE_RECORDS = "select count(*)  from mails inner "
		+ "join email_keywords on email_keywords.id=mails.message_id "
		+ "where  message_id not in "
		+ "(417349,231735,47795,417336,59260,486183,59289,59326,410271,34592,59343,225671,233938,48271,69560,214918,66593,417641,69518,37470,69458,66535,487635,224458,69396,34637,34638,421488,34639,413028,226846,224422,417338,34650,49845,421427,60155,66358,378567,233257,232382,417651)  "
		+ "order by \"date\"";
	
	static String SELECT_RECORDS = "select MESSAGE_ID,SESSION_ID,\"date\",\"from\",\"to\",SUBJECT,CC ,BCC,keywords content  from  mails "
			+ "inner join email_keywords on email_keywords.id=mails.message_id "
			+ "where  message_id not in (417349,231735,47795,417336,59260,486183,59289,59326,410271,34592,59343,225671,233938,48271,69560,214918,66593,417641,69518,37470,69458,66535,487635,224458,69396,34637,34638,421488,34639,413028,226846,224422,417338,34650,49845,421427,60155,66358,378567,233257,232382,417651)  "
			+ "order by \"date\"";
	
	
	
	public Event next() {
		Event e = new Event();
		try {
			if (rs.next()) {
				counter++;
				e = new Event();
				String participants = Utils.trim_comma_end(rs.getString("to"))
						+ Utils.comma_setter(rs.getString("cc"))
						+ Utils.trim_comma_end(rs.getString("cc"))
						+ Utils.comma_setter(rs.getString("bcc"))
						+ Utils.trim_comma_end(rs.getString("bcc")) + ","
						+ Utils.trim_comma_end(rs.getString("from"));

				e.setParticipants(participants != null ? participants
						.split(",") : null);
				e.setContent(rs.getString("content"));
				e.setSubject(rs.getString("subject"));
				e.setTimestamp(rs.getTimestamp("date"));
				e.setId(rs.getInt("message_id"));
				e.setSessionId(rs.getInt("session_id"));
				e.setQueriedKeywordsInEvent(getQueryKeywords(rs
						.getString("content")));
			}
		} catch (Exception ex) {
			Utils.logError(ex.getMessage(), this.getClass());
		}
		
		
		return e;
	}
	
	

}