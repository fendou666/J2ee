package com.study.mvc.model.dao;

import com.study.mvc.model.javabean.StudentInfo;

public interface ILoginDAO {

	public StudentInfo cheStudentInfo(StudentInfo stu, String pwd);
}
