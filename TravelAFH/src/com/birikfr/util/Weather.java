package com.birikfr.util;

public class Weather {
	private int id;
	private String main;
	private String description;
	public Weather(){
		this(-1, "", "");
	}
	public Weather(final int id,final String main,final String description) {
		
		this.id = id;
		this.main = main;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public String getMain() {
		return main;
	}
	public String getDescription() {
		return description;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] toArray(){
		String array[] = {"General", main, "Type", description};
		return array;
	}
	
}
