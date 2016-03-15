package com.dk.groupware.draft.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.draft.dao.DraftDao;

public class DoneViewService implements ServiceInterface {
	private DraftDao draftDao;
	
	public void setDraftDao(DraftDao draftDao) {
		this.draftDao = draftDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("DoneViewService.service()");
		return draftDao.doneView(obj);
	}
}
