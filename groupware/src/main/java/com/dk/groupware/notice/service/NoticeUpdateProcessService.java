package com.dk.groupware.notice.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.notice.dao.NoticeDao;
import com.dk.groupware.notice.model.Notice;

public class NoticeUpdateProcessService implements ServiceInterface{

	private NoticeDao noticeDao;
	
	// setter
	public void setNoticeDao(NoticeDao noticeDao){
		this.noticeDao = noticeDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("NoticeUpdateProcessService.service()");
		noticeDao.update((Notice)obj);
		return null;
	}

}
