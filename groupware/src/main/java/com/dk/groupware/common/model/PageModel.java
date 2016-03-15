package com.dk.groupware.common.model;

public class PageModel {
	private int id;
	private int page;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "PageModel [id=" + id + ", page=" + page + "]";
	}
}
