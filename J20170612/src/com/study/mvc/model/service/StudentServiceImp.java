package com.study.mvc.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.study.mvc.model.dao.IStudentDAO;
import com.study.mvc.model.dao.StudentDAOImp;
import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.tools.DBUtil;

public class StudentServiceImp implements IStudentService {
	IStudentDAO studentDAO = new StudentDAOImp();
	
	@Override
	public StudentInfo getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public StudentInfo getStudentByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentInfo> getStudentByName(String name) {
		List<StudentInfo> stuList = null;
		HashMap mp = studentDAO.getStudentByName(name);
		if(mp!=null){
			stuList = (List<StudentInfo>)mp.get("stuList");
		}
		return stuList;
	}

	@Override
	public List<StudentInfo> getStudentBySex(String sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentInfo> getStudentByAge(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentInfo> getStudentBySchool(String schoolName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentInfo> getStudentByCondition(int num, String name,
			String sex, int start, int end, String schoolName) {
		List<StudentInfo> stuList = null;
		HashMap mp = studentDAO.getStudentByCondition(num, name, sex, start, end, schoolName);
		if(mp!=null){
			stuList = (List<StudentInfo>)mp.get("stuList");
		}
		return stuList;
	}

	@Override
	public boolean insertStudentInfo(StudentInfo stu) {
		return false;
	}

	@Override
	public boolean deleteStudentInfo(int num) {
		return studentDAO.deleteStudentInfo(num);
	}

	@Override
	public boolean saveStudentInfo(StudentInfo stu) {
		return studentDAO.saveStudentInfo(stu);
	}

	@Override
	public List<StudentInfo> getStudentAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
