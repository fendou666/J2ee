package com.study.java;

public class UserInfo {
	
	
	//	�������������ֵ��ǰ������ύ����
	private String id;
	private String Name;
	public UserInfo() {
	}
	
	public UserInfo(String id, String name) {
		this.id = id;
		Name = name;
	}

	public String getId() {
		System.out.println("������getId����");
		return id;
	}
	public void setId(String id) {
		System.out.println("������setId����");
		this.id = id;
	}
	public String getName() {
		System.out.println("������getName����");
		return Name;
	}
	public void setName(String name) {
		System.out.println("������setName����");
		Name = name;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", Name=" + Name;
	}
	
}