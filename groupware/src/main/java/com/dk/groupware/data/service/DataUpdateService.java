package com.dk.groupware.data.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.data.dao.DataDao;
import com.dk.groupware.data.model.Data;

public class DataUpdateService implements ServiceInterface{
	
	private DataDao dataDao;
	
	public void setDataDao(DataDao dataDao) {
		this.dataDao = dataDao;
	}

	@Override
	public Object service(Object obj) {
		System.out.println("DataUpdateService.service()");
		return dataDao.view(obj);
	}

}
