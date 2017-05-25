package com.chinasofti.study;

public class Message {

	private String title;
	private UserInfo user;
	private String content;
	private String msgTime;
	public Message(){
		
	}
	
	public Message(String title, UserInfo user, String content, String msgTime) {
		this.title = title;
		this.user = user;
		this.content = content;
		this.msgTime = msgTime;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}
	
	@Override
	public String toString() {
		return "Message [title=" + title + ", user=" + user + ", content="
				+ content + ", msgTime=" + msgTime + "]";
	}
}
