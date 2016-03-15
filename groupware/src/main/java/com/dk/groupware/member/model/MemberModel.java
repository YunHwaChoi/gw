package com.dk.groupware.member.model;

import java.util.List;

import com.dk.groupware.common.model.JspData;

public class MemberModel {
	private List<Member> list;
	private JspData jspData;
	
	public List<Member> getList() {
		return list;
	}
	public void setList(List<Member> list) {
		this.list = list;
	}
	public JspData getJspData() {
		return jspData;
	}
	public void setJspData(JspData jspData) {
		this.jspData = jspData;
	}
}
