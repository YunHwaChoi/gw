package com.dk.groupware.member.service;

import org.springframework.stereotype.Service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.dao.MemberDao;

@Service
public class MemberViewService implements ServiceInterface {
	
	// property니까 private
	private MemberDao memberDao;
	
	// setter
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
	}

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("MemberViewService.service()");
		return memberDao.view(obj);
	}

}
