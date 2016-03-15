package com.dk.groupware.message.service;

import java.util.List;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.common.model.JspData;
import com.dk.groupware.common.model.PageModel;
import com.dk.groupware.message.dao.MessageDao;
import com.dk.groupware.message.model.Message;
import com.dk.groupware.message.model.MessageModel;

public class MessageListService implements ServiceInterface{

	private MessageDao messageDao;
	
	// setter
	public void setMessageDao(MessageDao messageDao){
		this.messageDao = messageDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("MessageListService.service()");
		
		PageModel pageModel = (PageModel) obj;
		
		int id = pageModel.getId();
		
		int page = pageModel.getPage();
		int totalPage = 0;
		int totalRow = 0;
		int rowsPerPage = 15;
		int startRow = 0;
		int endRow = 0;

		int pagesPerGroup = 10;
		int startPage = 0;
		int endPage = 0;
		      
		totalRow = (Integer) messageDao.totalRow(id);
		totalPage = (totalRow-1)/rowsPerPage + 1;
		startRow = (page -1 )*rowsPerPage +1;
		endRow = startRow+rowsPerPage-1;
		      
		startPage = ( page - 1 ) / pagesPerGroup * pagesPerGroup + 1;
		endPage = startPage + pagesPerGroup - 1;
		if(endPage>totalPage) endPage = totalPage;
		      
		JspData jspData = new JspData();
		jspData.setTotalPage(totalPage);
		jspData.setStartPage(startPage);
		jspData.setEndPage(endPage);
		jspData.setPage(page);
		jspData.setPagesPerGroup(pagesPerGroup);
		jspData.setStartRow(startRow);
		jspData.setEndRow(endRow);
		jspData.setId(id);

		@SuppressWarnings("unchecked")
		List<Message> list = (List<Message>) messageDao.list(jspData);

		MessageModel messageModel = new MessageModel();
		messageModel.setList(list);
		messageModel.setJspData(jspData);
		return messageModel;
	}
}
