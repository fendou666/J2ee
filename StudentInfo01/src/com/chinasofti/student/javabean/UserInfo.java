package com.chinasofti.student.javabean;

import java.util.Date;

public class UserInfo {

	@Override
	public String toString() {
		return "UserInfo [eecId=" + eecId + ", eecName=" + eecName
				+ ", nickName=" + nickName + ", sex=" + sex + ", dateOfBirth="
				+ dateOfBirth + ", age=" + age + ", constellatory="
				+ constellatory + ", managerId=" + managerId + ", groupId="
				+ groupId + ", roleId=" + roleId + ", classId=" + classId
				+ ", telephone=" + telephone + ", email=" + email
				+ ", registrationDate=" + registrationDate + ", lastLoginTime="
				+ lastLoginTime + "]";
	}

	private int eecId;
	private int eecName;
	private String nickName;
	private String headImg;
	private String sex;
	private Date dateOfBirth;
	private int age;
	private String constellatory;
	private int managerId;
	private int groupId;
	private int roleId;
	private int classId;
	private long telephone;
	private String email;
	private Date registrationDate;
	private Date lastLoginTime;
	//EEC_Name	NickName	Password	Sex	DateOfBirth	Age	Constellatory	Manager_id	Group_Id	
	//Role_id	Class_id	telephone	email	RegistrationDate	LastLoginTime
	
	public UserInfo(int eecId, int eecName, String nickName, String sex,
			Date dateOfBirth, int age, String constellatory, int managerId,
			int groupId, int roleId, int classId, long telephone, String email,
			Date registrationDate, Date lastLoginTime) {
		this.eecId = eecId;
		this.eecName = eecName;
		this.nickName = nickName;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.constellatory = constellatory;
		this.managerId = managerId;
		this.groupId = groupId;
		this.roleId = roleId;
		this.classId = classId;
		this.telephone = telephone;
		this.email = email;
		this.registrationDate = registrationDate;
		this.lastLoginTime = lastLoginTime;
	}

	public UserInfo() {
	
	}
	

	
	public int getEecId() {
		return eecId;
	}

	public void setEecId(int eecId) {
		this.eecId = eecId;
	}

	public int getEecName() {
		return eecName;
	}

	public void setEecName(int eecName) {
		this.eecName = eecName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getConstellatory() {
		return constellatory;
	}

	public void setConstellatory(String constellatory) {
		this.constellatory = constellatory;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
}