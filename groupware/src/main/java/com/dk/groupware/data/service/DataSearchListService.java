package com.dk.groupware.data.service;

import org.springframework.stereotype.Service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.data.dao.DataDao;
import com.dk.groupware.data.model.Search;

@Service
public class DataSearchListService implements ServiceInterface{
	
	//@Resource
	private DataDao dataDao;
	
	public void setDataDao(DataDao dataDao){
		this.dataDao=dataDao;
	}

	@Override
	public Object service(Object obj) {
		System.out.println("DataSearchListService.service()");
		return dataDao.searchList(obj);
	}

}
