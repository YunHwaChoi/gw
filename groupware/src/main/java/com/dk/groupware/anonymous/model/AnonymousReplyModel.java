package com.dk.groupware.anonymous.model;

import java.util.List;

import com.dk.groupware.common.model.JspData;

public class AnonymousReplyModel {
	private List<AnonymousReply> list;
	private JspData jspData;
	
	public List<AnonymousReply> getList() {
		return list;
	}
	public void setList(List<AnonymousReply> list) {
		this.list = list;
	}
	public JspData getJspData() {
		return jspData;
	}
	public void setJspData(JspData jspData) {
		this.jspData = jspData;
	}
}
