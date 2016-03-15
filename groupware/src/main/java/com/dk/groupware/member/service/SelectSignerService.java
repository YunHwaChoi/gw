package com.dk.groupware.member.service;

import org.springframework.stereotype.Service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.dao.MemberDao;

@Service
public class SelectSignerService implements ServiceInterface{
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
	}
	
	@Override
	public Object service(Object obj) {
		System.out.println("SelectSignerService.service()");
		return memberDao.selectSigner(obj);
	}

}
