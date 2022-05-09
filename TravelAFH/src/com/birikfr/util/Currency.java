package com.birikfr.util;

import android.content.SharedPreferences;

public class Currency {
	private double eurToAUD;
	private double eurToBGN;
	private double eurToBRL;
	private double eurToCHF;
	private double eurToCAD;
	private double eurToGBP;
	private double eurToHUF;
	private double eurToIDR;
	private double eurToILS;
	private double eurToINR;
	private double eurToJPY;
	private double eurToKRW;
	private double eurToMXN;
	private double eurToMYR;
	private double eurToPLN;
	private double eurToSEK;
	private double eurToUSD;
	private double eurToTHB;
	private double eurToRON;
	private final String STATE_eurToAUD ="AUD";
	private final String STATE_eurToBGN="BGN";
	private final String STATE_eurToBRL="BRL";
	private final String STATE_eurToCHF="CHF";
	private final String STATE_eurToCAD="CZK";
	private final String STATE_eurToGBP="GBP";
	private final String STATE_eurToHUF="HUF";
	private final String STATE_eurToIDR="IDR";
	private final String STATE_eurToILS="ILS";
	private final String STATE_eurToINR="INR";
	private final String STATE_eurToJPY="JPY";
	private final String STATE_eurToKRW="KRW";
	private final String STATE_eurToMXN="MXN";
	private final String STATE_eurToMYR="MYR";
	private final String STATE_eurToPLN="PLN";
	private final String STATE_eurToSEK="SEK";
	private final String STATE_eurToUSD="USD";
	private final String STATE_eurToTHB="THB";
	private final String STATE_eurToRON="RON";
	private final String STATE_date="DATE";
	public static final String defaultDate ="No current data store";
	private String date;
	public Currency(){
		eurToAUD = -1;
		eurToBGN = -1;
		eurToBRL = -1;
		eurToCHF = -1;
		eurToCAD = -1;
		eurToGBP = -1;
		eurToHUF = -1;
		eurToIDR = -1;
		eurToILS = -1;
		eurToINR = -1;
		eurToJPY = -1;
		eurToKRW = -1;
		eurToMXN = -1;
		eurToMYR = -1;
		eurToPLN = -1;
		eurToSEK = -1;
		eurToUSD = -1;
		eurToTHB = -1;
		eurToRON = -1;
		date = "No current data store";
	}
	
	public Currency(final double AUD, final double BGN, final double BRL, final double CHF, final double CAD,
			final double GBP, final double HUF, final double IDR, final double ILS, final double INR, final double JPY,
			final double KRW, final double MXN, final double MYR, final double PLN, final double SEK, final double USD,
			final double THB, final double RON) {
		eurToAUD = AUD;
		eurToBGN = BGN;
		eurToBRL = BRL;
		eurToCHF = CHF;
		eurToCAD = CAD;
		eurToGBP = GBP;
		eurToHUF = HUF;
		eurToIDR = IDR;
		eurToILS = ILS;
		eurToINR = INR;
		eurToJPY = JPY;
		eurToKRW = KRW;
		eurToMXN = MXN;
		eurToMYR = MYR;
		eurToPLN = PLN;
		eurToSEK = SEK;
		eurToUSD = USD;
		eurToTHB = THB;
		eurToRON = RON;
		date = "No current data store";

	}
	public void currencySaveSharePref(SharedPreferences sharedPref,SharedPreferences.Editor editor) {
		editor.putString(STATE_eurToAUD, eurToAUD + "");
		editor.putString(STATE_eurToBGN, eurToBGN + "");
		editor.putString(STATE_eurToBRL, eurToBRL + "");
		editor.putString(STATE_eurToCHF, eurToCHF + "");
		editor.putString(STATE_eurToCAD, eurToCAD + "");
		editor.putString(STATE_eurToGBP, eurToGBP + "");
		editor.putString(STATE_eurToHUF, eurToHUF + "");
		editor.putString(STATE_eurToIDR, eurToIDR + "");
		editor.putString(STATE_eurToILS, eurToILS + "");
		editor.putString(STATE_eurToINR, eurToINR + "");
		editor.putString(STATE_eurToJPY, eurToJPY + "");
		editor.putString(STATE_eurToKRW, eurToKRW + "");
		editor.putString(STATE_eurToMXN, eurToMXN + "");
		editor.putString(STATE_eurToMYR, eurToMYR + "");
		editor.putString(STATE_eurToPLN, eurToPLN + "");
		editor.putString(STATE_eurToSEK, eurToSEK + "");
		editor.putString(STATE_eurToUSD, eurToUSD + "");
		editor.putString(STATE_eurToTHB, eurToTHB + "");
		editor.putString(STATE_eurToRON, eurToRON + "");
		editor.putString(STATE_date, date);
		
		editor.commit();
	}
	public String getSTATE_eurToAUD() {
		return STATE_eurToAUD;
	}
	public String getSTATE_eurToBGN() {
		return STATE_eurToBGN;
	}
	public String getSTATE_eurToBRL() {
		return STATE_eurToBRL;
	}
	public String getSTATE_eurToCHF() {
		return STATE_eurToCHF;
	}
	public String getSTATE_eurToCAD() {
		return STATE_eurToCAD;
	}
	public String getSTATE_eurToGBP() {
		return STATE_eurToGBP;
	}
	public String getSTATE_eurToHUF() {
		return STATE_eurToHUF;
	}
	public String getSTATE_eurToIDR() {
		return STATE_eurToIDR;
	}
	public String getSTATE_eurToILS() {
		return STATE_eurToILS;
	}
	public String getSTATE_eurToINR() {
		return STATE_eurToINR;
	}
	public String getSTATE_eurToJPY() {
		return STATE_eurToJPY;
	}
	public String getSTATE_eurToKRW() {
		return STATE_eurToKRW;
	}
	public String getSTATE_eurToMXN() {
		return STATE_eurToMXN;
	}
	public String getSTATE_eurToMYR() {
		return STATE_eurToMYR;
	}
	public String getSTATE_eurToPLN() {
		return STATE_eurToPLN;
	}
	public String getSTATE_eurToSEK() {
		return STATE_eurToSEK;
	}
	public String getSTATE_eurToUSD() {
		return STATE_eurToUSD;
	}
	public String getSTATE_eurToTHB() {
		return STATE_eurToTHB;
	}
	public String getSTATE_eurToRON() {
		return STATE_eurToRON;
	}
	public String getSTATE_date() {
		return STATE_date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setEurToAUD(double eurToAUD) {
		this.eurToAUD = eurToAUD;
	}
	public void setEurToBGN(double eurToBGN) {
		this.eurToBGN = eurToBGN;
	}
	public void setEurToBRL(double eurToBRL) {
		this.eurToBRL = eurToBRL;
	}
	public void setEurToCHF(double eurToCHF) {
		this.eurToCHF = eurToCHF;
	}
	public void setEurToCAD(double eurToCAD) {
		this.eurToCAD = eurToCAD;
	}
	public void setEurToGBP(double eurToGBP) {
		this.eurToGBP = eurToGBP;
	}
	public void setEurToHUF(double eurToHUF) {
		this.eurToHUF = eurToHUF;
	}
	public void setEurToIDR(double eurToIDR) {
		this.eurToIDR = eurToIDR;
	}
	public void setEurToILS(double eurToILS) {
		this.eurToILS = eurToILS;
	}
	public void setEurToINR(double eurToINR) {
		this.eurToINR = eurToINR;
	}
	public void setEurToJPY(double eurToJPY) {
		this.eurToJPY = eurToJPY;
	}
	public void setEurToKRW(double eurToKRW) {
		this.eurToKRW = eurToKRW;
	}
	public void setEurToMXN(double eurToMXN) {
		this.eurToMXN = eurToMXN;
	}
	public void setEurToMYR(double eurToMYR) {
		this.eurToMYR = eurToMYR;
	}
	public void setEurToPLN(double eurToPLN) {
		this.eurToPLN = eurToPLN;
	}
	public void setEurToSEK(double eurToSEK) {
		this.eurToSEK = eurToSEK;
	}
	public void setEurToUSD(double eurToUSD) {
		this.eurToUSD = eurToUSD;
	}
	public void setEurToTHB(double eurToTHB) {
		this.eurToTHB = eurToTHB;
	}
	public void setEurToRON(double eurToRON) {
		this.eurToRON = eurToRON;
	}
	/**
	 * @param amount
	 * @param position - item's position in the spinner, 
	 * 						the type of currency that the amount is 
	 * @return the amount converted into EUR
	 * */
	public double convertToEUR(double amount, int position){
		
		switch(position){
		//EUR
		case 1:
			return amount;
		//AUD;
		case 2:
			return amount/eurToAUD;
		//BTC;
		case 3:
			return amount/eurToBGN;
		//BRL;
		case 4:
			return amount/eurToBRL;
		//CAD;
		case 5:
			return amount/eurToCAD;
		//CHF;
		case 6:
			return amount/eurToCHF;
		//GBP;
		case 7:
			return amount/eurToGBP;
		//HUF;
		case 8:
			return amount/eurToHUF;
		//IDR;
		case 9:
			return amount/eurToIDR;
		//ILS;
		case 10:
			return amount/eurToILS;
		//INR;
		case 11:
			return amount/eurToINR;
		//JPY;
		case 12:
			return amount/eurToJPY;
		//KRW;
		case 13:
			return amount/eurToKRW;
		//MXN;
		case 14:
			return amount/eurToMXN;
		//MYR;
		case 15:
			return amount/eurToMYR;
		//PLN;
		case 16:
			return amount/eurToPLN;
		//SEK;
		case 17:
			return amount/eurToSEK;
		//TRY;
		case 18:
			return amount/eurToUSD;
		//THB;
		case 19:
			return amount/eurToTHB;
		//VND;
		case 20:
			return amount/eurToRON;
		default:
			return -1;
		}

	}
	/**
	 * @param amount
	 * @param position - item's position in the spinner, 
	 * 						the type of currency that you want to convert to 
	 * @return the amount converted into EUR
	 * */
	public double convertEurTo(double amount, int position){
		switch(position){
		//EUR
		case 1:
			return amount;
		//AUD;
		case 2:
			return amount*eurToAUD;
		//BTC;
		case 3:
			return amount*eurToBGN;
		//BRL;
		case 4:
			return amount*eurToBRL;
			//CAD;
		case 5:
			return amount*eurToCAD;
		//CHF;
		case 6:
			return amount*eurToCHF;
		//GBP;
		case 7:
			return amount*eurToGBP;
		//HUF;
		case 8:
			return amount*eurToHUF;
		//IDR;
		case 9:
			return amount*eurToIDR;
		//ILS;
		case 10:
			return amount*eurToILS;
		//INR;
		case 11:
			return amount*eurToINR;
		//JPY;
		case 12:
			return amount*eurToJPY;
		//KRW;
		case 13:
			return amount*eurToKRW;
		//MXN;
		case 14:
			return amount*eurToMXN;
		//MYR;
		case 15:
			return amount*eurToMYR;
		//PLN;
		case 16:
			return amount*eurToPLN;
		//SEK;
		case 17:
			return amount*eurToSEK;
		//TRY;
		case 18:
			return amount*eurToUSD;
		//THB;
		case 19:
			return amount*eurToTHB;
		//VND;
		case 20:
			return amount*eurToRON;
		default:
			return -1;
		}
		
	}
	public void retrieveData(SharedPreferences sharedPref) {
		eurToAUD = Double.parseDouble(sharedPref.getString(STATE_eurToAUD, "-1"));
		eurToCHF = Double.parseDouble(sharedPref.getString(STATE_eurToCHF, "-1"));
		eurToBRL = Double.parseDouble(sharedPref.getString(STATE_eurToBRL, "-1"));
		eurToCAD = Double.parseDouble(sharedPref.getString(STATE_eurToCAD, "-1"));
		eurToGBP = Double.parseDouble(sharedPref.getString(STATE_eurToGBP, "-1"));
		eurToHUF = Double.parseDouble(sharedPref.getString(STATE_eurToHUF, "-1"));
		eurToIDR = Double.parseDouble(sharedPref.getString(STATE_eurToIDR, "-1"));
		eurToILS = Double.parseDouble(sharedPref.getString(STATE_eurToILS, "-1"));
		eurToINR = Double.parseDouble(sharedPref.getString(STATE_eurToINR, "-1"));
		eurToJPY = Double.parseDouble(sharedPref.getString(STATE_eurToJPY, "-1"));
		eurToKRW = Double.parseDouble(sharedPref.getString(STATE_eurToKRW, "-1"));
		eurToMXN = Double.parseDouble(sharedPref.getString(STATE_eurToMXN, "-1"));
		eurToMYR = Double.parseDouble(sharedPref.getString(STATE_eurToMYR, "-1"));
		eurToPLN = Double.parseDouble(sharedPref.getString(STATE_eurToPLN, "-1"));
		eurToSEK = Double.parseDouble(sharedPref.getString(STATE_eurToSEK, "-1"));
		eurToUSD = Double.parseDouble(sharedPref.getString(STATE_eurToUSD, "-1"));
		eurToTHB = Double.parseDouble(sharedPref.getString(STATE_eurToTHB, "-1"));
		eurToRON = Double.parseDouble(sharedPref.getString(STATE_eurToRON, "-1"));

		
	}

	
}
