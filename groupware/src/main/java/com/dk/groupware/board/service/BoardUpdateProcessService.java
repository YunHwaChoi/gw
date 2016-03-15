package com.dk.groupware.board.service;

import com.dk.groupware.board.dao.BoardDao;
import com.dk.groupware.board.model.Board;
import com.dk.groupware.common.ServiceInterface;

public class BoardUpdateProcessService implements ServiceInterface{

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("BoardUpdateProcessService.service()");
		boardDao.update((Board) obj);
		return null;
	}

}
