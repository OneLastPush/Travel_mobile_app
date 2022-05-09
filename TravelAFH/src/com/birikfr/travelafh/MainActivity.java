package com.birikfr.travelafh;

import com.birikfr.adapter.MenuAdapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	GridView menuLayout;
	private static final int MENU_ABOUT = 0;
	private static final int MENU_DAWSON = 1;
	private static final int MENU_SETTING = 2;
	private SharedPreferences prefs;
	
	private LinearLayout layout;
	private AlertDialog dialog;
	private String username;
	private String firstName;
	private String lastName;
	public TextView welcomeMsg;
	private Integer item[] = {R.drawable.underconstruction,
			R.drawable.underconstruction, R.drawable.tiplogo,
			R.drawable.metric, R.drawable.currency_logo,
			R.drawable.weatherlogo, R.drawable.underconstruction,
			R.drawable.underconstruction, R.drawable.underconstruction};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		welcomeMsg =(TextView) findViewById(R.id.welcomeMsg);
		
		prefs = getPreferences(MODE_PRIVATE);
		username = prefs.getString("username", "");
		firstName = prefs.getString("firstName", "");
		lastName = prefs.getString("lastName", "");
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			firstName =extras.getString("FIRST");
			lastName=extras.getString("LAST");
			username =extras.getString("USER");
			setWelcomeMsg();
		}
		if (username.isEmpty()) {
			AlertDialog.Builder getInfo = new AlertDialog.Builder(this);
			getInfo.setTitle(R.string.getInfoTitle);

			layout = new LinearLayout(this);
			layout.setOrientation(LinearLayout.VERTICAL);
			
			final EditText usernameInput = new EditText(this);
			usernameInput.setHint(R.string.usernamePrompt);
			addChangeListener(usernameInput);
			layout.addView(usernameInput);
			
			final EditText firstNameInput = new EditText(this);
			firstNameInput.setHint(R.string.firstNamePrompt);
			addChangeListener(firstNameInput);
			layout.addView(firstNameInput);
			
			final EditText lastNameInput = new EditText(this);
			lastNameInput.setHint(R.string.lastNamePrompt);
			addChangeListener(lastNameInput);
			layout.addView(lastNameInput);
			
			getInfo.setView(layout);
			
			getInfo.setPositiveButton(R.string.okBtn, new DialogInterface.OnClickListener() { 
			    @Override
			    public void onClick(DialogInterface dialog, int which) {
			    	username = usernameInput.getText().toString();
			    	firstName = firstNameInput.getText().toString();
			    	lastName = lastNameInput.getText().toString();
			    	
			    	SharedPreferences.Editor editor = prefs.edit();
					editor.putString("username", username);
					editor.putString("firstName", firstName);
					editor.putString("lastName", lastName);
					editor.commit();
					setWelcomeMsg();
					
			    }
			});
			
			//Prompt username
			dialog = getInfo.create();
			
			dialog.show();
			((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
			
				
			
		}
		setWelcomeMsg();
		menuLayout = (GridView) findViewById(R.id.menuGridView);
		menuLayout.setAdapter(new MenuAdapter(this,item));
		menuLayout.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i;
				switch(position){
				//current trip
				case 0:
					
					i = new Intent(view.getContext(), ComingSoonActivity.class);
					view.getContext().startActivity(i);
					break;
				//Today
				case 1:
				
					i = new Intent(view.getContext(), ComingSoonActivity.class);
					view.getContext().startActivity(i);
					break;
				//Tip Calculator
				case 2:
					
					i = new Intent(view.getContext(), TipCalActivity.class);
					view.getContext().startActivity(i);
					break;
				//Conversion
				case 3:
					
					i = new Intent(view.getContext(), ConversionActivity.class);

					view.getContext().startActivity(i);
					break;
				//Weather check
				case 4:
					
					i = new Intent(view.getContext(), CurrencyActivity.class);
					view.getContext().startActivity(i);
					break;
				//Currency conversion
				case 5:
					
					i = new Intent(view.getContext(), WeatherActivity.class);
					view.getContext().startActivity(i);
					break;
				//Manage Trips
				case 6:
					
					i = new Intent(view.getContext(), ComingSoonActivity.class);
					view.getContext().startActivity(i);
					break;
				
				case 7:
					
					i = new Intent(view.getContext(), ComingSoonActivity.class);
					view.getContext().startActivity(i);
					break;
				case 8:
					
					i = new Intent(view.getContext(), ComingSoonActivity.class);
					view.getContext().startActivity(i);
					break;
				default:
					
					i = new Intent(view.getContext(), ComingSoonActivity.class);
					view.getContext().startActivity(i);
					break;		
				}			
			}
		});
	}
	
	public void setWelcomeMsg() {
		
		welcomeMsg.setText("Welcome " + firstName);
		
	}

	private void addChangeListener(final EditText input){
		input.addTextChangedListener(new TextWatcher(){
			@Override
			public void afterTextChanged(Editable s) {
				//checkValidInput();
				boolean valid = true;
				int childcount = layout.getChildCount();
				for (int i=0; i < childcount; i++){
					EditText v = (EditText) layout.getChildAt(i);
				    if (v.getText().toString().trim().isEmpty()) {
				    	valid = false;
				    	break;
				    }
				}
				
				if(!valid){
					((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
				}else{
					((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
				}	
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});
	}
	
	/*private void checkValidInput(){
		boolean valid = true;
		int childcount = layout.getChildCount();
		for (int i=0; i < childcount; i++){
			EditText v = (EditText) layout.getChildAt(i);
		    if (v.getText().toString().trim().isEmpty()) {
		    	valid = false;
		    	break;
		    }
		}
		
		if(!valid){
			((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
		}else{
			((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
		}	
	}*/
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(Menu.NONE, MENU_ABOUT, Menu.NONE, R.string.AboutMenu);
		
		menu.add(Menu.NONE, MENU_DAWSON, Menu.NONE, R.string.DawsonMenu);
		menu.add(Menu.NONE, MENU_SETTING, Menu.NONE, R.string.setting);
		menu.getItem(MENU_DAWSON).setOnMenuItemClickListener( new OnMenuItemClickListener(){
		
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				String url = "http://www.dawsoncollege.qc.ca/computer-science-technology/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
				return false;
			}
			
			
		});menu.getItem(MENU_ABOUT).setOnMenuItemClickListener( new OnMenuItemClickListener(){

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent i = new Intent(MainActivity.this, AboutActivity.class);
				startActivity(i);
				return false;
			}
			
			
		});
		menu.getItem(MENU_SETTING).setOnMenuItemClickListener( new OnMenuItemClickListener(){

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent i = new Intent(MainActivity.this, SettingActivity.class);
				i.putExtra("FIRST",firstName);
				i.putExtra("LAST",lastName);
				i.putExtra("USER",username);
				startActivity(i);
				return false;
			}
			
			
		});
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(MENU_ABOUT == id)
		{
		//Intent i = new Intent(this, AboutActivity.class);
		//startActivity(i);
		}else
		{
			if(MENU_DAWSON == id)
			{
			
			}	
		}
		return super.onOptionsItemSelected(item);
	}
}
