package com.dk.groupware.anonymous.model;

import java.util.List;

import com.dk.groupware.common.model.JspData;

public class AnonymousModel {
	private List<Anonymous> list;
	private JspData jspData;
	
	public List<Anonymous> getList() {
		return list;
	}
	public void setList(List<Anonymous> list) {
		this.list = list;
	}
	public JspData getJspData() {
		return jspData;
	}
	public void setJspData(JspData jspData) {
		this.jspData = jspData;
	}
}
