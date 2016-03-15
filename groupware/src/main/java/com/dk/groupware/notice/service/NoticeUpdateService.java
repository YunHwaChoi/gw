package com.dk.groupware.notice.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.notice.dao.NoticeDao;

public class NoticeUpdateService implements ServiceInterface{

	private NoticeDao noticeDao;
	
	// setter
	public void setNoticeDao(NoticeDao noticeDao){
		this.noticeDao = noticeDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("NoticeUpdateService.service()");
		// 글번호를 바로 넣는다.
		return noticeDao.view(obj);
	}

}
