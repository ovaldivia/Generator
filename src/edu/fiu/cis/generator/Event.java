package edu.fiu.cis.generator;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Basic unit of information it does belong to a session
 * @author omvaldiv
 * 
 */
public class Event implements Serializable{
	
	private String[] participants;
	private String content;
	private int id;
	private int sessionId;
	private String subject;
	private Timestamp timestamp;
	private String[] queriedKeywordsInEvent;
	
	public Event(){}
	public Event(String[] participants, String content, Timestamp timestamp, int id, int sessionId, String subject) {
		
		this.participants = participants;
		this.content = content;
		this.id = id;
		this.sessionId = sessionId;
		this.subject = subject;
		this.timestamp = timestamp;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String[] getParticipants() {
		return participants;
	}
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String[] getQueriedKeywordsInEvent() {
		return queriedKeywordsInEvent;
	}
	public void setQueriedKeywordsInEvent(String[] queriedKeywordsInEvent) {
		this.queriedKeywordsInEvent = queriedKeywordsInEvent;
	}
	
	public String[] getKeywords(){
		String[] r = null;
		
		if (content!=null && content.length()>0){
			r = content.split(" ");
		}
		
		return r;
	}
	
}
