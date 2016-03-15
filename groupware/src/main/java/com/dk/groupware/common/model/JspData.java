package com.dk.groupware.common.model;

public class JspData {
	private int totalPage;
	private int startPage;
	private int endPage;
	private int page;
	private int pagesPerGroup;
	private int startRow;
	private int endRow;

	private int id;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesPerGroup() {
		return pagesPerGroup;
	}

	public void setPagesPerGroup(int pagesPerGroup) {
		this.pagesPerGroup = pagesPerGroup;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "JspData [totalPage=" + totalPage + ", startPage=" + startPage + ", endPage=" + endPage + ", page="
				+ page + ", pagesPerGroup=" + pagesPerGroup + ", startRow=" + startRow + ", endRow=" + endRow + ", id="
				+ id + "]";
	}
}
