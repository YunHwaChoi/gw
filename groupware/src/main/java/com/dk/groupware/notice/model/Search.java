package com.dk.groupware.notice.model;

public class Search {

	String option;
	String search;

	public Search(String option, String search) {
		super();
		this.option = option;
		this.search = search;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "Search [option=" + option + ", search=" + search + "]";
	}

}
