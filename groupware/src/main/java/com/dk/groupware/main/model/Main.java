package com.dk.groupware.main.model;

import org.springframework.ui.Model;

public class Main {
	private int id;
	private Model model;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Main [id=" + id + ", model=" + model + "]";
	}
}
