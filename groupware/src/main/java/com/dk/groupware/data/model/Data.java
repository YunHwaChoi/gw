package com.dk.groupware.data.model;

import org.springframework.web.multipart.MultipartFile;

public class Data {

	private int no;
	private String title, content, writer, name, wdate;
	private int hit;
	private String fileName;
	private MultipartFile file;
	
	public Data(){}
	
	// list용
	public Data(int no, String title, String writer, String wdate, int hit) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.wdate = wdate;
		this.hit = hit;
	}
	
	// view용
	public Data(int no, String title, String content, String writer, String wdate, int hit) {
		this(no, title, writer, wdate, hit);
		this.content = content;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Data [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", name=" + name
				+ ", wdate=" + wdate + ", hit=" + hit + ", fileName=" + fileName + ", file=" + file + "]";
	}


}
