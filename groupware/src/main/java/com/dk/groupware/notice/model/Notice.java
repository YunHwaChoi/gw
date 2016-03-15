package com.dk.groupware.notice.model;

import com.dk.groupware.common.model.JspData;

public class Notice {
	/*
	 * 글번호,제목,내용,작성자,작성일,조회수,이미지
	 * name은 join을 위함
	 */
	
	private int no;
	private String title, content, writer, wdate;
	private int hit;
	private String fileName, name;
	
	public Notice(){}
	
	
	public Notice(int no, String title, String content, String writer, String wdate, int hit, String fileName,
			String name) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.wdate = wdate;
		this.hit = hit;
		this.fileName = fileName;
		this.name = name;
	}


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Notice [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", wdate="
				+ wdate + ", hit=" + hit + ", fileName=" + fileName + ", name=" + name + "]";
	}
	public void setJspData(JspData jspData) {
		// TODO Auto-generated method stub
		
	}
	
	


	



	
	
	
}
