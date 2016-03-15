package com.dk.groupware.schedule.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.schedule.dao.ScheduleDao;

public class ScheduleViewService implements ServiceInterface{

	private ScheduleDao scheduleDao;
	
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("ScheduleViewService.service()");
		return scheduleDao.view(obj);
	}

}
