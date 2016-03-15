package com.dk.groupware.schedule.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.model.Member;
import com.dk.groupware.schedule.model.Schedule;

@Controller
public class ScheduleController {

	private ServiceInterface scheduleListService, scheduleViewService, scheduleWriteProcessService,
			scheduleUpdateService, scheduleUpdateProcessService, scheduleDeleteProcessService;

	public void setScheduleListService(ServiceInterface scheduleListService) {
		this.scheduleListService = scheduleListService;
	}

	public void setScheduleViewService(ServiceInterface scheduleViewService) {
		this.scheduleViewService = scheduleViewService;
	}

	public void setScheduleWriteProcessService(ServiceInterface scheduleWriteProcessService) {
		this.scheduleWriteProcessService = scheduleWriteProcessService;
	}

	public void setScheduleUpdateService(ServiceInterface scheduleUpdateService) {
		this.scheduleUpdateService = scheduleUpdateService;
	}

	public void setScheduleUpdateProcessService(ServiceInterface scheduleUpdateProcessService) {
		this.scheduleUpdateProcessService = scheduleUpdateProcessService;
	}

	public void setScheduleDeleteProcessService(ServiceInterface scheduleDeleteProcessService) {
		this.scheduleDeleteProcessService = scheduleDeleteProcessService;
	}

	// 글리스트
	@RequestMapping("/schedule/list.do")
	public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int page, HttpSession session, Model model)
			throws Exception {
		System.out.println("ScheduleController.list()");
//		model.addAttribute("list", scheduleListService.service(page));
		Member member = (Member) session.getAttribute("login");
		model.addAttribute("list", scheduleListService.service(member.getId()));
		return "schedule/list";
	}

	// 글보기
	@RequestMapping("/schedule/view.do")
	public String view(int no, Model model) throws Exception {
		System.out.println("ScheduleController.view()");
		model.addAttribute("schedule", scheduleViewService.service(no));
		return "schedule/view";
	}

	// 글쓰기폼 - get
	@RequestMapping(value = "/schedule/write.do", method = RequestMethod.GET)
	public String write() {
		System.out.println("ScheduleController.write():get");
		return "schedule/write";
	}

	// 글쓰기처리 - post
	@RequestMapping(value = "/schedule/write.do", method = RequestMethod.POST)
	public String write(Schedule schedule) throws Exception {
		System.out.println("ScheduleController.write():post");
		scheduleWriteProcessService.service(schedule);
		return "redirect:list.do";
	}

	// 글수정 폼
	@RequestMapping(value = "/schedule/update.do", method = RequestMethod.GET)
	public String update(Schedule schedule, Model model) throws Exception {
		System.out.println("ScheduleController.update():get");
		model.addAttribute("schedule", scheduleUpdateService.service(schedule));
		return "schedule/update";
	}

	// 글수정 처리
	@RequestMapping(value = "/schedule/update.do", method = RequestMethod.POST)
	public String update(Schedule schedule) throws Exception {
		System.out.println("ScheduleController.update():post");
		scheduleUpdateProcessService.service(schedule);
		return "redirect:view.do?no=" + schedule.getNo();
	}

	// 글삭제 처리
	@RequestMapping("/schedule/delete.do")
	public String delete(int no) throws Exception {
		System.out.println("ScheduleController.delete()");
		scheduleDeleteProcessService.service(no);
		return "redirect:list.do";
	}
}