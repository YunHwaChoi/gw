package com.dk.groupware.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.common.model.JspData;
import com.dk.groupware.member.dao.MemberDao;
import com.dk.groupware.member.model.Member;
import com.dk.groupware.member.model.MemberModel;

@Service
public class MemberListService implements ServiceInterface{

	// xml <bean>에서 <property>니까 -> private
	private MemberDao memberDao;
	
	// setters
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("MemberListService.service()");
		
		int page = (Integer)obj;
		int totalPage = 0;
		int totalRow = 0;
		int rowsPerPage = 15;
		int startRow = 0;
		int endRow = 0;

		int pagesPerGroup = 10;
		int startPage = 0;
		int endPage = 0;
		
		totalRow = (Integer) memberDao.totalRow();
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
		List<Member> list = (List<Member>) memberDao.list(jspData);
		
		MemberModel memberModel = new MemberModel();
		memberModel.setList(list);
		memberModel.setJspData(jspData);
		return memberModel;
//		return memberDao.list();
	}

}
