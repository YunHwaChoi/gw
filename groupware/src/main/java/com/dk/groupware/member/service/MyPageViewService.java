package com.dk.groupware.member.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.dao.MemberDao;

public class MyPageViewService implements ServiceInterface {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
	}

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("MyPageViewService.service()");
		return memberDao.mview((Integer)obj);
		
	}
}
