package com.dk.groupware.draft.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.draft.dao.DraftDao;
import com.dk.groupware.draft.model.Draft;

public class DraftWriteProcessService implements ServiceInterface {
	private DraftDao draftDao;
	
	public void setDraftDao(DraftDao draftDao) {
		this.draftDao = draftDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("DraftWriteProcessService.service()");
		draftDao.write((Draft) obj);
		return null;
	}
}
