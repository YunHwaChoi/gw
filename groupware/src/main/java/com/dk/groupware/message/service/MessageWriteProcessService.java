package com.dk.groupware.message.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.message.dao.MessageDao;
import com.dk.groupware.message.model.Message;

public class MessageWriteProcessService implements ServiceInterface{

		private MessageDao messageDao;
		
		// setter
		public void setMessageDao(MessageDao messageDao){
			this.messageDao = messageDao;
		}
		
		@Override
		public Object service(Object obj) {
			// TODO Auto-generated method stub
			System.out.println("MessageWriteProcessService.service()");
			messageDao.write((Message)obj);
			return null;
		}
}
