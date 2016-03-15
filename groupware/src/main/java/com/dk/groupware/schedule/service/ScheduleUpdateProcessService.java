package com.dk.groupware.schedule.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.schedule.dao.ScheduleDao;
import com.dk.groupware.schedule.model.Schedule;

public class ScheduleUpdateProcessService implements ServiceInterface{

	private ScheduleDao scheduleDao;
	
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("ScheduleUpdateProcessService.service()");
		scheduleDao.update((Schedule) obj);
		return null;
	}

}
