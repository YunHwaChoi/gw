package com.dk.groupware.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.common.model.JspData;
import com.dk.groupware.data.dao.DataDao;
import com.dk.groupware.data.model.Data;
import com.dk.groupware.data.model.DataModel;

@Service
public class DataListService implements ServiceInterface{
	
	//@Resource
	private DataDao dataDao;
	
	public void setDataDao(DataDao dataDao){
		this.dataDao=dataDao;
	}

	@Override
	public Object service(Object obj) {
		System.out.println("DataListService.service()");
		
		int page = (Integer)obj;
		int totalPage = 0;
		int totalRow = 0;
		int rowsPerPage = 15;
		int startRow = 0;
		int endRow = 0;

		int pagesPerGroup = 10;
		int startPage = 0;
		int endPage = 0;
		
		totalRow = (Integer) dataDao.totalRow();
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
		List<Data> list = (List<Data>) dataDao.list(jspData);
		
		DataModel dataModel = new DataModel();
		dataModel.setList(list);
		dataModel.setJspData(jspData);
		return dataModel;
		
//		return dataDao.list();
	}

}
