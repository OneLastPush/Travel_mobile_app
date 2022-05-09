package com.birikfr.travelafh;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class TipCalActivity extends Activity {
	private EditText billAmount;
	private EditText tipPercent;
	private EditText tipAmount;
	private EditText totalAmount;
	private EditText numPeople;
	private EditText splitAmount;
	static final String STATE_billAmount = "billAmount";
	static final String STATE_tipPercent = "tipPercent";
	static final String STATE_TipAmount = "TipAmount";
	static final String STATE_TotalAmount = "TotalAmount";
	static final String STATE_numPeople = "numPeople";
	static final String STATE_splitAmount = "splitAmount";
	//arrow up
	private ImageButton up_billAmount;
	private ImageButton up_tipPercent;
	private ImageButton up_tipAmount;
	private ImageButton up_totalAmount;
	private ImageButton up_numPeople;
	private ImageButton up_splitAmount;
	//arrow down
	private ImageButton down_billAmount;
	private ImageButton down_tipPercent;
	private ImageButton down_tipAmount;
	private ImageButton down_totalAmount;
	private ImageButton down_numPeople;
	private ImageButton down_splitAmount;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_cal);
		SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		String billAmountText = sharedPref.getString(STATE_billAmount,"0");
		String tipPercentText = sharedPref.getString(STATE_tipPercent,"0");
		String tipAmountText = sharedPref.getString(STATE_billAmount,"0");
		String TotalAmountText = sharedPref.getString(STATE_TotalAmount,"0");
		String numPeopleText = sharedPref.getString(STATE_numPeople,"1");
		String splitAmountText = sharedPref.getString(STATE_splitAmount,"0");
		
		if(savedInstanceState != null){
			billAmountText = savedInstanceState.getString(STATE_billAmount);
			tipPercentText = savedInstanceState.getString(STATE_tipPercent);
			tipAmountText = savedInstanceState.getString(STATE_TipAmount);
			TotalAmountText = savedInstanceState.getString(STATE_TotalAmount);
			numPeopleText = savedInstanceState.getString(STATE_numPeople);
			splitAmountText = savedInstanceState.getString(STATE_splitAmount);
			
		}
		setFields();
		
		billAmount.setText(billAmountText);
		tipPercent.setText(tipPercentText);
		tipAmount.setText(tipAmountText);
		totalAmount.setText(TotalAmountText);
		numPeople.setText(numPeopleText);
		splitAmount.setText(splitAmountText);
		addEvent();
		addArrowListener();
	}
private void setFields(){
	billAmount = (EditText) findViewById(R.id.billAmount);
	tipPercent = (EditText) findViewById(R.id.percentTip);
	tipAmount = (EditText) findViewById(R.id.tipAmount);
	totalAmount = (EditText) findViewById(R.id.totalAmount);
	numPeople = (EditText) findViewById(R.id.numPeople);
	splitAmount = (EditText) findViewById(R.id.splitAmount);
}
	
	@Override	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_cal, menu);
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
	@Override
	public void onPause(){
		super.onPause();
		SharedPreferences sharedPref =  getActivity().getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString(STATE_billAmount, billAmount.getText().toString());
		editor.putString(STATE_tipPercent, tipPercent.getText().toString());
		editor.putString(STATE_TipAmount, tipAmount.getText().toString());
		editor.putString(STATE_TotalAmount, totalAmount.getText().toString());
		editor.putString(STATE_numPeople, numPeople.getText().toString());
		editor.putString(STATE_splitAmount, splitAmount.getText().toString());
		editor.commit();
	}
	private Activity getActivity(){
		return this;
	}
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	    // Save the user's current game state

		savedInstanceState.putString(STATE_billAmount, billAmount.getText().toString());
	    savedInstanceState.putString(STATE_tipPercent, tipPercent.getText().toString());
	    savedInstanceState.putString(STATE_TipAmount, tipAmount.getText().toString());
	    savedInstanceState.putString(STATE_TotalAmount, totalAmount.getText().toString());
	    savedInstanceState.putString(STATE_numPeople, numPeople.getText().toString());
	    savedInstanceState.putString(STATE_splitAmount, splitAmount.getText().toString());
	    // Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}
	
	/**
	 * Add the event on the edit text, so when a edit text has not longer
	 * the focus all the element will update depending of the new input inserted
	 * */
	private void addEvent(){
		billAmount.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!validateNumber(billAmount.getText().toString())){
					billAmount.setText("0");
				
				calculate(0);
			}   
		}
			
		});
		numPeople.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!validateNumber(numPeople.getText().toString())){
					numPeople.setText("1");
				}else{
				calculate(4);
				}
			}   
			
		});
		splitAmount.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!validateNumber(splitAmount.getText().toString())){
					splitAmount.setText("0");
				}else{
				calculate(5);
				}
			}   
			
		});
		tipPercent.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!validateNumber(tipPercent.getText().toString())){
					tipPercent.setText("0");
				}else{
					calculate(1);
				}
			}
			
		});
		totalAmount.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!validateNumber(totalAmount.getText().toString())){
					totalAmount.setText("0");
				}else{
				calculate(3);
			}   
			}
			
		});
		tipAmount.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!validateNumber(tipAmount.getText().toString())){
					tipAmount.setText("0");
				}else{
					calculate(2);
				}
			}
			});
	}
		private boolean validateNumber(String number) {
			 try  
			  {  
			    double d = Double.parseDouble(number); 
			    if(d <= 0){
			    	
			    	return false;
			    }
			  }  
			  catch(NumberFormatException nfe)  
			  {  
				  
			    return false;  
			  }  
			
			return true;
			
		}   
	
	/**
	 * @params fieldModified
	 * 0 - billAmount
	 * 1 - tipPercent
	 * 2 - tip Amount
	 * 3 - total Amount
	 * 4 - split Between num people
	 * 5 - split Amount
	 * */
	private void calculate(int fieldModified){
		String billAmountStr = this.billAmount.getText().toString();
		double billAmount = Double.parseDouble(billAmountStr);
		String numPeopleStr = this.numPeople.getText().toString();
		int numPeople = Integer.parseInt(numPeopleStr);
		String splitAmountStr = this.splitAmount.getText().toString();
		double splitAmount = Double.parseDouble(splitAmountStr);
		String totalAmountStr = this.totalAmount.getText().toString();
		double totalAmount = Double.parseDouble(totalAmountStr);
		String tipAmountStr = this.tipAmount.getText().toString();
		double tipAmount = Double.parseDouble(tipAmountStr);
		String tipPercentStr = this.tipPercent.getText().toString();
		double tipPercent = Double.parseDouble(tipPercentStr);
		try{
		switch(fieldModified){
			
			case 3:
				if(billAmount == 0){
					if(tipPercent == 0){
						billAmount = totalAmount;
						splitAmount = totalAmount/numPeople;
						break;
					}else{
						billAmount = (totalAmount/((tipPercent/100)+1));
					}
				}
				tipPercent = ((totalAmount/billAmount) - 1) * 100;
				if(tipPercent == 0 && totalAmount != billAmount){
					billAmount = totalAmount;
				}
				tipAmount = billAmount * (tipPercent/100);
				totalAmount = billAmount + tipAmount;
				splitAmount = totalAmount/numPeople;
				break;
			case 2:
				if(billAmount == 0){
					if(tipPercent == 0){
						tipAmount = 0;
						break;
					}
					billAmount = (tipAmount * 100)/tipPercent;
					totalAmount = billAmount + tipAmount;
					splitAmount = totalAmount/numPeople;
					break;
				}
				tipPercent = (tipAmount/billAmount) * 100;
				tipAmount = billAmount * (tipPercent/100);
				totalAmount = billAmount + tipAmount;
				splitAmount = totalAmount/numPeople;
				break;
			case 0:
				if(billAmount == 0){
					totalAmount = 0;
				}
			case 1:	
				tipAmount = billAmount * (tipPercent/100);
				totalAmount = billAmount + tipAmount;
				splitAmount = totalAmount/numPeople;
				break;

			case 4:
				splitAmount = totalAmount/numPeople;
				break;
			case 5:
				if(billAmount == 0){
					break;
				}
				totalAmount = numPeople * splitAmount;
				tipPercent = ((totalAmount/billAmount) - 1) * 100;
				tipAmount = billAmount * (tipPercent/100);
				totalAmount = billAmount + tipAmount;
				splitAmount = totalAmount/numPeople;
				break;
		}
		
		
		 DecimalFormat df = new DecimalFormat("#.##");
		this.billAmount.setText(df.format(billAmount).toString());
		this.numPeople.setText(df.format(numPeople).toString());
		this.splitAmount.setText(df.format(splitAmount).toString());
		this.tipAmount.setText(df.format(tipAmount).toString());
		this.tipPercent.setText(df.format(tipPercent).toString());
		this.totalAmount.setText(df.format(totalAmount).toString());
		}catch(Exception e){
			
		}
		
	}
/**
 * This method adds the arrow listener
 * It is a long method but it only addin or subtract one to the current
 * value. It does a little bit of validation .
 *   
 * */	
private void addArrowListener() {
		up_billAmount = (ImageButton) findViewById(R.id.up_billAmount);
		up_tipPercent = (ImageButton) findViewById(R.id.up_percentTip);
		up_tipAmount = (ImageButton) findViewById(R.id.up_tipAmount);
		up_totalAmount = (ImageButton) findViewById(R.id.up_totalAmount);
		up_numPeople = (ImageButton) findViewById(R.id.up_numPeople);
		up_splitAmount = (ImageButton) findViewById(R.id.up_splitAmount);
		down_billAmount = (ImageButton) findViewById(R.id.down_billAmount);
		down_tipPercent = (ImageButton) findViewById(R.id.down_percentTip);
		down_tipAmount = (ImageButton) findViewById(R.id.down_tipAmount);
		down_totalAmount = (ImageButton) findViewById(R.id.down_totalAmount);
		down_numPeople = (ImageButton) findViewById(R.id.down_numPeople);
		down_splitAmount = (ImageButton) findViewById(R.id.down_splitAmount);
		up_billAmount.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				double value = Double.parseDouble(billAmount.getText().toString());
				value++;
				billAmount.setText(value + "");
				calculate(0);
			}
			
		});
		up_tipPercent.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				double value = Double.parseDouble(tipPercent.getText().toString());
				value++;
				tipPercent.setText(value + "");
				calculate(1);
			}
			
		});
		up_tipAmount.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				double value = Double.parseDouble(tipAmount.getText().toString());
				value++;
				tipAmount.setText(value + "");
				calculate(2);
			}
			
		});
		up_totalAmount.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				double value = Double.parseDouble(totalAmount.getText().toString());
				value++;
				totalAmount.setText(value + "");
				calculate(3);
			}
			
		});
		up_numPeople.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				int value = Integer.parseInt(numPeople.getText().toString());
				value++;
				numPeople.setText(value + "");
				calculate(4);
			}
			
		});
		up_splitAmount.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				double value = Double.parseDouble(splitAmount.getText().toString());
				value++;
				splitAmount.setText(value + "");
				calculate(5);
			}
			
		});
		down_billAmount.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				double value = Double.parseDouble(billAmount.getText().toString());
				value--;
				if(value < 0){
					value = 0;
					billAmount.setText(value + "");
				}else{
					billAmount.setText(value + "");
					calculate(0);
				}
			}
			
		});
		down_tipPercent.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				double value = Double.parseDouble(tipPercent.getText().toString());
				value--;
				if(value < 0){
					value = 0;
					tipPercent.setText(value + "");
				}else{
					tipPercent.setText(value + "");
					calculate(1);
				}
			}
			
		});
		down_tipAmount.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				double value = Double.parseDouble(tipAmount.getText().toString());
				value--;
				if(value < 0){
					value = 0;
					tipAmount.setText(value + "");
				}else{
					tipAmount.setText(value + "");
					calculate(2);
				}
				
			}
			
		});
		down_totalAmount.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				double value = Double.parseDouble(totalAmount.getText().toString());
				value--;
				if(value < 0){
					value = 0;
					totalAmount.setText(value + "");
				}else{
					totalAmount.setText(value + "");
					calculate(3);
				}
				
			}
			
		});
		down_numPeople.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				int value = Integer.parseInt(numPeople.getText().toString());
				value--;
				if(value < 1){
					value = 1;
					numPeople.setText(value + "");
				}else{
					numPeople.setText(value + "");
					calculate(4);
				}
				
			}
			
		});
		down_splitAmount.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				double value = Double.parseDouble(splitAmount.getText().toString());
				value--;
				if(value < 0){
					value = 0;
					splitAmount.setText(value + "");
				}else{
					splitAmount.setText(value + "");
					calculate(5);
				}
				
			}
			
		});
		
		
	}

}

