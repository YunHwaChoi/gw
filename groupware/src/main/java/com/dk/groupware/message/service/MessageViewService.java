package com.dk.groupware.message.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.message.dao.MessageDao;
import com.dk.groupware.message.model.Message;

public class MessageViewService implements ServiceInterface{
	private MessageDao messageDao;
	
	// setter
	public void setMessageDao(MessageDao messageDao){
		this.messageDao = messageDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("MessageViewService.service()");
		
		Message message = (Message) messageDao.view(obj);
		
		// rdate가 null일 때, date 값을 채우기 위함
		if(message !=null){
			if(message.getRdate() == null)
				messageDao.update(obj);
			return messageDao.view(obj);
		}
		return null;
	}
}
