package com.dk.groupware.board.service;

import org.springframework.stereotype.Service;

import com.dk.groupware.board.dao.BoardDao;
import com.dk.groupware.common.ServiceInterface;

@Service
public class BoardSearchListService implements ServiceInterface{
	
	//@Resource
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao){
		this.boardDao=boardDao;
	}

	@Override
	public Object service(Object obj) {
		System.out.println("BoardSearchListService.service()");
		return boardDao.searchList(obj);
	}

}
