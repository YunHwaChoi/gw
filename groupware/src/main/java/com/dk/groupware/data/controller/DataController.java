
package com.dk.groupware.data.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dk.groupware.common.DuplicateFile;
import com.dk.groupware.common.ServiceInterface;
import com.dk.groupware.data.model.Data;
import com.dk.groupware.data.model.DataModel;
import com.dk.groupware.data.model.Search;

@Controller
public class DataController {

	// property니까 private로.
	private ServiceInterface dataListService, dataSearchListService, dataViewService, dataUpdateService, dataUpdateProcessService,
			dataWriteProcessService, dataDeleteProcessService;

	public void setDataListService(ServiceInterface dataListService) {
		this.dataListService = dataListService;
	}
	
	public void setDataSearchListService(ServiceInterface dataSearchListService) {
		this.dataSearchListService = dataSearchListService;
	}

	public void setDataViewService(ServiceInterface dataViewService) {
		this.dataViewService = dataViewService;
	}

	public void setDataUpdateService(ServiceInterface dataUpdateService) {
		this.dataUpdateService = dataUpdateService;
	}

	public void setDataUpdateProcessService(ServiceInterface dataUpdateProcessService) {
		this.dataUpdateProcessService = dataUpdateProcessService;
	}

	public void setDataWriteProcessService(ServiceInterface dataWriteProcessService) {
		this.dataWriteProcessService = dataWriteProcessService;
	}

	public void setDataDeleteProcessService(ServiceInterface dataDeleteProcessService) {
		this.dataDeleteProcessService = dataDeleteProcessService;
	}

	// 자료게시판 글리스트
	@RequestMapping(value="/data/list.do", method=RequestMethod.GET)
	public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model)
			throws Exception {
		System.out.println("DataController.list()");
		DataModel dataModel = (DataModel) dataListService.service(page);
		model.addAttribute("list", dataModel.getList());
		model.addAttribute("jspData", dataModel.getJspData());
		return "data/list";
	}
	
	// 자료게시판 글리스트 검색
	@RequestMapping(value="/data/list.do", method=RequestMethod.POST)
	public String searchList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, 
			String option, String searchStr, Model model)throws Exception {
		System.out.println("DataController.searchList()");
		Search search = new Search(option, searchStr);
		model.addAttribute("list", dataSearchListService.service(search));
		return "data/list";
	}

	// 자료게시판 글보기
	@RequestMapping("/data/view.do")
	public String view(int no, Model model) throws Exception {
		System.out.println("DataController.view(no)");
		model.addAttribute("data", dataViewService.service(no));
		return "data/view";
	}

	// 글쓰기폼 - get
	@RequestMapping(value = "/data/write.do", method = RequestMethod.GET)
	public String write() throws Exception {
		System.out.println("DataController.write():get");
		return "data/write";
	}

	// 글쓰기 처리 - POST
	// @RequestMapping(value = "/data/write.do", method = RequestMethod.POST)
	// public String write(Data data) throws Exception {
	// System.out.println("roomController.write-post()");
	// dataWriteProcessService.service(data);
	// return "redirect:list.do";
	// }

	// 파일 첨부가 된 글쓰기 완료 후의 처리 - post
	// @RequestMapping(value = "/data/write.do", method = RequestMethod.POST)
	// public String write(@RequestParam("file") MultipartFile multipartFile,
	// @RequestParam("title") Data data, Model model, HttpServletRequest
	// request) throws IOException{
	// System.out.println("DataController.write():post");
	// // 서버에 올라갈 실제 폴더 찾기
	// String realPath =
	// request.getServletContext().getRealPath("/upload/data");
	//
	// if(!multipartFile.isEmpty()){
	// String fileName=multipartFile.getOriginalFilename();
	// File file = new File(realPath, fileName);
	// multipartFile.transferTo(file);
	// model.addAttribute("imgFile", fileName);
	// //
	// dataWriteProcessService.service(data);
	// return "data/view";
	// }
	// System.out.println(realPath);
	// return "data/noUploaded";
	// }

	// 파일 첨부가된 게시판 글쓰기 완료 후 처리
	@RequestMapping(value = "/data/write.do", method = RequestMethod.POST)
	public String write(Data data, Model model, HttpServletRequest request) throws Exception {
		System.out.println("DataController.write():post");

		// 서버에 올라갈 실제 폴더 찾기
		String realPath = request.getServletContext().getRealPath("upload/data");
		System.out.println(realPath);
		if (!data.getFile().isEmpty()) {
			String fileName = data.getFile().getOriginalFilename();
			File file = DuplicateFile.getFile(realPath, data.getFile());
			data.getFile().transferTo(file); // 파일 이동
			data.setFileName(file.getName());
//			dataWriteProcessService.service(data);

//			return "redirect:list.do";
		} 
			dataWriteProcessService.service(data);
			return "redirect:list.do";
		
	}

	// 글수정 폼
	@RequestMapping(value = "/data/update.do", method = RequestMethod.GET)
	public String update(@RequestParam(value = "no", required = false) int no, Model model) throws Exception {
		System.out.println("DataController.update():get");
		model.addAttribute("data", dataUpdateService.service(no));
		return "data/update";
	}

	// 글수정 처리
//	@RequestMapping(value = "/data/update.do", method = RequestMethod.POST)
//	public String update(Data data) throws Exception {
//		System.out.println("BoardController.update():post");
//		dataUpdateProcessService.service(data);
//		return "redirect:view.do?no=" + data.getNo();
//	}
	@RequestMapping(value="/data/update.do", method=RequestMethod.POST)
	public String update(Data data, Model model, HttpServletRequest request)throws Exception{
		System.out.println("DataController.update():post");
		System.out.println(data);
		
			// 서버에 올라갈 실제 폴더를 찾아야 함
		String realPath = request.getServletContext().getRealPath("upload/data");
		System.out.println(realPath);
		if (!data.getFile().isEmpty()){
			String fileName = data.getFile().getOriginalFilename();
			File file=DuplicateFile.getFile(realPath, data.getFile());
			data.getFile().transferTo(file); // 파일 이동
			data.setFileName(file.getName());
//			dataUpdateProcessService.service(data);
			
//			return "redirect:view.do?no=" + data.getNo();
		} 
//		else {
			System.out.println(realPath);
			dataUpdateProcessService.service(data);
			return "redirect:view.do?no="+data.getNo();
		}
		
	

	// 글삭제 처리
	@RequestMapping("/data/delete.do")
	public String delete(int no) throws Exception {
		System.out.println("DataController.delete()");
		dataDeleteProcessService.service(no);
		return "redirect:list.do";
	}
}
