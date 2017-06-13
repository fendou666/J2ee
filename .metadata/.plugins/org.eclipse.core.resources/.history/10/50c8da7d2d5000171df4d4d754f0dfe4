package com.study.mvc.model.dao;

import java.util.HashMap;
import java.util.List;

import com.study.mvc.model.javabean.StudentInfo;

public interface IStudentDAO {
	// 查询
	public HashMap getStudentById(int id);
	public HashMap getStudentByNum(int num);
	public HashMap getStudentByName(String name);
	public HashMap getStudentBySex(String sex);
	public HashMap getStudentByAge(int start, int end);
	public HashMap getStudentBySchool(String schoolName);
	public HashMap getStudentByCondition(int num, String name, String sex, 
			int start, int end, String schoolName);
	public HashMap getStudentAll();
	
	// 增加
	public boolean insertStudentInfo(StudentInfo stu);
	// 删除
	public boolean deleteStudentInfo(int num);
	// 修改
	public boolean saveStudentInfo(StudentInfo stu);
}
