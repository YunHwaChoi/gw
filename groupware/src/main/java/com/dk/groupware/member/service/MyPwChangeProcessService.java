package com.dk.groupware.member.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.dao.MemberDao;

public class MyPwChangeProcessService implements ServiceInterface{

	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
	}

	@Override
	public Object service(Object obj) {
		System.out.println("MyPwChangeProcessService.service()");
		memberDao.pwUpdate(obj);
		return null;
	}

}
