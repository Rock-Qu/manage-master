package com.biqi.test;

public enum Demo {
	
	red("red",1),
	green("green",1),
	black("black",1);
	
	private String color;
	private Integer num;
	
	private Demo(String color, Integer num) {
		this.color = color;
		this.num = num;
	}
	
	public Integer getnum() {
		
		return this.num;
	}

	public String getcolor() {
		return this.color;
	}
	

}
