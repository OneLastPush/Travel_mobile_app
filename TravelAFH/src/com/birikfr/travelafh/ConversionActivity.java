package com.birikfr.travelafh;

import java.text.DecimalFormat;

import com.birikfr.util.Conversion;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConversionActivity extends Activity implements OnItemSelectedListener{
 private ImageButton imageBtnDistance;
 private ImageButton imageBtnVolume;
 private ImageButton imageBtnWeight;
 private ImageButton imageBtnSwitch;
 private Spinner originalSpinner;
 private Spinner convertSpinner;
 private String currentConversion;
 private EditText convertField;
 private TextView resultField;
 private final String STATE_orig_spinner = "orig_spinner";
 private final String STATE_conv_spinner= "conv_spinner";
 private final String STATE_orig_value = "orig_value";
 private final String STATE_conv_value = "conv_value";
 private final String STATE_RESULT= "RESULT";
 private final String STATE_CONVERSION= "TYPE";
 private final String STATE_FROM ="FROM";
 private final String STATE_TO ="TO";
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversion);
		setSpinner();
		addDistanceListener();
		addVolumeListener();
		addWeightListener();
		addSwitchListener();
		SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
		String result = sharedPref.getString(STATE_RESULT,"");
		if(!result.isEmpty()){
			resultField.setText(result);
			int pos1 = sharedPref.getInt(STATE_FROM,0);
			int pos2 = sharedPref.getInt(STATE_TO,0);
			currentConversion = sharedPref.getString(STATE_CONVERSION,"");
			if(currentConversion.equals("Weight")){
				handlerWeigth();
			}else
			if(currentConversion.equals("Volume")){
				handlerVolume();
			}else
			if(currentConversion.equals("Distance")){
				handlerDistance();
			}
			originalSpinner.setSelection(pos1);
			convertSpinner.setSelection(pos2);
		}

	}
	private void setSpinner(){
		convertField = (EditText) findViewById(R.id.convertEditText);
		originalSpinner = (Spinner) findViewById(R.id.original_spinner);
		convertSpinner = (Spinner) findViewById(R.id.convert_spinner);
		resultField = (TextView) findViewById(R.id.convertResult);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.distanceConversionArray, android.R.layout.simple_spinner_dropdown_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		originalSpinner.setAdapter(adapter);
		convertSpinner.setAdapter(adapter);
		currentConversion ="Distance";
	}
	private Activity getActivity(){
		return this;	
	}
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	    // Save the user's current game state

		savedInstanceState.putInt(STATE_orig_spinner, originalSpinner.getSelectedItemPosition());
		savedInstanceState.putInt(STATE_conv_spinner, convertSpinner.getSelectedItemPosition());
		savedInstanceState.putString(STATE_orig_value, convertField.getText().toString());
		savedInstanceState.putString(STATE_conv_value, resultField.getText().toString());
	
	    // Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}
	private void addSwitchListener(){
		imageBtnSwitch = (ImageButton) findViewById(R.id.switchBtn);
		imageBtnSwitch.setOnClickListener(
				new View.OnClickListener() {
			         @Override
			         public void onClick(View v) {
			        	 int pos1 = originalSpinner.getSelectedItemPosition();
			        	 int pos2 = convertSpinner.getSelectedItemPosition();
			        	 
			        	 if(pos1 != 0 && pos2 != 0 ){
			        		 int temp = pos1;
			        		 pos1 = pos2;
			        		 pos2 = temp;
			        		
			        	 }
			        	 originalSpinner.setSelection(pos1);
			        	 convertSpinner.setSelection(pos2);
			      }
				
			});
			}	
	private void handlerWeigth(){
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
 		        R.array.weightConversionArray, android.R.layout.simple_spinner_dropdown_item);
 		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 		originalSpinner.setAdapter(adapter);
 		convertSpinner.setAdapter(adapter);
 		currentConversion ="Weight";
	}
	private void handlerVolume(){
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
 		        R.array.volumeConversionArray, android.R.layout.simple_spinner_dropdown_item);
 		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 		originalSpinner.setAdapter(adapter);
 		convertSpinner.setAdapter(adapter);
 		currentConversion ="Volume";
	}
	private void handlerDistance(){
		
 		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
 		        R.array.distanceConversionArray, android.R.layout.simple_spinner_dropdown_item);
 		// Specify the layout to use when the list of choices appears
 		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 		// Apply the adapter to the spinner
 		originalSpinner.setAdapter(adapter);
 		convertSpinner.setAdapter(adapter);
 		currentConversion ="Distance";
	}
	private void addWeightListener() {
		imageBtnDistance = (ImageButton)findViewById(R.id.weightBtn);
		imageBtnDistance.setOnClickListener(
				new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	        	 handlerWeigth();
	      }
		
	});
	}
	private void addVolumeListener() {
		imageBtnVolume =(ImageButton)findViewById(R.id.volumeBtn);
		imageBtnVolume.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	        	 handlerVolume();
	      }
		
	});
	}

	private void addDistanceListener() {
		imageBtnWeight =(ImageButton)findViewById(R.id.distanceBtn);
		imageBtnWeight.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	        	 handlerDistance();
	      }
		
	});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.conversion, menu);
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
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		parent.getItemAtPosition(position);
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	public void conversion(View view){
		if(validate()){
		Double num = Double.valueOf(convertField.getText().toString());
 			int toPosition =convertSpinner.getSelectedItemPosition();
 			if(currentConversion.equals("Distance"))
 				distanceConversion(num,toPosition);
 				else if(currentConversion.equals("Volume"))
 						volumeConversion(num,toPosition);
 					else if(currentConversion.equals("Weight"))
 						weightConversion(num,toPosition);

		}
 	}
	private boolean validate(){
		String from = originalSpinner.getSelectedItem().toString();
 		String to = convertSpinner.getSelectedItem().toString();

 		if(from.equals("Select a Distance") || from.equals("Select a Weight") || from.equals("Select a Volume")
 				|| to.equals("Select a Distance") || to.equals("Select a Weight") || to.equals("Select a Volume")){
 			Toast.makeText(this, "Please select a conversion type!", Toast.LENGTH_LONG).show();
 			return false;
 		}
 		if(convertField.getText().toString().isEmpty()){
 			Toast.makeText(this, "Please enter a value before the conversion", Toast.LENGTH_LONG).show();
 			return false;
 		}
 		return true;
	}
	
	private void volumeConversion(Double num,int to) {
		double convertedNum= -1;
		switch(originalSpinner.getSelectedItemPosition()){
		//Liters
		case 1:
			convertedNum = Conversion.lConversion(num, to);
			break;
		//Imperial Gallons
		case 2:
			convertedNum = Conversion.galConversion(num, to);
			break;
		//Milliliters
		case 3:
			convertedNum = Conversion.mlConversion(num, to);
			break;
		//Centiliters
		case 4:
			convertedNum = Conversion.clConversion(num, to);
			break;
		//Pints
		case 5:
			convertedNum = Conversion.ptConversion(num, to);
			break;
		//Tablespoon
		case 6:
			convertedNum = Conversion.tbspConversion(num, to);
			break;
		
			
		}
		if(convertedNum != -1){
			resultField.setText(new DecimalFormat("#.##").format(convertedNum));
		}else{
			resultField.setText("Invalid Number! PLease review your Input");
		}
		
	}
	private void weightConversion(Double num,int to) {
		double convertedNum= -1;
		switch(originalSpinner.getSelectedItemPosition()){
		//Kilogram
		case 1:
			convertedNum = Conversion.kgConversion(num, to);
			break;
		//Gram
		case 2:
			convertedNum = Conversion.gConversion(num, to);
			break;
		//Metirc Ton
		case 3:
			convertedNum = Conversion.tonConversion(num, to);
			break;
		//Pound
		case 4:
			convertedNum = Conversion.lbConversion(num, to);
			break;
		//Ounce
		case 5:
			convertedNum = Conversion.ozConversion(num, to);
			break;
		
		}
		if(convertedNum != -1){
			resultField.setText(new DecimalFormat("#.##").format(convertedNum));
		}else{
			resultField.setText("Invalid Number! PLease review your Input");
		}
		
	}
	private void distanceConversion(Double num, int to) {
		double convertedNum= -1;
		switch(originalSpinner.getSelectedItemPosition()){
		//Centimeter
		case 1:
			convertedNum = Conversion.cmConversion(num, to);
			break;
		//Feet
		case 2:
			convertedNum = Conversion.feetConversion(num, to);
			break;
		//Inch
		case 3:
			convertedNum = Conversion.inchConversion(num, to);
			break;
		//Kilometer
		case 4:
			convertedNum = Conversion.kmConversion(num, to);
			break;
		//Meter
		case 5:
			convertedNum = Conversion.mConversion(num, to);
			break;
		//Mile
		case 6:
			convertedNum = Conversion.mileConversion(num, to);
			break;
		//Yard
		case 7:
			convertedNum = Conversion.yardConversion(num, to);
			break;
			
		}
		if(convertedNum != -1){
			resultField.setText(new DecimalFormat("#.##").format(convertedNum));
		}else{
			resultField.setText("Invalid Number! PLease review your Input");
		}
		
		
		}

	@Override
	public void onPause(){
		super.onPause();
		SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString(STATE_CONVERSION, currentConversion);
		editor.putString(STATE_RESULT,resultField.getText().toString());
		editor.putInt(STATE_FROM,originalSpinner.getSelectedItemPosition());
		editor.putInt(STATE_TO,convertSpinner.getSelectedItemPosition());
		editor.commit();
	}
		
	
	
}
