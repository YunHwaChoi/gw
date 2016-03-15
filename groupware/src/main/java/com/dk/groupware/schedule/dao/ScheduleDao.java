package com.dk.groupware.schedule.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.dk.groupware.schedule.model.Schedule;


public class ScheduleDao {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 일정리스트
	public Object list(Object obj){
		System.out.println("ScheduleDao.list()");
		return sqlSessionTemplate.selectList("dao.Schedule.list", obj);
	}
	// 일정보기 - 일정수정
	public Object view(Object obj){
		System.out.println("ScheduleDao.view()");
		return sqlSessionTemplate.selectOne("dao.Schedule.view", obj);
	}
	// 일정수정처리
	public Object update(Schedule schedule){
		System.out.println("ScheduleDao.update()");
		sqlSessionTemplate.update("dao.Schedule.update",schedule);
		return null;
	}
	// 일정등록
	public Object write(Schedule schedule){
		System.out.println("ScheduleDao.write()");
		sqlSessionTemplate.insert("dao.Schedule.write",schedule);
		return null;
	}
	// 일정삭제
	public Object delete(Object obj){
		System.out.println("ScheduleDao.delete()");
		sqlSessionTemplate.delete("dao.Schedule.delete", obj);
		return null;
	}
	// 일정리스트 - 메인화면용
	public Object listLimit(int id) {
		System.out.println("ScheduleDao.listLimit()");
		return sqlSessionTemplate.selectList("dao.Schedule.listLimit", id);
	}
}
