package com.dk.groupware.data.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.data.dao.DataDao;

public class DataViewService implements ServiceInterface {
	
	private DataDao dataDao;

	public void setDataDao(DataDao dataDao) {
		this.dataDao=dataDao;
	}

	@Override
	public Object service(Object obj) {
		System.out.println("DataViewService.service()");
		// 조회수 증가
		dataDao.increase(obj);
		return dataDao.view(obj);
	}

}
