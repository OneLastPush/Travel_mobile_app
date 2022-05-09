package com.birikfr.travelafh;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;


/**
 * Manages the reusable questionnaire AlertDialog. 
 * Shows 3 input fields for username, first name, and last name.
 * OK button is disabled until all fields are populated.
 * Stores user input in SharedPreferences after the OK button is clicked.
 */
public class QuestionnaireDialog {
	private Context context;
	private SharedPreferences prefs;
	
	private LinearLayout layout;
	private AlertDialog dialog;
	private String username;
	private String firstName;
	private String lastName;
	
	public QuestionnaireDialog(Context context, SharedPreferences p) {
		this.context = context;
		this.prefs = p;
	}
	
	/**
	 * Shows the questionnaire AlertDialog and stores the trimmed user input in SharedPreferences
	 */
	public void show() {
		AlertDialog.Builder getInfo = new AlertDialog.Builder(context);
		getInfo.setTitle(R.string.getInfoTitle);
		
		layout = new LinearLayout(context);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		final EditText usernameInput = new EditText(context);
		usernameInput.setHint(R.string.usernamePrompt);
		addChangeListener(usernameInput);
		layout.addView(usernameInput);
		
		final EditText firstNameInput = new EditText(context);
		firstNameInput.setHint(R.string.firstNamePrompt);
		addChangeListener(firstNameInput);
		layout.addView(firstNameInput);
		
		final EditText lastNameInput = new EditText(context);
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
				editor.putString("username", username.trim());
				editor.putString("firstName", firstName.trim());
				editor.putString("lastName", lastName.trim());
				editor.commit();
		    }
		});
		
		username = prefs.getString("username", "");
		firstName = prefs.getString("firstName", "");
		lastName = prefs.getString("lastName", "");
		
		if(!username.isEmpty()) {
			getInfo.setNegativeButton(R.string.cancelBtn, new DialogInterface.OnClickListener() { 
			    @Override
			    public void onClick(DialogInterface dialog, int which) {
			    	
			    }
			});
		}
		
		//Prompt username
		dialog = getInfo.create();
		dialog.setCancelable(false);
		dialog.show();
		
		((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
		
		usernameInput.setText(username); 
		firstNameInput.setText(firstName); 
		lastNameInput.setText(lastName); 
	}
	
	public String getUsername() {
		return username;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	private void addChangeListener(final EditText input){
		input.addTextChangedListener(new TextWatcher(){
			@Override
			public void afterTextChanged(Editable s) {
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
				//checkValidInput();
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
}
