package com.dk.groupware.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.main.model.Main;
import com.dk.groupware.member.model.Member;

@Controller
public class MainController {
	private ServiceInterface mainService;

	public void setMainService(ServiceInterface mainService) {
		this.mainService = mainService;
	}

	@RequestMapping("/main.do")
	public String list(HttpSession session, Model model) throws Exception {
		System.out.println("MainController.list()");
		Member member = (Member) session.getAttribute("login");
		
		Main main = new Main();
		main.setId(member.getId());
		main.setModel(model);
		
		mainService.service(main);
		
		return "main";
	}
	
	@RequestMapping("/error/error.do")
	public String getError(int code) throws Exception {
		System.out.println("MainController.getError()");
		
		switch(code) {
		case 400:
			return "redirect:/error/error400.do";
		case 404:
			return "redirect:/error/error404.do";
		case 500:
			return "redirect:/error/error500.do";
		}
		
		return "redirect:main.do";
	}

	@RequestMapping("/error/error400.do")
	public String error400() throws Exception {
		System.out.println("MainController.error400()");
		return "/error/error400";
	}
	
	@RequestMapping("/error/error404.do")
	public String error404() throws Exception {
		System.out.println("MainController.error404()");
		return "/error/error404";
	}
	
	@RequestMapping("/error/error500.do")
	public String error500() throws Exception {
		System.out.println("MainController.error500()");
		return "/error/error500";
	}
}
