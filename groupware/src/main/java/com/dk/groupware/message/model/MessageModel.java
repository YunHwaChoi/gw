package com.dk.groupware.message.model;

import java.util.List;

import com.dk.groupware.common.model.JspData;

public class MessageModel {
	private List<Message> list;
	private JspData jspData;
	
	public List<Message> getList() {
		return list;
	}
	public void setList(List<Message> list) {
		this.list = list;
	}
	public JspData getJspData() {
		return jspData;
	}
	public void setJspData(JspData jspData) {
		this.jspData = jspData;
	}
}
