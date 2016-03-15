package com.dk.groupware.notice.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.notice.dao.NoticeDao;

public class NoticeViewService implements ServiceInterface{

	private NoticeDao noticeDao;
	
	// setter
	public void setNoticeDao(NoticeDao noticeDao){
		this.noticeDao = noticeDao;
	}
	
	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("NoticeViewService.service()");
//		 조회수 증가
		noticeDao.increase(obj);
		return noticeDao.view(obj);
	}

	
}
