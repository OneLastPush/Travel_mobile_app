package com.birikfr.util;

import android.content.SharedPreferences;

public class WeatherInfo {

	private Location location;
	private Temperature temp;
	private long time;
	private Wind wind;
	private Weather weather;
	public WeatherInfo() {
		this(new Location(), new Temperature(), -1L, new Wind(), new Weather());
	}
	public WeatherInfo(final Location location,final Temperature temp,final long time,final Wind wind, final Weather weather) {
		this.location = location;
		this.temp = temp;
		this.time = time;
		this.wind = wind;
		this.weather = weather;
	}
	public final Location getLocation() {
		return location;
	}

	public final Temperature getTemp() {
		return temp;
	}

	public long getTime() {
		return time;
	}

	public final Wind getWind() {
		return wind;
	}

	public final Weather getWeather() {
		return weather;
	}
	public SharedPreferences storeCache(SharedPreferences shared){
	shared = location.storeCache(shared);
	shared = wind.storeCache(shared);
	shared = temp.storeCache(shared);
		return shared;	
	}
	

	
}
