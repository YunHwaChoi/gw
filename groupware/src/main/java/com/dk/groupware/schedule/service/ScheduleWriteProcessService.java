package com.dk.groupware.schedule.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.schedule.dao.ScheduleDao;
import com.dk.groupware.schedule.model.Schedule;

public class ScheduleWriteProcessService implements ServiceInterface{

	private ScheduleDao scheduleDao;
	
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("BoardWriteProcessService.service()");
		scheduleDao.write((Schedule) obj);
		return null;
	}

}
