package com.dk.groupware.member.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.dao.MemberDao;
import com.dk.groupware.member.model.Member;

public class MemberWriteProcessService implements ServiceInterface {
	// property->private
	private MemberDao memberDao;
	
	// setter
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
	}
	
	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("MemberWriteProcessService.service()");
		memberDao.write((Member) obj);
		return null;
	}

}
