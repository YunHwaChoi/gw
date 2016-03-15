package com.dk.groupware.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.dk.groupware.member.model.Member;

public class MemberDao {

	// xml <bean>에서 <property>니까 -> private
	private SqlSessionTemplate sqlSessionTemplate;
	
	// setter
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	
	// 사원 리스트
	public Object list(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("MemberDao.list()");
		return sqlSessionTemplate.selectList("dao.Member.list", obj);
	}
	
	// 사원 ID 찾기 (사원 검색 리스트)
	public Object searchList(Object obj) {
		System.out.println("MemberDao.searchList()");
		return sqlSessionTemplate.selectList("dao.Member.searchList", obj);
	}


	// 사원 정보 보기 - 정보 수정
	public Object view(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("MemberDao.view()");
		return sqlSessionTemplate.selectOne("dao.Member.view", obj);
	}

	// 사원 정보 수정 처리
	public Object update(Member member) {
		// TODO Auto-generated method stub
		System.out.println("MemberDao.update()");
		sqlSessionTemplate.update("dao.Member.update", member);
		return null;
	}
	
	// 사원 비밀번호 리셋(수정)
	public Object pwreset(Object obj){
		System.out.println("MemberDao.pwreset()");
		sqlSessionTemplate.update("dao.Member.pwreset", obj);
		return null;
	}

	// 사원 등록
	public Object write(Member member) {
		// TODO Auto-generated method stub
		System.out.println("MemberDao.write()");
		sqlSessionTemplate.insert("dao.Member.write", member);
		return null;
	}

	// 사원 탈퇴(퇴사)
	public Object delete(Object obj) {
		System.out.println("MemberDao.delete()"); 
		sqlSessionTemplate.delete("dao.Member.delete", obj);
		return null;
	}

	// 내정보 보기
	public Object mview(Object obj){
		System.out.println("MemberDao.mview()");
		return sqlSessionTemplate.selectOne("dao.Member.mview", obj);
	}
	
	// 내정보 수정
	public Object mupdate(Member member) {
		System.out.println("MemberDao.mupdate()");
		sqlSessionTemplate.update("dao.Member.mupdate", member);
		return null;
	}
	
	// 내 비밀번호 수정
	public Object pwUpdate(Object obj) {
		System.out.println("MemberDao.pwUpdate()");
		sqlSessionTemplate.update("dao.Member.pwUpdate", obj);
		return null;
	}
	
	// 기존 비밀번호 확인
	public Object currentPwCheck(Object obj) {
		System.out.println("MemberDao.currentPwCheck()");
		return sqlSessionTemplate.selectOne("dao.Member.currentPwCheck", obj);
	}

	// 로그인
	public Object login(Member member) {
		System.out.println("MemberDao.login()");
		return sqlSessionTemplate.selectOne("dao.Member.login", member);
	}
	
	// totalRow 받아오는 메소드
	public Object totalRow(){
		System.out.println("MemberDao.totalRow()");
		return sqlSessionTemplate.selectOne("dao.Member.totalRow");
	}

	// 결재자 선택용
	public Object selectSigner(Object obj) {
		System.out.println("MemberDao.selectSigner()");
		return sqlSessionTemplate.selectList("dao.Member.selectSigner", obj);
	}

}
