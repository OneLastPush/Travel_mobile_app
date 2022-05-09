package com.birikfr.travelafh;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		setSpannableText();
	}

	private void setSpannableText() {
		//Dawson
		SpannableString ss = new SpannableString(getString(R.string.programmerInfo));
		ClickableSpan clickableSpan = new ClickableSpan() {

			@Override
			public void onClick(View widget) {
				String url = "http://www.dawsoncollege.qc.ca/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
			@Override
			public void updateDrawState(TextPaint ds) {
	            super.updateDrawState(ds);
		            ds.setUnderlineText(false);
	        }};
	        ss.setSpan(clickableSpan, 0, 52, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

	        TextView textView = (TextView) findViewById(R.id.programmerInfoId);
	        textView.setText(ss);
	        textView.setMovementMethod(LinkMovementMethod.getInstance());
	        textView.setHighlightColor(Color.TRANSPARENT);
	        
	        
	        
	        //Program 
	        ss = new SpannableString(getString(R.string.program));	
	        clickableSpan = new ClickableSpan() {

			@Override
			public void onClick(View widget) {
			String url = "http://www.dawsoncollege.qc.ca/computer-science-technology/";
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			}
		 @Override
		 public void updateDrawState(TextPaint ds) {
			 super.updateDrawState(ds);
	        ds.setUnderlineText(false);
	        }};
	        ss.setSpan(clickableSpan, 0, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

	        textView = (TextView) findViewById(R.id.programId);
			textView.setText(ss);
			textView.setMovementMethod(LinkMovementMethod.getInstance());
			textView.setHighlightColor(Color.TRANSPARENT);
			
			
			
			//Frank Name
			ss = new SpannableString(getString(R.string.programmerName));
			clickableSpan = new ClickableSpan() {
			
				
			@Override
			public void onClick(View widget) {
				String url = "https://sites.google.com/site/travelafh/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
				}
		 @Override
			public void updateDrawState(TextPaint ds) {
				super.updateDrawState(ds);
				 ds.setUnderlineText(false);
				}};
			ss.setSpan(clickableSpan, 0, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

			textView = (TextView) findViewById(R.id.programmerNameId);
			textView.setText(ss);
			textView.setMovementMethod(LinkMovementMethod.getInstance());
			textView.setHighlightColor(Color.TRANSPARENT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
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
}
