package com.dk.groupware.member.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.dao.MemberDao;

public class MemberDeleteProcessService implements ServiceInterface {
	// property->private
	private MemberDao memberDao;

	// setter
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public Object service(Object obj) {
		System.out.println("MemberDeleteProcessService.service()");
		memberDao.delete(obj);
		return null;
	}

}
