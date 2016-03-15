package com.dk.groupware.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.member.model.Member;
import com.dk.groupware.member.model.MemberModel;
import com.dk.groupware.member.model.Search;

@Controller
public class MemberController {

	// xml에서 property를 줬으니까 private
	private ServiceInterface memberListService, memberSearchListService, memberViewService, memberUpdateService, memberUpdateProcessService,
			memberWriteProcessService, memberDeleteProcessService, myPageViewService, loginProcessService,
			myPageUpdateService, myPageUpdateProcessService, myPwChangeProcessService, resetPwProcessService, selectSignerService;

	// setters
	
	public void setMemberListService(ServiceInterface memberListService) {
		this.memberListService = memberListService;
	}

//	public void setCurrentPwCheckService(ServiceInterface currentPwCheckService) {
//		this.currentPwCheckService=currentPwCheckService;
//	}

	public void setMemberSearchListService(ServiceInterface memberSearchListService) {
		this.memberSearchListService = memberSearchListService;
	}

	public void setMyPwChangeProcessService(ServiceInterface myPwChangeProcessService) {
		this.myPwChangeProcessService = myPwChangeProcessService;
	}

	public void setMemberViewService(ServiceInterface memberViewService) {
		this.memberViewService = memberViewService;
	}

	public void setMemberUpdateService(ServiceInterface memberUpdateService) {
		this.memberUpdateService = memberUpdateService;
	}

	public void setMemberUpdateProcessService(ServiceInterface memberUpdateProcessService) {
		this.memberUpdateProcessService = memberUpdateProcessService;
	}

	public void setMemberWriteProcessService(ServiceInterface memberWriteProcessService) {
		this.memberWriteProcessService = memberWriteProcessService;
	}

	public void setMemberDeleteProcessService(ServiceInterface memberDeleteProcessService) {
		this.memberDeleteProcessService = memberDeleteProcessService;
	}

	public void setMyPageViewService(ServiceInterface myPageViewService) {
		this.myPageViewService = myPageViewService;
	}

	public void setLoginProcessService(ServiceInterface loginProcessService) {
		this.loginProcessService = loginProcessService;
	}

	public void setMyPageUpdateService(ServiceInterface myPageUpdateService) {
		this.myPageUpdateService = myPageUpdateService;
	}

	public void setMyPageUpdateProcessService(ServiceInterface myPageUpdateProcessService) {
		this.myPageUpdateProcessService = myPageUpdateProcessService;
	}

	public void setResetPwProcessService(ServiceInterface resetPwProcessService) {
		this.resetPwProcessService = resetPwProcessService;
	}
	
	public void setSelectSignerService(ServiceInterface selectSignerService) {
		this.selectSignerService = selectSignerService;
	}

	// 사원 리스트
	@RequestMapping("/member/list.do")
	public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model)
			throws Exception {
		System.out.println("MemberController.list()");
		MemberModel memberModel = (MemberModel) memberListService.service(page);
		model.addAttribute("list",memberModel.getList());
		model.addAttribute("jspData",memberModel.getJspData());
//		model.addAttribute("list", memberListService.service(page));
		return "member/list";
	}

	// 사원 정보 보기
	@RequestMapping("member/view.do")
	public String view(int id, Model model) throws Exception {
		System.out.println("MemberController.view(id)");
		model.addAttribute("member", memberViewService.service(id));
		return "member/view";
	}
	
	// 사원 ID 찾기 (사원 리스트 검색)
	@RequestMapping(value="/member/list.do", method=RequestMethod.POST)
	public String searchList(@RequestParam(value="page", required=false, defaultValue="1")int page, 
			String option, String searchStr, Model model) throws Exception{
		System.out.println("MemberController.searchList()");
		Search search = new Search(option, searchStr);
		model.addAttribute("list", memberSearchListService.service(search));
		return "member/list";
	}

	// 사원 정보 수정 폼
	@RequestMapping(value = "/member/update.do", method = RequestMethod.GET)
	public String update(@RequestParam(value = "id", required = false) int id, Model model) throws Exception {
		System.out.println("MemberController.update():get");
		model.addAttribute("member", memberUpdateService.service(id));
		return "member/update";
	}

	// 사원 정보 수정 처리
	@RequestMapping(value = "/member/update.do", method = RequestMethod.POST)
	public String update(Member member) throws Exception {
		System.out.println("MemberController.update():post");
		memberUpdateProcessService.service(member);
		return "redirect:view.do?id=" + member.getId();
	}
	
	// 사원 비밀번호 리셋(수정) 폼: GET
	@RequestMapping(value="/member/pwreset.do", method=RequestMethod.GET)
	public String pwreset(int id, Model model) throws Exception{
		System.out.println("MemeberController.pwreset():get");
		model.addAttribute("member", myPageViewService.service(id));
		return "member/pwreset";
	}
	
	// 사원 비밀번호 리셋 처리: POST
	@RequestMapping(value="/member/pwreset.do", method=RequestMethod.POST)
	public String pwreset(Member member)throws Exception{
		System.out.println("MemberController.pwreset():post");
		resetPwProcessService.service(member);
		return "redirect:view.do?id="+member.getId();
	}


	// 사원 등록 폼: get
	@RequestMapping(value = "/member/write.do", method = RequestMethod.GET)
	public String write() {
		System.out.println("MemberController.write():get");
		return "member/write";
	}

	// 사원 등록 처리: post
	@RequestMapping(value = "/member/write.do", method = RequestMethod.POST)
	public String write(Member member) throws Exception {
		System.out.println("MemberController.write():post");
		memberWriteProcessService.service(member);
		return "redirect:list.do";
	}

	// 사원 퇴사 처리(탈퇴)
	@RequestMapping("/member/delete.do")
	public String delete(@RequestParam(value = "id", required = false) int id) throws Exception {
		System.out.println("MemberController.delete()");
		memberDeleteProcessService.service(id);
//		return "member/list";
		// 탈퇴 처리 후 리스트로 바로 가도록.
		return "redirect:list.do";
	}

	// 내정보 보기
	@RequestMapping("/mypage/view.do")
	public String mview(HttpSession session, Model model) throws Exception{
		System.out.println(session);
		System.out.println("MemberController.mview()");
		int id=((Member)session.getAttribute("login")).getId();
		System.out.println(id);
		model.addAttribute("member", myPageViewService.service(id));
		return "mypage/view";
	}
	
	// 내정보 수정 폼
	@RequestMapping(value="/mypage/update.do", method=RequestMethod.GET)
	public String mupdate(HttpSession session, Model model) throws Exception{
		System.out.println(session);
		System.out.println("MemberController.mupdate():get");
		int id=((Member)session.getAttribute("login")).getId();
		System.out.println(id);
		model.addAttribute("member", myPageUpdateService.service(id));
		return "mypage/update";
	}
	
	// 내정보 수정 처리
	@RequestMapping(value="/mypage/update.do", method=RequestMethod.POST)
	public String mupdate(Member member)throws Exception{
		System.out.println("MemberController.mupdate():post");
		System.out.println(member);
		myPageUpdateProcessService.service(member);
		
		return "redirect:view.do?id="+member.getId();
	}
	
	// 내 비밀번호 수정 폼: GET
	@RequestMapping(value="/mypage/pwupdate.do", method=RequestMethod.GET)
	public String pwUpdate() throws Exception{
		System.out.println("MemberController.pwUpdate():get");
		return "mypage/pwupdate";
	}

	// 내 비밀번호 수정 처리: POST
	@RequestMapping(value="/mypage/pwupdate.do", method=RequestMethod.POST)
	public String pwUpdate(Member member)throws Exception{
		System.out.println("MemberController.pwUpdate():post");
		myPwChangeProcessService.service(member);
		return "redirect:view.do?id="+member.getId();
	}
	
	// 기존 비밀번호 일치 체크 (AJAX)
//	@RequestMapping("/mypage/pwupdate.do")
//	public void currentPwCheck(String pw, HttpServletResponse response) throws Exception{
//		System.out.println("MemberController.currentPwCheck()");
//		System.out.println(pw);
//		String result="<span style='color:blue'>확인 성공!</span>";
//		if(myPwChangeProcessService.service(obj) != )
//			result="<span style='color:red'>확인 실패</span>";
//		
//		// 한글 처리
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out=response.getWriter();
//		out.println(result);
//	
//	}
//		

	// 로그인 폼: get
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String login() {
		System.out.println("MemberController.login():get");
		return "index";
	}

	// 로그인 처리: post
	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public String login(HttpSession session, Member member) throws Exception {
		System.out.println("MemberController.login():post");
		member = (Member) loginProcessService.service(member);
		if(member != null) {
			session.setAttribute("login", member);
			return "redirect:main.do";
		}
		else
			return "member/loginFailed";
	}

	// 로그아웃 처리
	@RequestMapping("/logout.do")
	public String logout(HttpSession session, Member member) throws Exception {
		session.setAttribute("login", null);
		return "redirect:index.do";
	}
	
	// 결재자 선택 화면용 리스트 출력
	@RequestMapping("/member/selectSigner.do")
	public String selectSigner(HttpSession session, Model model) throws Exception {
		System.out.println("MemberController.selectSigner()");
		Member member = (Member) session.getAttribute("login");
		model.addAttribute("list", selectSignerService.service(member.getPno()));
		return "member/selectSigner";
	}

}
