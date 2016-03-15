package com.dk.groupware.anonymous.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.dk.groupware.anonymous.model.Anonymous;

public class AnonymousDao {
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public Object list(Object obj) {
		System.out.println("AnonymousDao.list()");
		return sqlSessionTemplate.selectList("dao.Anonymous.list", obj);
	}
	
	public Integer totalRow() {
		System.out.println("AnonymousDao.totalRow()");
		return sqlSessionTemplate.selectOne("dao.Anonymous.totalRow");
	}
	
	public Object view(Object obj) {
		System.out.println("AnonymousDao.view()");
		return sqlSessionTemplate.selectOne("dao.Anonymous.view", obj);
	}
	
	public Object update(Anonymous anonymous) {
		System.out.println("AnonymousDao.update()");
		sqlSessionTemplate.update("dao.Anonymous.update", anonymous);
		return null;
	}
	
	public Object write(Object obj) {
		System.out.println("AnonymousDao.write()");
		sqlSessionTemplate.insert("dao.Anonymous.write", obj);
		return null;
	}
	
	public Object delete(Object obj) {
		System.out.println("AnonymousDao.delete()");
		sqlSessionTemplate.delete("dao.Anonymous.delete", obj);
		return null;
	}
	
	public Object increase(Object obj) {
		System.out.println("AnonymousDao.increase()");
		return sqlSessionTemplate.update("dao.Anonymous.increase", obj);
	}

	public Object replyList(Object obj) {
		System.out.println("AnonymousDao.replyList()");
		return sqlSessionTemplate.selectList("dao.Anonymous.replyList", obj);
	}
	
	public Integer replyTotalRow(int no) {
		System.out.println("AnonymousDao.replyTotalRow()");
		return sqlSessionTemplate.selectOne("dao.Anonymous.replyTotalRow", no);
	}
	
	public Object replyWrite(Object obj) {
		System.out.println("AnonymousDao.replyWrite()");
		sqlSessionTemplate.insert("dao.Anonymous.replyWrite", obj);
		return null;
	}

	public Object replyUpdate(Object obj) {
		System.out.println("AnonymousDao.replyUpdate()");
		sqlSessionTemplate.update("dao.Anonymous.replyUpdate", obj);
		return null;
	}
	
	public Object replyDelete(Object obj) {
		System.out.println("AnonymousDao.replyDelete()");
		sqlSessionTemplate.delete("dao.Anonymous.replyDelete", obj);
		return null;
	}
}
