package com.dk.groupware.data.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.data.dao.DataDao;
import com.dk.groupware.data.model.Data;

public class DataWriteProcessService implements ServiceInterface{
	
	private DataDao dataDao;
	
	public void setDataDao(DataDao dataDao){
		this.dataDao=dataDao;
	}

	@Override
	public Object service(Object obj){
		System.out.println("DataWriteProcessService.service()");
		dataDao.write((Data)obj);
		return null;
	}

}
