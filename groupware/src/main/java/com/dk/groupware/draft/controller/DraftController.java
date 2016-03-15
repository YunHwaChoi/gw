package com.dk.groupware.draft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.common.model.PageModel;
import com.dk.groupware.draft.model.Draft;
import com.dk.groupware.draft.model.DraftModel;
import com.dk.groupware.member.model.Member;

@Controller
public class DraftController {
	private ServiceInterface draftListService;
	private ServiceInterface draftWriteProcessService;

	private ServiceInterface waitListService;
	private ServiceInterface waitViewService;
	private ServiceInterface waitSignProcessService;
	private ServiceInterface waitUpdateService;
	private ServiceInterface waitUpdateProcessService;
	private ServiceInterface waitDeleteProcessService;

	private ServiceInterface proceedListService;
	private ServiceInterface proceedViewService;
	private ServiceInterface proceedSignProcessService;

	private ServiceInterface doneListService;
	private ServiceInterface doneViewService;

	public void setDraftListService(ServiceInterface draftListService) {
		this.draftListService = draftListService;
	}

	public void setDraftWriteProcessService(ServiceInterface draftWriteProcessService) {
		this.draftWriteProcessService = draftWriteProcessService;
	}

	public void setWaitListService(ServiceInterface waitListService) {
		this.waitListService = waitListService;
	}

	public void setWaitViewService(ServiceInterface waitViewService) {
		this.waitViewService = waitViewService;
	}
	
	public void setWaitSignProcessService(ServiceInterface waitSignProcessService) {
		this.waitSignProcessService = waitSignProcessService;
	}

	public void setWaitUpdateService(ServiceInterface waitUpdateService) {
		this.waitUpdateService = waitUpdateService;
	}

	public void setWaitUpdateProcessService(ServiceInterface waitUpdateProcessService) {
		this.waitUpdateProcessService = waitUpdateProcessService;
	}

	public void setWaitDeleteProcessService(ServiceInterface waitDeleteProcessService) {
		this.waitDeleteProcessService = waitDeleteProcessService;
	}

	public void setProceedListService(ServiceInterface proceedListService) {
		this.proceedListService = proceedListService;
	}

	public void setProceedViewService(ServiceInterface proceedViewService) {
		this.proceedViewService = proceedViewService;
	}

	public void setProceedSignProcessService(ServiceInterface proceedSignProcessService) {
		this.proceedSignProcessService = proceedSignProcessService;
	}

	public void setDoneListService(ServiceInterface doneListService) {
		this.doneListService = doneListService;
	}

	public void setDoneViewService(ServiceInterface doneViewService) {
		this.doneViewService = doneViewService;
	}

	@RequestMapping("/draft/list.do")
	public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int page, HttpSession session, Model model)
			throws Exception {
		System.out.println("DraftController.list()");
		
		Member member = (Member) session.getAttribute("login");
		
		PageModel pageModel = new PageModel();
		pageModel.setId(member.getId());
		pageModel.setPage(page);
		
		DraftModel draftModel = (DraftModel) draftListService.service(pageModel);
		model.addAttribute("list", draftModel.getList());
		model.addAttribute("jspData", draftModel.getJspData());
		
		return "draft/list";
	}
	
	@RequestMapping(value = "/draft/write.do", method = RequestMethod.GET)
	public String write() throws Exception {
		System.out.println("DraftController.write():GET");
		return "draft/write";
	}

	@RequestMapping(value = "/draft/write.do", method = RequestMethod.POST)
	public String write(Draft draft) throws Exception {
		System.out.println("DraftController.write():POST");
		
		System.out.println(draft);
		
		draftWriteProcessService.service(draft);
		return "redirect:list.do";
	}
	
	@RequestMapping("/draft/wait/list.do")
	public String waitList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, HttpSession session, Model model)
			throws Exception {
		System.out.println("DraftController.waitList()");
		
		Member member = (Member) session.getAttribute("login");
		
		PageModel pageModel = new PageModel();
		pageModel.setId(member.getId());
		pageModel.setPage(page);
		
		DraftModel draftModel = (DraftModel) waitListService.service(pageModel);
		model.addAttribute("list", draftModel.getList());
		model.addAttribute("jspData", draftModel.getJspData());
		
		return "draft/wait/list";
	}
	
	@RequestMapping("/draft/wait/view.do")
	public String waitView(@RequestParam(value = "page", required = false, defaultValue = "1") int page, int no, Model model) throws Exception {
		System.out.println("DraftController.waitView()");
		model.addAttribute("draft", waitViewService.service(no));
		model.addAttribute("page", page);
		return "draft/wait/view";
	}
	
	@RequestMapping("/draft/wait/sign.do")
	public String waitSign(@RequestParam(value = "page", required = false, defaultValue = "1") int page, int no, Model model) throws Exception {
		System.out.println("DraftController.waitSign()");
		waitSignProcessService.service(no);
		return "redirect:/draft/proceed/view.do?no=" + no + "&page=" + page;
	}
	
	@RequestMapping(value = "/draft/wait/update.do", method = RequestMethod.GET)
	public String waitUpdate(@RequestParam(value = "page", required = false, defaultValue = "1") int page, int no, Model model) throws Exception {
		System.out.println("DraftController.waitUpdate():GET");
		model.addAttribute("draft", waitUpdateService.service(no));
		model.addAttribute("page", page);
		return "draft/wait/update";
	}

	@RequestMapping(value = "/draft/wait/update.do", method = RequestMethod.POST)
	public String waitUpdate(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Draft draft) throws Exception {
		System.out.println("DraftController.waitUpdate():POST");
		waitUpdateProcessService.service(draft);
		return "redirect:view.do?no=" + draft.getNo() + "&page=" + page;
	}

	@RequestMapping("/draft/wait/delete.do")
	public String waitDelete(@RequestParam(value = "page", required = false, defaultValue = "1") int page, int no) throws Exception {
		System.out.println("DraftController.waitDelete()");
		waitDeleteProcessService.service(no);
		return "redirect:list.do?page=" + page;
	}
	
	@RequestMapping("/draft/proceed/list.do")
	public String proceedList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, HttpSession session, Model model)
			throws Exception {
		System.out.println("DraftController.proceedList()");
		
		Member member = (Member) session.getAttribute("login");
		
		PageModel pageModel = new PageModel();
		pageModel.setId(member.getId());
		pageModel.setPage(page);
		
		DraftModel draftModel = (DraftModel) proceedListService.service(pageModel);
		model.addAttribute("list", draftModel.getList());
		model.addAttribute("jspData", draftModel.getJspData());
		
		return "draft/proceed/list";
	}
	
	@RequestMapping("/draft/proceed/view.do")
	public String proceedView(int no, Model model) throws Exception {
		System.out.println("DraftController.proceedView()");
		model.addAttribute("draft", proceedViewService.service(no));
		return "draft/proceed/view";
	}
	
	@RequestMapping("/draft/proceed/sign.do")
	public String proceedSign(Draft draft) throws Exception {
		System.out.println("DraftController.proceedSign()");
		proceedSignProcessService.service(draft);
		return "redirect:view.do?no=" + draft.getNo();
	}
	
	@RequestMapping("/draft/done/list.do")
	public String doneList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, HttpSession session, Model model)
			throws Exception {
		System.out.println("DraftController.doneList()");
		
		Member member = (Member) session.getAttribute("login");
		
		PageModel pageModel = new PageModel();
		pageModel.setId(member.getId());
		pageModel.setPage(page);
		
		DraftModel draftModel = (DraftModel) doneListService.service(pageModel);
		model.addAttribute("list", draftModel.getList());
		model.addAttribute("jspData", draftModel.getJspData());
		
		return "draft/done/list";
	}
	
	@RequestMapping("/draft/done/view.do")
	public String doneView(int no, Model model) throws Exception {
		System.out.println("DraftController.doneView()");
		
		model.addAttribute("draft", doneViewService.service(no));
		
		return "draft/done/view";
	}

	@RequestMapping("/viewContent.do")
	public String waitViewContent(int no, Model model) throws Exception {
		System.out.println("DraftController.waitViewContent()");
		model.addAttribute("draft", waitViewService.service(no));
		return "draft/done/viewContent";
	}
}

