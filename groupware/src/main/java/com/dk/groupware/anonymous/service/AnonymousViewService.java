package com.dk.groupware.anonymous.service;

import com.dk.groupware.anonymous.dao.AnonymousDao;
import com.dk.groupware.common.ServiceInterface;

public class AnonymousViewService implements ServiceInterface {
	private AnonymousDao anonymousDao;
	
	public void setAnonymousDao(AnonymousDao anonymousDao) {
		this.anonymousDao = anonymousDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("AnonymousViewService.service()");
		anonymousDao.increase(obj);
		return anonymousDao.view(obj);
	}
}
