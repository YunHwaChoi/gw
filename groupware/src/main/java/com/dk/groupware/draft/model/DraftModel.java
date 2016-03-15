package com.dk.groupware.draft.model;

import java.util.List;

import com.dk.groupware.common.model.JspData;

public class DraftModel {
	private List<Draft> list;
	private JspData jspData;
	
	public List<Draft> getList() {
		return list;
	}
	public void setList(List<Draft> list) {
		this.list = list;
	}
	public JspData getJspData() {
		return jspData;
	}
	public void setJspData(JspData jspData) {
		this.jspData = jspData;
	}
}
