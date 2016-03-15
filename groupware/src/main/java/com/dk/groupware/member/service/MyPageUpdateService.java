package com.dk.groupware.member.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.dao.MemberDao;

public class MyPageUpdateService implements ServiceInterface{
	
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
	}

	@Override
	public Object service(Object obj) {
		System.out.println("MyPageUpdateService.service()");
		return memberDao.mview(obj);
	}

}
