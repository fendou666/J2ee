package com.study.jspJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Message {
	
	private String title;
	private String name;
	private String content;
	private String date;
	public Message(String title, String name, String content, String date) {
		this.title = title;
		this.name = name;
		this.content = content;
		this.date = date;
	}
	public Message() {
	}
	@Override
	public String toString() {
		return "Message [title=" + title + ", name=" + name + ", content="
				+ content + ", date=" + date + "]";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private void test(){
		List<String> strList = new ArrayList<String>();
		Iterator<String> iterator = strList.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			System.out.println();
		}
	}
}
