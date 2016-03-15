package com.dk.groupware.data.model;

import java.util.List;

import com.dk.groupware.common.model.JspData;

public class DataModel {
	private List<Data> list;
	private JspData jspData;
	
	public List<Data> getList() {
		return list;
	}
	public void setList(List<Data> list) {
		this.list = list;
	}
	public JspData getJspData() {
		return jspData;
	}
	public void setJspData(JspData jspData) {
		this.jspData = jspData;
	}
}
