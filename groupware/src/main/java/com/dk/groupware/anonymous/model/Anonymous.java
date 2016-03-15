package com.dk.groupware.anonymous.model;

public class Anonymous {
	private int no;
	private String title;
	private String content;
	private String writer;
	private String wdate;
	private int hit;
	private int rcount;

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

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	@Override
	public String toString() {
		return "Anonymous [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", wdate="
				+ wdate + ", hit=" + hit + ", rcount=" + rcount + "]";
	}
}
