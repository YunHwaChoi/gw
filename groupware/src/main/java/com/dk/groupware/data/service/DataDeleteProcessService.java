package com.dk.groupware.data.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.data.dao.DataDao;

public class DataDeleteProcessService implements ServiceInterface{

	private DataDao dataDao;
	
	public void setDataDao(DataDao dataDao){
		this.dataDao=dataDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("DataDeleteProcessService.service()");
		dataDao.delete(obj);
		return null;
	}
}
