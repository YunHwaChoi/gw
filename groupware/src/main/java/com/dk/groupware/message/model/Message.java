package com.dk.groupware.message.model;

import javax.servlet.http.HttpSession;

public class Message {

	/*
	 * 글번호,제목,내용,날짜,보내는 유저,받는 유저,읽음 확인
	 */
	private int no;
	private String title, content, sdate;
	private String rdate, fileName;
	private int sender, receiver;
	private HttpSession session;
	private String name;

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

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "Message [no=" + no + ", title=" + title + ", content=" + content + ", sdate=" + sdate + ", rdate="
				+ rdate + ", fileName=" + fileName + ", sender=" + sender + ", receiver=" + receiver + ", name=" + name
				+ ", session=" + session + "]";
	}

}
