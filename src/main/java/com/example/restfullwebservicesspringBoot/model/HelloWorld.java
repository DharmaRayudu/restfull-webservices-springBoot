package com.example.restfullwebservicesspringBoot.model;

public class HelloWorld {
	
	private String name;

	public HelloWorld(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorld [name=" + name + "]";
	}
	
	

}
