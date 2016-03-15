package com.dk.groupware.board.service;

import com.dk.groupware.board.dao.BoardDao;
import com.dk.groupware.common.ServiceInterface;

public class BoardDeleteProcessService implements ServiceInterface{

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("BoardDeleteProcessService.service()");
		boardDao.delete(obj);
		return null;
	}

}
