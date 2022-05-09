package com.birikfr.travelafh;

import com.birikfr.asyncTack.CurrencyNetworkingAsyncTask;
import com.birikfr.util.Currency;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyActivity extends Activity {

	private final String url = "http://api.fixer.io/latest";
	private Currency currency;
	private TextView displayMsgTextView, dateTextView, resultTextView;
	private Spinner currencySpinner;
	private Spinner currencySpinnerConvertTo;
	private EditText amountEditText;
	private final String STATE_RESULT= "RESULT";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency);
		displayMsgTextView = (TextView) findViewById(R.id.displayMsg);
		dateTextView = (TextView) findViewById(R.id.date);
		amountEditText = (EditText) findViewById(R.id.amountEdit);
		resultTextView = (TextView) findViewById(R.id.currencyResult);
		currency = new Currency();
		getSavedData();
		getCurrencyConversion();
		setSpinner();
		SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
		String result = sharedPref.getString(STATE_RESULT,"");
		if(!result.isEmpty()){
			resultTextView.setText(result);
		}

	}

	private void getSavedData() {
		SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		String date = sharedPref.getString(currency.getSTATE_date(), "");
		if (date.isEmpty() || date.equals(Currency.defaultDate)) {
			dateTextView.setText(Currency.defaultDate);
		} else {
			dateTextView.setText("Last Rates update: " + date);
			currency.retrieveData(sharedPref);
		}
	}

	private void setSpinner() {
		currencySpinnerConvertTo = (Spinner) findViewById(R.id.currencyConvertTo);
		currencySpinner = (Spinner) findViewById(R.id.currencyType);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency,
				android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		currencySpinner.setAdapter(adapter);
		currencySpinnerConvertTo.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.currency, menu);
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

	private void getCurrencyConversion() {
		displayMsgTextView.setText("");
		ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {

			CurrencyNetworkingAsyncTask nat = new CurrencyNetworkingAsyncTask();
			nat.setActivity(this);
			nat.execute(url);
		} else {
			displayMsgTextView.setText("No network connection available.");
		}

	}

	public Activity getActivity() {
		return this;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public void convert(View v){
		int from = currencySpinner.getSelectedItemPosition();
		int to = currencySpinnerConvertTo.getSelectedItemPosition();
		double amount = Double.parseDouble(amountEditText.getText().toString());
		double convertedAmount;
		if(validate(from, to, amount)){		
			convertedAmount = currency.convertEurTo(currency.convertToEUR(amount, from),to);
			resultTextView.setText("Result: " + convertedAmount);
		}

	}

	private boolean validate(int from, int to, double amount){
		
		if(from == 0 || to == 0){
		Toast.makeText(this, "Please select a currency type", Toast.LENGTH_LONG).show();
		return false;
		}else{
			if(amount < 0){
				amountEditText.setText("0");
				Toast.makeText(this, "Please select a valid amount", Toast.LENGTH_LONG).show();
				return false;
			}
		return true;
		}
	}

	@Override
	public void onPause() {
		super.onPause();

		SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString(STATE_RESULT,resultTextView.getText().toString());
		currency.currencySaveSharePref(sharedPref, editor);

	}

	public void setTextViewDate(String date) {
		dateTextView.setText("Last Rates update: " + date);

	}

	public void removeDisplayMsg() {
		displayMsgTextView.setText("");
	}
}
