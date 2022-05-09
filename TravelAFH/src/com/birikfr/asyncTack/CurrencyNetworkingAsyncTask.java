package com.birikfr.asyncTack;

import com.birikfr.travelafh.CurrencyActivity;
import com.birikfr.util.Currency;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CurrencyNetworkingAsyncTask extends AsyncTask<String, Integer, Currency> {
	private CurrencyActivity ca;
	private static final int MAXBYTES = 500;
	private static final String TAG = "HttpURLConn";
	private Currency currency;

	public void setActivity(CurrencyActivity ca){
		this.ca = ca;
	}
	@Override
	protected void onPreExecute() {

	}

	@Override
	protected Currency doInBackground(String... params) {
		try {
			String result = downloadUrl(params[0]);
			return storeData(result);
		} catch (IOException e) {
			Log.e(TAG, "exception" + Log.getStackTraceString(e));
			return null;
		}
		
	}

	private Currency storeData(String result) {
		String date = getDate(result);
		int pos = result.indexOf('{', 4);
		int lastpos = result.length() - 2;
		String cut = result.substring((pos + 1), lastpos);
		double rates[] = new double[19];
		String array[] = cut.split(",");
		for(String e:array ){
			if(e.contains("AUD")){
				rates[0] = Double.parseDouble(e.substring(6));
			}	
			else
				if(e.contains("BGN"))
					rates[1] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("BRL"))
						rates[2] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("CHF"))
						rates[3] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("CAD"))
						rates[4] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("GBP"))
						rates[5] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("HUF"))
						rates[6] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("IDR"))
						rates[7] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("ILS"))
						rates[8] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("INR"))
						rates[9] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("JPY"))
						rates[10] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("KRW"))
						rates[11] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("MXN"))
						rates[12] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("MYR"))
						rates[13] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("PLN"))
						rates[14] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("SEK"))
						rates[15] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("USD"))
						rates[16] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("THB"))
						rates[17] = Double.parseDouble(e.substring(6));
				else
					if(e.contains("RON"))
						rates[18] = Double.parseDouble(e.substring(6));
		}
		
		currency = new Currency(rates[0],rates[1],
				rates[2],rates[3],rates[4],rates[5],
				rates[6],rates[7],rates[8],rates[9],
				rates[10],rates[11],rates[12],rates[13],rates[14],
				rates[15],rates[16],rates[17],rates[18]);
		currency.setDate(date);
		return currency;
	}

	private String getDate(String result) {
		String holder[] = result.split(",");
		for(String element: holder){
			if(element.contains("date")){
				int index = element.indexOf(':') + 2;
				return element.substring(index,index+10);
				
			}
		}
		return null;
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
	protected void onCancelled(Currency result) {
	}

	@Override
	protected void onPostExecute(Currency result) {
		ca.setCurrency(result);
		ca.setTextViewDate(result.getDate());
		ca.removeDisplayMsg();
	}

	protected void onProgressUpdate(Integer progress) {
		ca.setCurrency(currency);
		ca.setTextViewDate(currency.getDate());
		ca.removeDisplayMsg();
	}
}