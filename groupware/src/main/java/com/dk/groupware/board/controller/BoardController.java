package com.dk.groupware.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dk.groupware.board.model.Board;
import com.dk.groupware.board.model.BoardModel;
import com.dk.groupware.board.model.Search;
import com.dk.groupware.common.ServiceInterface;

@Controller
public class BoardController {
	
	private ServiceInterface boardListService, boardSearchListService,
	boardViewService, boardWriteProcessService, boardUpdateService,
	boardUpdateProcessService, boardDeleteProcessService;
	
	public void setBoardListService(ServiceInterface boardListService) {
		this.boardListService = boardListService;
	}

	public void setBoardSearchListService(ServiceInterface boardSearchListService) {
		this.boardSearchListService = boardSearchListService;
	}

	public void setBoardViewService(ServiceInterface boardViewService) {
		this.boardViewService = boardViewService;
	}

	public void setBoardWriteProcessService(ServiceInterface boardWriteProcessService) {
		this.boardWriteProcessService = boardWriteProcessService;
	}

	public void setBoardUpdateService(ServiceInterface boardUpdateService) {
		this.boardUpdateService = boardUpdateService;
	}

	public void setBoardUpdateProcessService(ServiceInterface boardUpdateProcessService) {
		this.boardUpdateProcessService = boardUpdateProcessService;
	}

	public void setBoardDeleteProcessService(ServiceInterface boardDeleteProcessService) {
		this.boardDeleteProcessService = boardDeleteProcessService;
	}

	// 글리스트
	@RequestMapping(value="/board/list.do", method=RequestMethod.GET)
	public String list
	(@RequestParam(value="page",required=false, defaultValue="1") int page, Model model)
	throws Exception{
		System.out.println("BoardController.list()");
		BoardModel boardModel = (BoardModel) boardListService.service(page);
		model.addAttribute("list", boardModel.getList());
		model.addAttribute("jspData", boardModel.getJspDate());
		return "board/list";
	}
	
	// 글검색
	@RequestMapping(value="/board/list.do", method=RequestMethod.POST)
	public String searchList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, 
			String option, String searchStr, Model model)throws Exception {
		System.out.println("BoardController.searchList()");
		Search search = new Search(option, searchStr);
		model.addAttribute("list", boardSearchListService.service(search));
		return "board/list";
	}
	
	// 글보기
	@RequestMapping("/board/view.do")
	public String view(int no, Model model) throws Exception{
		System.out.println("BoardController.view()");
		model.addAttribute("board",	boardViewService.service(no));
		return "board/view";
	}

	// 글쓰기폼 - get
	@RequestMapping(value="/board/write.do", method=RequestMethod.GET)
	public String write(){
		System.out.println("BoardController.write():get");
		return "board/write";
	}

	// 글쓰기처리 - post
	@RequestMapping(value="/board/write.do", method=RequestMethod.POST)
	public String write(Board board) throws Exception{
		System.out.println("BoardController.write():post");
		boardWriteProcessService.service(board);
		return "redirect:list.do";
	}

	// 글수정 폼
	@RequestMapping(value="/board/update.do", method=RequestMethod.GET)
	public String update
	(@RequestParam(value="no",required=false) int no, Model model) throws Exception{
		System.out.println("BoardController.update():get");
		model.addAttribute("board",boardUpdateService.service(no));
		return "board/update";
	}

	// 글수정 처리
	@RequestMapping(value="/board/update.do", method=RequestMethod.POST)
	public String update(Board board) throws Exception{
		System.out.println("BoardController.update():post");
		boardUpdateProcessService.service(board);
		return "redirect:view.do?no="+board.getNo();
	}

	// 글삭제 처리
	@RequestMapping("/board/delete.do")
	public String delete(int no) throws Exception{
		System.out.println("BoardController.delete()");
		boardDeleteProcessService.service(no);
		return "redirect:list.do";
	}
}