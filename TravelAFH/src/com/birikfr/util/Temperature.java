package com.birikfr.util;

import android.content.SharedPreferences;

public class Temperature {
private double currentTemp;
private double min;
private double max;
private double pressure;
private double sea_level;
private double humidity;
public Temperature(){
	this(-1, -1, -1, -1, -1, -1);
}

/**
 * temp - current temperature
 * min - min temperature
 * max - max temperature
 * */
	public Temperature(final double temp, final double min, final double max,
							final double pressure, final double sea_level,
							final double humidity){
		this.currentTemp = temp;
		this.min = min;
		this.max = max;
		this.pressure = pressure;
		this.sea_level = sea_level;
		this.humidity = humidity;
	}
public double getPressure() {
	return pressure;
}
public void setPressure(double pressure) {
	this.pressure = pressure;
}
public double getSea_level() {
	return sea_level;
}
public void setSea_level(double sea_level) {
	this.sea_level = sea_level;
}
public double getHumidity() {
	return humidity;
}
public void setHumidity(double humidity) {
	this.humidity = humidity;
}
public double getTemp() {
	return currentTemp;
}
public void setCurrentTemp(double temp) {
	this.currentTemp = temp;
}
public double getMin() {
	return min;
}
public void setMin(double min) {
	this.min = min;
}
public double getMax() {
	return max;
}
public void setMax(double max) {
	this.max = max;
}
public SharedPreferences storeCache(SharedPreferences shared) {
	// TODO Auto-generated method stub
	return null;
}
public String[] toArray(){
	String array[] = {"Temperature (F)", currentTemp +"",
			"Minimum Temperature", min+"",
			"Maximum Temperature", max+"",
			"Pression", pressure+"",
			"Sea level", sea_level+"",
			"Humidity", humidity+""
			};
	return array;
}
}
