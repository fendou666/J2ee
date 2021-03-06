package com.study.mvc.model.javabean;

public class StudentInfo {
	
	private int num;
	private String name;
	private String sex;
	private int age;
	private String school;
	public StudentInfo(int num, String name, String sex, int age, String school) {
		this.num = num;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.school = school;
	}
	public StudentInfo() {
		
	}
	@Override
	public String toString() {
		return "StudentInfo [num=" + num + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", school=" + school + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	
}
