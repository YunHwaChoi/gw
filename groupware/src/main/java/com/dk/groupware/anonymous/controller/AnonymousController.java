package com.dk.groupware.anonymous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dk.groupware.anonymous.model.Anonymous;
import com.dk.groupware.anonymous.model.AnonymousModel;
import com.dk.groupware.anonymous.model.AnonymousReply;
import com.dk.groupware.anonymous.model.AnonymousReplyModel;
import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.common.model.PageModel;

@Controller
public class AnonymousController {
	private ServiceInterface anonymousListService;
	private ServiceInterface anonymousViewService;
	private ServiceInterface anonymousWriteProcessService;
	private ServiceInterface anonymousUpdateService;
	private ServiceInterface anonymousUpdateProcessService;
	private ServiceInterface anonymousDeleteProcessService;

	private ServiceInterface anonymousReplyListService;
	private ServiceInterface anonymousReplyWriteProcessService;
	private ServiceInterface anonymousReplyUpdateProcessService;
	private ServiceInterface anonymousReplyDeleteProcessService;

	public void setAnonymousListService(ServiceInterface anonymousListService) {
		this.anonymousListService = anonymousListService;
	}

	public void setAnonymousViewService(ServiceInterface anonymousViewService) {
		this.anonymousViewService = anonymousViewService;
	}

	public void setAnonymousWriteProcessService(ServiceInterface anonymousWriteProcessService) {
		this.anonymousWriteProcessService = anonymousWriteProcessService;
	}

	public void setAnonymousUpdateService(ServiceInterface anonymousUpdateService) {
		this.anonymousUpdateService = anonymousUpdateService;
	}

	public void setAnonymousUpdateProcessService(ServiceInterface anonymousUpdateProcessService) {
		this.anonymousUpdateProcessService = anonymousUpdateProcessService;
	}

	public void setAnonymousDeleteProcessService(ServiceInterface anonymousDeleteProcessService) {
		this.anonymousDeleteProcessService = anonymousDeleteProcessService;
	}

	public void setAnonymousReplyListService(ServiceInterface anonymousReplyListService) {
		this.anonymousReplyListService = anonymousReplyListService;
	}
	
	public void setAnonymousReplyWriteProcessService(ServiceInterface anonymousReplyWriteProcessService) {
		this.anonymousReplyWriteProcessService = anonymousReplyWriteProcessService;
	}
	
	public void setAnonymousReplyUpdateProcessService(ServiceInterface anonymousReplyUpdateProcessService) {
		this.anonymousReplyUpdateProcessService = anonymousReplyUpdateProcessService;
	}

	public void setAnonymousReplyDeleteProcessService(ServiceInterface anonymousReplyDeleteProcessService) {
		this.anonymousReplyDeleteProcessService = anonymousReplyDeleteProcessService;
	}

	@RequestMapping("/anonymous/list.do")
	public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model)
			throws Exception {
		System.out.println("AnonymousController.list()");
		AnonymousModel anonymousModel = (AnonymousModel) anonymousListService.service(page);
		model.addAttribute("list", anonymousModel.getList());
		model.addAttribute("jspData", anonymousModel.getJspData());
		return "anonymous/list";
	}

	@RequestMapping("/anonymous/view.do")
	public String view(@RequestParam(value = "page", required = false, defaultValue = "1") int page, int no, Model model) throws Exception {
		System.out.println("AnonymousController.view()");
		
		PageModel pageModel = new PageModel();
		pageModel.setId(no);
		pageModel.setPage(page);
		
		model.addAttribute("anonymous", anonymousViewService.service(no));
		
		AnonymousReplyModel anonymousReplyModel = (AnonymousReplyModel) anonymousReplyListService.service(pageModel);
		model.addAttribute("reply", anonymousReplyModel.getList());
		model.addAttribute("jspData", anonymousReplyModel.getJspData());
		
		model.addAttribute("page", page);
		
		return "anonymous/view";
	}

	@RequestMapping(value = "/anonymous/write.do", method = RequestMethod.GET)
	public String write() throws Exception {
		System.out.println("AnonymousController.write():GET");
		return "anonymous/write";
	}

	@RequestMapping(value = "/anonymous/write.do", method = RequestMethod.POST)
	public String write(Anonymous anonymous) throws Exception {
		System.out.println("AnonymousController.write():POST");
		anonymousWriteProcessService.service(anonymous);
		return "redirect:list.do";
	}

	@RequestMapping(value = "/anonymous/update.do", method = RequestMethod.GET)
	public String update(@RequestParam(value = "page", required = false, defaultValue = "1") int page, int no, Model model) throws Exception {
		System.out.println("AnonymousController.update():GET");
		model.addAttribute("anonymous", anonymousUpdateService.service(no));
		model.addAttribute("page", page);
		return "anonymous/update";
	}

	@RequestMapping(value = "/anonymous/update.do", method = RequestMethod.POST)
	public String update(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Anonymous anonymous, Model model) throws Exception {
		System.out.println("AnonymousController.update():POST");
		anonymousUpdateProcessService.service(anonymous);
		return "redirect:view.do?no=" + anonymous.getNo() + "&page=" + page;
	}

	@RequestMapping("/anonymous/delete.do")
	public String delete(@RequestParam(value = "page", required = false, defaultValue = "1") int page, int no) throws Exception {
		System.out.println("AnonymousController.delete()");
		anonymousDeleteProcessService.service(no);
		return "redirect:list.do?page=" + page;
	}

	@RequestMapping(value = "/anonymous/reply/write.do", method = RequestMethod.POST)
	public String replyWrite(AnonymousReply anonymousReply) throws Exception {
		System.out.println("AnonymousController.replyWrite()");
		anonymousReplyWriteProcessService.service(anonymousReply);
		return "redirect:../view.do?no=" + anonymousReply.getNo();
	}
	
	@RequestMapping(value = "/anonymous/reply/update.do", method = RequestMethod.POST)
	public String replyUpdate(AnonymousReply anonymousReply) throws Exception {
		System.out.println("AnonymousController.replyUpdate()");
		anonymousReplyUpdateProcessService.service(anonymousReply);
		return "redirect:../view.do?no=" + anonymousReply.getNo();
	}
	
	@RequestMapping("/anonymous/reply/delete.do")
	public String replyDelete(AnonymousReply anonymousReply) throws Exception {
		System.out.println("AnonymousController.replyDelete()");
		System.out.println(anonymousReply);
		anonymousReplyDeleteProcessService.service(anonymousReply.getRno());
		return "redirect:../view.do?no=" + anonymousReply.getNo();
	}
}
