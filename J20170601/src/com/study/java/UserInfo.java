package com.study.java;

public class UserInfo {
	
	
	//	如果是其他类型值，前端如何提交过来
	private String id;
	private String Name;
	public UserInfo() {
	}
	
	public UserInfo(String id, String name) {
		this.id = id;
		Name = name;
	}

	public String getId() {
		System.out.println("调用了getId方法");
		return id;
	}
	public void setId(String id) {
		System.out.println("调用了setId方法");
		this.id = id;
	}
	public String getName() {
		System.out.println("调用了getName方法");
		return Name;
	}
	public void setName(String name) {
		System.out.println("调用了setName方法");
		Name = name;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", Name=" + Name;
	}
	
}
