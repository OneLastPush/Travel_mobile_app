package com.birikfr.util;

import android.content.SharedPreferences;

public class Location {
	private String country_code;
	private String city;
	private int id;
	public Location(){
		this(-1,"","");
	}
	public Location(final int id, final String city, final String country_code){
		this.id = id;
		this.city = city;
		this.country_code = country_code;
	}
	
	
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SharedPreferences storeCache(SharedPreferences shared) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * This method return an array with the name of the element 
	 * This method is needed for display
	*/
	public String[] toArray(){
		String array[] = {"City",city,"Country code", country_code};
		return array;
	}
}
