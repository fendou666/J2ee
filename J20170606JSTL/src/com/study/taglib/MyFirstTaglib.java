package com.study.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class MyFirstTaglib extends TagSupport {
	private static final long serialVersionUID = 1L;
	private PageContext pageContext;
	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public int doStartTag() throws JspException{
		try {
			pageContext.getOut().write("MyFirstTagLib key:" + key + "value:" +value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		super.setPageContext(pageContext);
	}
}
