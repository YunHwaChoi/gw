package com.dk.groupware.message.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.dk.groupware.message.model.Message;

public class MessageDao {
	
	// sql의 데이터 소스 import
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	// setter
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 쪽지 (보내기/받기/읽기/삭제) dao 
	
	// 받은쪽지 목록 가져오기 - list
	public Object list(Object obj){
		System.out.println("MessageDao.list()");
		// 값 확인
		return sqlSessionTemplate.selectList("dao.Message.list", obj);
	}
	
	// 받은쪽지 검색 - list
//	public Object searchList(Object obj){
//		System.out.println("MessageDao.searchList()");
//		 값 확인
//		return sqlSessionTemplate.selectList("dao.Message.searchList", obj);
//	}
	// 쪽지 보내기 - write
	public Object write(Message message){
		System.out.println("MessageDao.write()");
		sqlSessionTemplate.insert("dao.Message.write", message);
		return null;
	}
	// 받은 쪽지 보기 - view
	public Object view(Object obj){
		System.out.println("MessageDao.view()");
		return sqlSessionTemplate.selectOne("dao.Message.view", obj);
		
	}
	// 쪽지 읽음 처리 - update
	public Object update(Object obj){
		System.out.println("MessageDao.update(obj)");
		sqlSessionTemplate.update("dao.Message.update", obj);
		return null;
	}
	
	// 받은 쪽지 삭제 - delete
	// 체크박스 선택- 삭제 처리 때문에 리턴 값을 그대로 주면 안 되기 때문에 1로 준다.
	public Object delete(Object obj){
		System.out.println("MessageDao.delete()");
		int [] nos = (int[])obj;
		for(int no : nos) {
			if(sqlSessionTemplate.delete("dao.Message.delete", no) == 0)
				return 0;
		}
		return 1;
	}
	
	// 보낸 쪽지 리스트
	public Object sendList(Object obj) {
		System.out.println("MessageDao.sendList()");
		// 값 확인
		return sqlSessionTemplate.selectList("dao.Message.sendList", obj);
	}
	
	// 보낸 쪽지 보기
	public Object sendView(Object obj) {
		System.out.println("MessageDao.sendView()");
		return sqlSessionTemplate.selectOne("dao.Message.sendView", obj);
	}
	
	// 보낸 쪽지 삭제
	// 체크박스 선택- 삭제 처리 때문에 리턴 값을 그대로 주면 안 되기 때문에 1로 준다.
	public Object sendDelete(Object obj) {
		System.out.println("MessageDao.delete()");
		int [] nos = (int[])obj;
		for(int no : nos) {
			if(sqlSessionTemplate.delete("dao.Message.sendDelete", no) == 0)
			return 0;
		}
		return 1;
	}

	// 새 쪽지 표시
	public Object count(Object obj) {
		System.out.println("MessageDao.count()");
		return sqlSessionTemplate.selectOne("dao.Message.count", obj);
	}

	// 받은 쪽지 리스트 - 메인화면용
	public Object listLimit(int id) {
		System.out.println("MessageDao.listLimit()");
		return sqlSessionTemplate.selectList("dao.Message.listLimit", id);
	}

	public Object totalRow(int id) {
		return sqlSessionTemplate.selectOne("dao.Message.totalRow", id);
	}
	
	public Object sendTotalRow(int id) {
		return sqlSessionTemplate.selectOne("dao.Message.sendTotalRow", id);
	}
	
}
