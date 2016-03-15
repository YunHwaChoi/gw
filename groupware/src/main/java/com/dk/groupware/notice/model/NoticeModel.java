package com.dk.groupware.notice.model;

import java.util.List;

import com.dk.groupware.common.model.JspData;

public class NoticeModel {
	private List<Notice> list;
	private JspData jspData;
	
	public List<Notice> getList() {
		return list;
	}
	public void setList(List<Notice> list) {
		this.list = list;
	}
	public JspData getJspData() {
		return jspData;
	}
	public void setJspData(JspData jspData) {
		this.jspData = jspData;
	}
}
