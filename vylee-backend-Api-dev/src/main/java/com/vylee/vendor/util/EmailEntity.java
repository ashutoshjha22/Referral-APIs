package com.vylee.vendor.util;


public class EmailEntity {
	private String toMail;
	private String fromMail;
	private String subjectMail;
	private String messageBody;
	public String getToMail() {
		return toMail;
	}
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}
	public String getFromMail() {
		return fromMail;
	}
	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}
	public String getSubjectMail() {
		return subjectMail;
	}
	public void setSubjectMail(String subjectMail) {
		this.subjectMail = subjectMail;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public EmailEntity(String toMail, String fromMail, String subjectMail, String messageBody) {
		super();
		this.toMail = toMail;
		this.fromMail = fromMail;
		this.subjectMail = subjectMail;
		this.messageBody = messageBody;
	}
	
	

}
