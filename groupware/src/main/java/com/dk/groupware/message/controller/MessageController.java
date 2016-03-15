package com.dk.groupware.message.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dk.groupware.common.DuplicateFile;
import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.common.model.PageModel;
import com.dk.groupware.member.model.Member;
import com.dk.groupware.message.model.Message;
import com.dk.groupware.message.model.MessageModel;

@Controller
public class MessageController {
	private ServiceInterface messageListService, 
//			messageSearchListService, 
			messageViewService, messageWriteProcessService,
			messageDeleteProcessService, messageSendListService, messageSendViewService,
			messageSendDeleteProcessService, messageCountService;

	// setter
	public void setMessageListService(ServiceInterface messageListService) {
		this.messageListService = messageListService;
	}

//	public void setMessageSearchListService(ServiceInterface messageSearchListService) {
//		this.messageSearchListService = messageSearchListService;
//	}

	public void setMessageViewService(ServiceInterface messageViewService) {
		this.messageViewService = messageViewService;
	}

	public void setMessageWriteProcessService(ServiceInterface messageWriteProcessService) {
		this.messageWriteProcessService = messageWriteProcessService;
	}

	public void setMessageDeleteProcessService(ServiceInterface messageDeleteProcessService) {
		this.messageDeleteProcessService = messageDeleteProcessService;
	}

	public void setMessageSendListService(ServiceInterface messageSendListService) {
		this.messageSendListService = messageSendListService;
	}

	public void setMessageSendViewService(ServiceInterface messageSendViewService) {
		this.messageSendViewService = messageSendViewService;
	}

	public void setMessageSendDeleteProcessService(ServiceInterface messageSendDeleteProcessService) {
		this.messageSendDeleteProcessService = messageSendDeleteProcessService;
	}

	public void setMessageCountService(ServiceInterface messageCountService) {
		this.messageCountService = messageCountService;
	}

	// 페이지 처리 쪽지 리스트
	@RequestMapping(value="/message/list.do", method=RequestMethod.GET)
	public String list(@RequestParam(value = "page", required = false, 
	defaultValue = "1") int page, HttpSession session, Model model)
			throws Exception {
		System.out.println("MessageController.list(page)");
		// 값 확인
		Member member = (Member) session.getAttribute("login");
		
		PageModel pageModel = new PageModel();
		pageModel.setId(member.getId());
		pageModel.setPage(page);
		
		MessageModel messageModel = (MessageModel) messageListService.service(pageModel);
		
		model.addAttribute("list", messageModel.getList());
		model.addAttribute("jspData", messageModel.getJspData());
		return "message/list";
	}
	
	// 받은 쪽지 리스트 검색
//	@RequestMapping(value="/message/list.do", method=RequestMethod.POST)
//	public String searchList(@RequestParam(value = "page", required = false, 
//	defaultValue = "1") int page, 
//			String option, String searchStr, HttpSession session, Model model)
//			throws Exception {
//		System.out.println("MessageController.searchList(page)");
//		// 값 확인
//		Member member = (Member) session.getAttribute("login");
//		model.addAttribute("list", messageListService.service(member.getId()));
//		Search search = new Search(option, searchStr);
//		model.addAttribute("list", messageSearchListService.service(search));
//		return "message/list"; 
//	}

	// 쪽지 보기 : view
	@RequestMapping("/message/view.do")
	public String view(@RequestParam(value="page", required=false, defaultValue="1") int page, int no, Model model) throws Exception {
		System.out.println("MessageController.view(no)");
		Message message =  (Message) messageViewService.service(no);
		if(message == null)
			return "message/error";
		model.addAttribute("message",message);
		model.addAttribute("page", page);
		return "message/view";
	}

	// 쪽지 보내기 : write
	@RequestMapping(value = "/message/write.do", method = RequestMethod.GET)
	public String write() {
		System.out.println("MessageController.write():GET");
		return "message/write";
	}

	// 쪽지 보내기 처리
	@RequestMapping(value = "/message/write.do", method = RequestMethod.POST)
	// 파라미터 값에 어떤 파일을 올릴 것인지 작성한다.
	// MultipartFile을 파라미터 값으로 넣는다면 모델에서 굳이 필요치 않다.
	// 받은 파일을 다시 jsp로 넘기기 위해 Model이 필요하다.
	public String write(MultipartFile file1, Message message, Model model, HttpServletRequest request)
			throws IOException {
		System.out.println("MessageController.write(message):POST");
		String realPath = request.getServletContext().getRealPath("/upload/message");
		// 비어있지 않으면
		if (!file1.isEmpty()) {
			// 다운로드 시 사용
//			String fileName = file1.getOriginalFilename();
			// 중복되지 않는 파일을 받아올 수 있다.
			File file = DuplicateFile.getFile(realPath, file1);
			file1.transferTo(file);
			// 이름만 지정해두면 DB에 저장할 수 있다.
			message.setFileName(file.getName());
		}
		// 출력해보자
		System.out.println(realPath);
		messageWriteProcessService.service(message);
		return "redirect:list.do";
	}

	// 쪽지 삭제 : delete
	@RequestMapping("/message/delete.do")
	public String delete(int [] nos, 
			@RequestParam(value="page", defaultValue="1", required=false) 
		int page, Model model) throws Exception {
		System.out.println("MessageController.delete(no)");
		for(int s : nos)
			System.out.println(s);
		if((Integer) messageDeleteProcessService.service(nos) == 0){
			return "redirect:error.do";
		}
		model.addAttribute("page", page);
		return "redirect:list.do";
	}

	// send

	// 보낸 쪽지 리스트 : list
	@RequestMapping("/message/send/list.do")
	public String sendList(@RequestParam(value = "page", required = false, defaultValue = "1") 
		int page, HttpSession session, Model model) throws Exception {
		System.out.println("MessageController.sendList(page)");
		// ** 어트리뷰트에 담을 때 sendList 말고 list로 **
		Member member = (Member) session.getAttribute("login");
		
		PageModel pageModel = new PageModel();
		pageModel.setId(member.getId());
		pageModel.setPage(page);
		
		MessageModel messageModel = (MessageModel) messageSendListService.service(pageModel);
		
		model.addAttribute("list", messageModel.getList());
		model.addAttribute("jspData", messageModel.getJspData());
		return "message/send/list";
	}

	
	// 보낸 쪽지 보기 : view
	@RequestMapping("/message/send/view.do")
	public String sendView(int no, Model model, 
		@RequestParam(value="page", required=false, defaultValue="1") 
		int page) throws Exception {
		System.out.println("MessageControeller.sendView(no)");
		Message message = (Message) messageSendViewService.service(no);
		if(message == null){
			// *** main.xml viewResolver 에서 prefix 지정한 경로 ***
			return "message/error";
		}
		model.addAttribute("message", message);
		model.addAttribute("page", page);
		// ** 리턴값 sendView 아니고 send/view **
		return "message/send/view";
	}
	// 보낸 쪽지 삭제 : delete
	@RequestMapping("/message/send/delete.do")
	public String sendDelete(int [] nos, 
		@RequestParam(value="page", required=false, defaultValue="1")
		int page, Model model) throws Exception {
		System.out.println("MessageController.sendDelete(no)");
		for(int s : nos)
			System.out.println(s);
		if((Integer)messageSendDeleteProcessService.service(nos) == 0){
			// *** 경로 다르므로, 상위부터  *** 
			return "message/error.do";
		}
		model.addAttribute("page", page);
		return "redirect:list.do";
	}
	
	// 새 쪽지 표시 -  안읽은 쪽지 카운트
	@RequestMapping("/message/count.do")
	public void count(HttpSession session, HttpServletResponse response, Model model) throws Exception {
		System.out.println("MessageController.count()");
		Member member = (Member) session.getAttribute("login");
		PrintWriter out = response.getWriter();
		
		int count = (Integer) messageCountService.service(member.getId());
		
		if(count != 0)
			out.print("(" + count + ")");
	}

}
