package com.dk.groupware.schedule.model;

import java.util.List;

import com.dk.groupware.common.model.JspData;

public class ScheduleModel {
	private List<Schedule> list;
	private JspData jspData;
	
	public List<Schedule> getList() {
		return list;
	}
	public void setList(List<Schedule> list) {
		this.list = list;
	}
	public JspData getJspData() {
		return jspData;
	}
	public void setJspData(JspData jspData) {
		this.jspData = jspData;
	}
}
