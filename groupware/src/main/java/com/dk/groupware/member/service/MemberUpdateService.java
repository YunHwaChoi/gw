package com.dk.groupware.member.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.dao.MemberDao;

public class MemberUpdateService implements ServiceInterface {

	// property -> private
	private MemberDao memberDao;
	
	// setter
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
	}

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("MemberUpdateService.service()");
		return memberDao.view(obj);
	}
}
