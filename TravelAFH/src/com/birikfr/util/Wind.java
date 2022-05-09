package com.birikfr.util;

import android.content.SharedPreferences;

public class Wind {
	private Double speed;
	private Double direction_degree;
	public Wind(){
		this(-1, -1);
	}
	public Wind(final double speed, final double direction_degree) {
		this.speed = speed;
		this.direction_degree = direction_degree;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDirection_degree() {
		return direction_degree;
	}
	public void setDirection_degree(double direction_degree) {
		this.direction_degree = direction_degree;
	}
	public SharedPreferences storeCache(SharedPreferences shared) {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] toArray(){
		String array[] ={"Wind Speed",speed+"","Wind direction", direction_degree+""};
		return array;
	}
	
}
