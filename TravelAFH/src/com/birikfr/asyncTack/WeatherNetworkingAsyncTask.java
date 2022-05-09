package com.birikfr.asyncTack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.birikfr.travelafh.WeatherActivity;

import com.birikfr.util.WeatherInfo;

import android.os.AsyncTask;

import android.util.Log;

public class WeatherNetworkingAsyncTask extends AsyncTask<String, Integer, WeatherInfo>{
	private static final int MAXBYTES = 500;
	private static final String TAG = "HttpURLConn";
	private WeatherInfo weatherInfo;
	private WeatherActivity wa;
	@Override
	protected void onPreExecute() {

	}

	@Override
	protected WeatherInfo doInBackground(String... params) {
		try {
			String result = downloadUrl(params[0]);
			return storeData(result);
		} catch (IOException e) {
			Log.e(TAG, "exception" + Log.getStackTraceString(e));
			return null;
		}
		
	}

	private WeatherInfo storeData(final String result) {
		WeatherInfo wInfo = new WeatherInfo();
		
		
		String info = result.substring(result.indexOf("weather")+11);
		
		info = info.substring(0, info.indexOf("}]"));
		retrieveWeather(info,wInfo);
		info = result.substring(result.indexOf("name") + 7);
		String city = info.substring(0, (info.indexOf(",")-1));
		info = result.substring(result.indexOf("sys")+ 6);
		info = info.substring(0,info.indexOf("},"));
		retrieveLocation(city, info, wInfo);
		info = result.substring(result.indexOf("wind")+7);
		info = info.substring(0,info.indexOf("}"));
		retrieveWind(result, wInfo);
		info = result.substring(result.indexOf("main\":{") + 7);
		info = info.substring(0,info.indexOf("}"));
		retrieveTemp(info, wInfo);
		return wInfo;
	
	}
	private void retrieveTemp(final String info, final WeatherInfo wInfo ){
		String arr[] = info.split(",");
		int len;
		for(String e: arr){
			if(e.contains("temp\"")){
				wInfo.getTemp().setCurrentTemp(((Double.parseDouble(e.substring(7))-273.15)*1.8)+32.0);
			}else
				if(e.contains("pressure")){
					wInfo.getTemp().setPressure(Double.parseDouble(e.substring(11)));
				}else
				if(e.contains("humidity")){
					wInfo.getTemp().setHumidity(Double.parseDouble(e.substring(11)));
				}else
					if(e.contains("temp_min")){
						wInfo.getTemp().setMin(((Double.parseDouble(e.substring(11))-273.15)*1.8)+32.0);
					}else
						if(e.contains("temp_max")){
							wInfo.getTemp().setMax(((Double.parseDouble(e.substring(11))-273.15)*1.8)+32.0);						}
		}
	}
	
	private void retrieveWind(final String info, final WeatherInfo wInfo){
		String speed = info.substring(info.indexOf("speed")+7);
		wInfo.getWind().setSpeed(Double.parseDouble(speed.substring(0,speed.indexOf(","))));
		String direction = info.substring(info.indexOf("deg")+5);
		wInfo.getWind().setDirection_degree(Double.parseDouble(direction.substring(0,direction.indexOf("}"))));
	}
	private void retrieveLocation(final String city, String country, final WeatherInfo wInfo) {
		wInfo.getLocation().setCity(city);
		country = country.substring(country.indexOf("country")+10);
		country = country.substring(0, country.indexOf(",")-1);
		wInfo.getLocation().setCountry_code(country);
	}

	private void retrieveWeather(final String info, final WeatherInfo wInfo){
		Log.d("Weather", info);
		String arr[] = info.split(",");
		int len;
		for(String e: arr){
			len = (e.length() - 1);
			if(e.contains("id")){
				wInfo.getWeather().setId(Integer.parseInt(e.substring(5)));
			}else
				if(e.contains("main")){
					wInfo.getWeather().setMain(e.substring(8, len));
				}else
				if(e.contains("description")){
					wInfo.getWeather().setDescription(e.substring(15,len));
				}
		}
	}

	private String downloadUrl(String myurl) throws IOException {
		InputStream is = null;
		int len = MAXBYTES;
		HttpURLConnection conn = null;
		URL url = new URL(myurl);
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(15000);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.connect();
			int response = conn.getResponseCode();
			if (response != HttpURLConnection.HTTP_OK)
				return "Server returned: " + response + " aborting read.";
			is = conn.getInputStream();
			String contentAsString = readIt(is, len);
			return contentAsString;
		} catch (IOException e) {
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException ignore) {
				}
				if (conn != null)
					try {
						conn.disconnect();
					} catch (IllegalStateException ignore) {
					}
			}
		}

		return null;
	}

	public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
		char[] buffer = new char[len];
		Reader reader = null;
		reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"), len);
		int count = reader.read(buffer);
		return new String(buffer);
	}

	@Override
	protected void onCancelled(WeatherInfo result) {
	}

	@Override
	protected void onPostExecute(WeatherInfo result) {
		weatherInfo = result;
		wa.setWeather(result);
		wa.getHttpResult();
	}

	protected void onProgressUpdate(Integer progress) {
		
	}

	public void setActivity(WeatherActivity weatherActivity) {
		this.wa = weatherActivity;
		
		
	}

}
