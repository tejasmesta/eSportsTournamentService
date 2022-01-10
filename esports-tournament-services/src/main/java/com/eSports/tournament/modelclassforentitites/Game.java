package com.eSports.tournament.modelclassforentitites;



public class Game {
	private String name;
	
	

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
