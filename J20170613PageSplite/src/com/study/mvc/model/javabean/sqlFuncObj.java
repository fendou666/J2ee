package com.study.mvc.model.javabean;

public class sqlFuncObj {
	
	
	
	private String parmsType; //in out inOut
	private int paramsIndex; // sql ���indexλ��
	private Object obj;  // sql���ֵ
	private int sqlType; // sql ����
	
	public sqlFuncObj(String parmsType, int paramsIndex, Object obj, int sqlType) {
		this.parmsType = parmsType;
		this.paramsIndex = paramsIndex;
		this.obj = obj;
		this.sqlType = sqlType;
	}
	public sqlFuncObj() {
	
	}
	
	public String getParmsType() {
		return parmsType;
	}
	public void setParmsType(String parmsType) {
		this.parmsType = parmsType;
	}
	public int getParamsIndex() {
		return paramsIndex;
	}
	public void setParamsIndex(int paramsIndex) {
		this.paramsIndex = paramsIndex;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public int getSqlType() {
		return sqlType;
	}
	public void setSqlType(int sqlType) {
		this.sqlType = sqlType;
	}
	
	@Override
	public String toString() {
		return "sqlFuncObj [parmsType=" + parmsType + ", paramsIndex="
				+ paramsIndex + ", obj=" + obj + ", sqlType=" + sqlType + "]";
	}
	
	
}
