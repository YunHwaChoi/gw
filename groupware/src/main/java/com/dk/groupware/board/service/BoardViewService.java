package com.dk.groupware.board.service;

import com.dk.groupware.board.dao.BoardDao;
import com.dk.groupware.common.ServiceInterface;

public class BoardViewService implements ServiceInterface{

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("BoardViewService.service()");
		boardDao.hit(obj);
		return boardDao.view(obj);
	}

}
