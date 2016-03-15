package com.dk.groupware.notice.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.dk.groupware.notice.model.Notice;

public class NoticeDao {

	// sql 데이터소스 import
	private SqlSessionTemplate sqlSessionTemplate;
	
	// setter
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 공지사항 리스트
	public Object list(Object obj){
		System.out.println("NoticeDao.list()");
		return sqlSessionTemplate.selectList("dao.Notice.list", obj);
	}
	
	// 공지사항 검색 리스트
	public Object searchList(Object obj){
		System.out.println("NoticeDao.searchList()");
		return sqlSessionTemplate.selectList("dao.Notice.searchList", obj);
	}
	
	// 공지사항 보기 - 수정
	public Object view(Object obj){
		System.out.println("NoticeDao.view()");
		return sqlSessionTemplate.selectOne("dao.Notice.view", obj);
	}
	
	// 공지사항 작성
	public Object write(Notice notice){
		System.out.println("NoticeDao.write()");
		sqlSessionTemplate.insert("dao.Notice.write", notice);
		return null;
	}
	
	// increase
	public Object increase(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDao.update(obj)");
		return sqlSessionTemplate.update("dao.Notice.increase", obj);
		
	}
	// 공지사항 처리
	public Object update(Notice notice){
		System.out.println("NoticeDao.update()");
		return sqlSessionTemplate.update("dao.Notice.update", notice);
	}
//	// 공지사항 처리
//	public Object update(Notice notice){
//		System.out.println("NoticeDao.update()");
//		sqlSessionTemplate.update("dao.Notice.update", notice);
//		return null;
//	}

	// 공지사항 삭제
	public Object delete(Object obj){
		System.out.println("NoticeDao.delete()");
		
		int [] nos = (int[])obj;
		for(int no: nos)
			sqlSessionTemplate.delete("dao.Notice.delete", no);
		return 1;
	}

	// 공지사항 리스트 - 메인화면용
	public Object listLimit() {
		System.out.println("NoticeDao.listLimit()");
		return sqlSessionTemplate.selectList("dao.Notice.listLimit");
	}
	// 페이징 처리를 위함
	public Object totalRow() {
		System.out.println("NoticeDao.totalRow()");
		return sqlSessionTemplate.selectOne("dao.Notice.totalRow");
	}

}
