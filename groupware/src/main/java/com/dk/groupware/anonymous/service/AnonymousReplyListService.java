package com.dk.groupware.anonymous.service;

import java.util.List;

import com.dk.groupware.anonymous.dao.AnonymousDao;
import com.dk.groupware.anonymous.model.AnonymousReply;
import com.dk.groupware.anonymous.model.AnonymousReplyModel;
import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.common.model.JspData;
import com.dk.groupware.common.model.PageModel;

public class AnonymousReplyListService implements ServiceInterface {
	private AnonymousDao anonymousDao;
	
	public void setAnonymousDao(AnonymousDao anonymousDao) {
		this.anonymousDao = anonymousDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("AnonymousReplyListService.service()");

		PageModel pageModel = (PageModel) obj;
		
		int no = pageModel.getId();
		
		int page = pageModel.getPage();
		int totalPage = 0;
		int totalRow = 0;
		int rowsPerPage = 10;
		int startRow = 0;
		int endRow = 0;

		int pagesPerGroup = 10;
		int startPage = 0;
		int endPage = 0;
		
		totalRow = anonymousDao.replyTotalRow(no);
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
		jspData.setId(no);
		
		System.out.println(jspData);
		
		@SuppressWarnings("unchecked")
		List<AnonymousReply> list = (List<AnonymousReply>) anonymousDao.replyList(jspData);
		
		AnonymousReplyModel anonymousReplyModel = new AnonymousReplyModel();
		anonymousReplyModel.setList(list);
		anonymousReplyModel.setJspData(jspData);
		
		return anonymousReplyModel;
	}
}
