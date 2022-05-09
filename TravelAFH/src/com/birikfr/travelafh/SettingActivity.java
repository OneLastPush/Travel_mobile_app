package com.birikfr.travelafh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SettingActivity extends Activity {
	private String first;
	private String last;
	private String user;
	private EditText firstEdit;
	private EditText lastEdit;
	private EditText userEdit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		firstEdit = (EditText) findViewById(R.id.firstNameEdit);
		lastEdit = (EditText) findViewById(R.id.lastNameEdit);
		userEdit = (EditText) findViewById(R.id.usernameEdit);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			first =extras.getString("FIRST");
			last=extras.getString("LAST");
			user =extras.getString("USER");
			firstEdit.setText(first);
			lastEdit.setText(last);
			userEdit.setText(user);
		}
	}
	public void update(View v){
		first = firstEdit.getText().toString();
		last = lastEdit.getText().toString();
		user = userEdit.getText().toString();
		Intent i = new Intent(SettingActivity.this, MainActivity.class);
		i.putExtra("FIRST",first);
		i.putExtra("LAST",last);
		i.putExtra("USER",user);
		startActivity(i);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
		
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
