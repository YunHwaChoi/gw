package com.dk.groupware.notice.service;

import java.util.List;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.common.model.JspData;
import com.dk.groupware.notice.dao.NoticeDao;
import com.dk.groupware.notice.model.Notice;
import com.dk.groupware.notice.model.NoticeModel;

public class NoticeListService implements ServiceInterface{

	private NoticeDao noticeDao;
	
	// setter
	public void setNoticeDao(NoticeDao noticeDao){
		this.noticeDao = noticeDao;
	}
	
	
	@Override
	public Object service(Object obj) {
		System.out.println("NoticeListService.service()");
		
		int page = (Integer)obj;
		int totalPage = 0;
		int totalRow = 0;
		int rowsPerPage = 15;
		int startRow = 0;
		int endRow = 0;

		int pagesPerGroup = 10;
		int startPage = 0;
		int endPage = 0;
		      
		totalRow = (Integer) noticeDao.totalRow();
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
		
		@SuppressWarnings("unchecked")
		List<Notice> list = (List<Notice>) noticeDao.list(jspData);

		NoticeModel noticeModel = new NoticeModel();
		noticeModel.setList(list);
		noticeModel.setJspData(jspData);
		return noticeModel;
	}

}
