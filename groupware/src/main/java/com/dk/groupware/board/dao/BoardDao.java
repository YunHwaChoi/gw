package com.dk.groupware.board.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.dk.groupware.board.model.Board;


public class BoardDao {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 글리스트
	public Object list(Object obj){
		System.out.println("BoardDao.list()");
		return sqlSessionTemplate.selectList("dao.Board.list", obj);
	}
	// 글보기 - 글수정
	public Object view(Object obj){
		System.out.println("BoardDao.view()");
		return sqlSessionTemplate.selectOne("dao.Board.view", obj);
	}
	// 글수정처리
	public Object update(Board board){
		System.out.println("BoardDao.update()");
		sqlSessionTemplate.update("dao.Board.update",board);
		return null;
	}
	// 글쓰기
	public Object write(Board board){
		System.out.println("BoardDao.write()");
		sqlSessionTemplate.insert("dao.Board.write",board);
		return null;
	}
	// 글삭제
	public Object delete(Object obj){
		System.out.println("BoardDao.delete()");
		sqlSessionTemplate.delete("dao.Board.delete", obj);
		return null;
	}
	// 조회수
	public Object hit(Object obj){
		System.out.println("BoardDao.hit()");
		return sqlSessionTemplate.update("dao.Board.hit", obj);
	}
	// 페이징처리
	public Object totalRow(){
		System.out.println("BoardDao.totlaRow()");
		return sqlSessionTemplate.selectOne("dao.Board.selectCount");
	}
	// 글검색
	public Object searchList(Object obj) {
		System.out.println("BoardDao.searchList()");
		return sqlSessionTemplate.selectList("dao.Board.searchList", obj);
	}
}
