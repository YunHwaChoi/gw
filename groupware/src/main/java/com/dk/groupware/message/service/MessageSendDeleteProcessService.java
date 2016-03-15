package com.dk.groupware.message.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.message.dao.MessageDao;

public class MessageSendDeleteProcessService implements ServiceInterface{

	private MessageDao messageDao;
	
	// setter
	public void setMessageDao(MessageDao messageDao){
		this.messageDao = messageDao;
	}
	
	// 보낸 쪽지 삭제 : rdate가 null 일때만 가능(버튼생성)
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("MessageSendDeleteProcessService.service()");
		return messageDao.sendDelete(obj);
	}
	
}
