package com.dk.groupware.anonymous.service;

import com.dk.groupware.anonymous.dao.AnonymousDao;
import com.dk.groupware.anonymous.model.Anonymous;
import com.dk.groupware.common.ServiceInterface;

public class AnonymousUpdateProcessService implements ServiceInterface {
	private AnonymousDao anonymousDao;
	
	public void setAnonymousDao(AnonymousDao anonymousDao) {
		this.anonymousDao = anonymousDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("AnonymousUpdateProcessService.service()");
		anonymousDao.update((Anonymous) obj);
		return null;
	}
}
