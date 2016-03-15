package com.dk.groupware.board.service;

import java.util.List;

import com.dk.groupware.board.dao.BoardDao;
import com.dk.groupware.board.model.Board;
import com.dk.groupware.board.model.BoardModel;
import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.common.model.JspData;

public class BoardListService implements ServiceInterface{

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("BoardListService.service()");
		
//		List<Board> list = null;
		// page 처리를 위한 변수 선언
		// page : 현재 page = 보여줄 page(기본=1)
		int page = (Integer)obj;
		int totalPage = 0; // 전체 page = (전체글수-1)/페이지당글수+1
		int totalRow = 0; // 전체 글수 = DB에서 가져온다. Dao의 메소드 호출
		int rowsPerPage = 15; // 한페이지에 보여줄 글의 갯수 : 정해준다
		int startRow = 0; // DB에서 가져올 글의 첫번재 순서(rownum) 번호
		// startRow = (page-1)*rowsPerPage+1
		int endRow = 0; // DB에서 가져올 글의 마지막 순서(rownum) 번호
		// endRow = startRow+rowsPerPage-1
		int pagesPerGroup = 10; // 한화면에 나타날 페이지 갯수
		int startPage = 0; // 화면에 처음시작하는 페이지
		// (현재 페이지-1)/한화면의 페이지갯수 * 한화면의 페이지갯수+1
		int endPage = 0; // 화면에 나타나는 끝 페이지
		// 시작페이지+한화면의 페이지 갯수 -1 : 마지막 페이지를 넘을 수 없다.
		// DB에서 데이터를 가져오기 위한 dao를 생성 - 호출(list())
//		BoardDao dao = new BoardDao();
		// 전체 줄 수를 구해오는 메소드 호출
		totalRow = (Integer) boardDao.totalRow();
		// 전체 페이지 = (전체 줄 수 -1)/한페이지당 줄 수+1
		totalPage = (totalRow-1)/rowsPerPage+1;
		// 현재 페이지의 첫번째 줄번호 = (현재 페이지 -1)*한페이지당 글 수+1
		startRow = (page-1)*rowsPerPage+1;
		// 현재 페이지의 마지막 줄번호 = 첫번째 줄번호+한페이지당 글 수-1
		endRow = startRow+rowsPerPage-1;
		// 시작페이지 = (현재페이지-1)/한화면당 페이지수 * 한화면당 페이지수+1
		startPage = (page-1)/pagesPerGroup*pagesPerGroup+1;
		// 끝페이지 = 시작페이지 + 한화면당 페이지수-1 : 마지막 페이지를 넘을 수 없다.
		endPage = startPage+pagesPerGroup-1;
		if(endPage>totalPage) endPage = totalPage;
		System.out.println("BoardListService.service().totalRow"+totalRow);
//		list = dao.list(startRow, endRow);
		// jsp에 totalPage를 넘기기 위해서 JspData를 생성 후 담는다.
		JspData jspData = new JspData();
		jspData.setTotalPage(totalPage);
		jspData.setStartPage(startPage);
		jspData.setEndPage(endPage);
		jspData.setPage(page);
		jspData.setPagesPerGroup(pagesPerGroup);
		jspData.setStartRow(startRow);
		jspData.setEndRow(endRow);
		
		@SuppressWarnings("unchecked")
		List<Board> list = (List<Board>)boardDao.list(jspData);
		
		BoardModel model = new BoardModel();
		model.setList(list);
		model.setJspDate(jspData);
		return model;
		
//		return boardDao.list();
	}

}
