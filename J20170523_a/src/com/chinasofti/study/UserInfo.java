package com.chinasofti.study;

public class UserInfo {
	private String name;
	private static int id=0;
	private String pwd;
	
	
	
	public UserInfo(){
		
	}
	
	public UserInfo(String name,  String pwd) {
		this.name = name;
		id++;
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", id=" + id + ", pwd=" + pwd + "]";
	}
}
