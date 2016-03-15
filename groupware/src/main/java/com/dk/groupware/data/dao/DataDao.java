package com.dk.groupware.data.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.dk.groupware.data.model.Data;

public class DataDao {

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	// 글리스트
	public Object list(Object obj) {
		System.out.println("DataDao.list()");
		return sqlSessionTemplate.selectList("dao.Data.list", obj);
	}
	
	// 데이터 검색 리스트
	public Object searchList(Object obj) {
		System.out.println("DataDao.searchList()");
		return sqlSessionTemplate.selectList("dao.Data.searchList", obj);
	}

	// 글보기 - 글수정
	public Object view(Object obj) {
		System.out.println("DataDao.view()");
		return sqlSessionTemplate.selectOne("dao.Data.view", obj);
	}

	// 글수정처리
	public Object update(Data data) {
		System.out.println("DataDao.update()");
		return sqlSessionTemplate.update("dao.Data.update", data);
	}

	// 글쓰기
	public Object write(Data data) {
		System.out.println("DataDao.write()");
		sqlSessionTemplate.insert("dao.Data.write", data);
//		System.out.println(sqlSessionTemplate.insert("dao.Data.write", data));
		return null;
	}
	
	// increase (조회수 증가)
	public Object increase(Object obj){
		System.out.println("DataDao.increase()");
		return sqlSessionTemplate.update("dao.Data.increase", obj);
	}

	// 글삭제
	public Object delete(Object obj) {
		System.out.println("DataDao.delete()");
		sqlSessionTemplate.delete("dao.Data.delete", obj);
		return null;
	}
	
	// 페이징 처리 위한 totlaRow()
	public Object totalRow() {
		System.out.println("DataDao.totalRow()");
		return sqlSessionTemplate.selectOne("dao.Data.totalRow");
	}
}
