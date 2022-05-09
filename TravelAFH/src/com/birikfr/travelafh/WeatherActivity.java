package com.birikfr.travelafh;

import java.util.ArrayList;

import com.birikfr.adapter.MenuAdapter;
import com.birikfr.adapter.WeatherAdapter;
import com.birikfr.asyncTack.CurrencyNetworkingAsyncTask;
import com.birikfr.asyncTack.WeatherNetworkingAsyncTask;
import com.birikfr.util.WeatherInfo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

public class WeatherActivity extends Activity {
	private WeatherInfo weatherInfo;
	private String url ="http://api.openweathermap.org/data/2.5/weather?q=";
	private final String id="&appid=5c77530f335023349c4aea82b2bf83c7";
	private EditText cityEdit;
	private EditText countryCodeEdit;
	private TextView displayMsgTextView;
	private String item[];
	private GridView weatherGridView;
	private final String STATE_RESULT ="result";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);
		setFields();
	}

	private void setFields() {
		cityEdit = (EditText) findViewById(R.id.editCity);
		countryCodeEdit = (EditText) findViewById(R.id.editCountryCode);
		displayMsgTextView = (TextView) findViewById(R.id.displayMsgWeather);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weather, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void setWeather(WeatherInfo weatherInfo){
		this.weatherInfo = weatherInfo;
	}
	public void getWeather(View v){
		String urlToSend;
		String city;
		if(!cityEdit.getText().toString().isEmpty()){
			urlToSend = this.url;
			city =cityEdit.getText().toString();
			urlToSend+=city;
			Log.d("city", cityEdit.getText().toString());
			Log.d("concat url", urlToSend);
			if(!countryCodeEdit.getText().toString().isEmpty()){
				urlToSend+="," + countryCodeEdit.getText().toString();
				Log.d("concat url", urlToSend);
			}
			urlToSend+=this.id;
			Log.d("concat url", urlToSend);
			ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isConnected()) {
				displayMsgTextView.setText("");
				WeatherNetworkingAsyncTask nat = new WeatherNetworkingAsyncTask();
				nat.setActivity(this);
				Log.d("url", urlToSend);
				nat.execute(urlToSend);
			} else {
				displayMsgTextView.setText("No network connection available.");
			}
		}
	}
	public void getHttpResult(){
		weatherGridView = (GridView) findViewById(R.id.weatherGridView);
		ArrayList<String> item = new ArrayList<String>();
		for(String e: weatherInfo.getLocation().toArray() )
			item.add(e);
		for(String e: weatherInfo.getTemp().toArray())
			item.add(e);
		for(String e: weatherInfo.getWeather().toArray())
			item.add(e);
		for(String e: weatherInfo.getWind().toArray())
			item.add(e);

		this.item = item.toArray(new String[item.size()]);
		weatherGridView.setAdapter(new WeatherAdapter(this,this.item));
	}
	@Override
	public void onPause(){
		super.onPause();
		SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		
		//editor.putString(STATE_RESULT, );
		
	}
}
