package com.dk.groupware.member.service;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.dao.MemberDao;
import com.dk.groupware.member.model.Member;

public class LoginProcessService implements ServiceInterface{
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
	}

	@Override
	public Object service(Object obj){
		System.out.println("LoginProcessService.service()");
		Member member = (Member) memberDao.login((Member)obj);
		if(member != null)
			member.setEncId(getMD5(member.getId()+""));
		return member;
	}
	
	private String getMD5(String str) {
		StringBuffer sb = new StringBuffer();
		try {
			byte[] digest = java.security.MessageDigest.getInstance("MD5").digest(str.getBytes());
			sb.setLength(0);
			for(int i=0; i<digest.length; i++) {
				sb.append(Integer.toString((digest[i] & 0xf0) >> 4, 16));
				sb.append(Integer.toString(digest[i] & 0x0f, 16));
			}
			 return sb.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
