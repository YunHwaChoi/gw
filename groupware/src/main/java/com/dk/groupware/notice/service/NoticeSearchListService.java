package com.dk.groupware.notice.service;

import org.springframework.stereotype.Service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.notice.dao.NoticeDao;

@Service
public class NoticeSearchListService implements ServiceInterface{
	
	//@Resource
	private NoticeDao noticeDao;
	
	public void setNoticeDao(NoticeDao noticeDao){
		this.noticeDao=noticeDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("NoticeSearchListService.service()");
		return noticeDao.searchList(obj);
	}

}
