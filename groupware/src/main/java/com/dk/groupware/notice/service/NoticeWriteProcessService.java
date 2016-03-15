package com.dk.groupware.notice.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.notice.dao.NoticeDao;
import com.dk.groupware.notice.model.Notice;

public class NoticeWriteProcessService implements ServiceInterface{

	private NoticeDao noticeDao;
	
	// setter
	public void setNoticeDao(NoticeDao noticeDao){
		this.noticeDao = noticeDao;
	}
	
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("NoticeWriteProcessService.service()");
		noticeDao.write((Notice)obj);
		return null;
	}

}
