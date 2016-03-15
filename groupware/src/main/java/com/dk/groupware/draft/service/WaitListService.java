package com.dk.groupware.draft.service;

import java.util.List;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.common.model.JspData;
import com.dk.groupware.common.model.PageModel;
import com.dk.groupware.draft.dao.DraftDao;
import com.dk.groupware.draft.model.Draft;
import com.dk.groupware.draft.model.DraftModel;

public class WaitListService implements ServiceInterface {
	private DraftDao draftDao;
	
	public void setDraftDao(DraftDao draftDao) {
		this.draftDao = draftDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("WaitListService.service()");

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
		
		totalRow = draftDao.waitTotalRow(id);
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
		
		System.out.println(jspData);
		
		@SuppressWarnings("unchecked")
		List<Draft> list = (List<Draft>) draftDao.waitList(jspData);
		
		DraftModel draftModel = new DraftModel();
		draftModel.setList(list);
		draftModel.setJspData(jspData);
		
		return draftModel;
	}
}
