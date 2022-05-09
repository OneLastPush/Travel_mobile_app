package com.birikfr.travelafh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{
	
	private static DBHelper dbh = null;
	public static final String TAG = "DBHELPER";
	private static final String DATABASE_NAME = "travelapp.db";
	private static final int DATABASE_VERSION = 1;
	
	public static final String TABLE_TRIPS = "trips";
	public static final String AUTO_TRIP_ID = "_id";
	public static final String TRIP_ID = "trip_id";
	public static final String CREATED_ON = "creation_date";
	public static final String UPDATED_ON = "update_date";
	public static final String CLOSED_ON = "close_date";
	public static final String TRIP_NAME = "name";
	public static final String TRIP_DESC = "description";
	
	public static final String TABLE_LOCATIONS = "locations";
	public static final String AUTO_LOCATION_ID = "_id";
	public static final String LOCATION_NAME = "name";
	public static final String LOCATION_DESC = "description";
	public static final String CITY = "city";
	public static final String COUNTRY_CODE = "country_code";

	public static final String TABLE_BUDGETED_EXPENSES = "budgeted_expenses";
	public static final String AUTO_BUDGETED_EXPENSE_ID = "_id";
	public static final String LOCATION_ID_FKEY = "location_id";
	public static final String TRIP_ID_FKEY = "trip_id";
	public static final String DATE_ARRIVE_PLANNED = "date_arrive_planned";
	public static final String DATE_DEPART_PLANNED = "date_depart_planned";
	public static final String AMOUNT_PLANNED = "amount_planned";
	public static final String BUDGETED_EXPENSE_DESC = "description";
	public static final String CATEGORY = "category";
	public static final String NAME_OF_SUPPLIER = "name_of_supplier";
	public static final String ADDRESS = "address";
	
	public static final String TABLE_ACTUAL_EXPENSES = "actual_expenses";
	public static final String AUTO_ACTUAL_EXPENSE_ID = "_id";
	public static final String BUDGETED_EXPENSE_ID_FKEY = "budgeted_expense_id";
	public static final String DATE_ARRIVE = "date_arrive";
	public static final String DATE_DEPART = "date_depart";
	public static final String AMOUNT = "amount";
	public static final String ACTUAL_EXPENSE_DESC = "description";
	public static final String CATEGORY_ACTUAL = "address";
	public static final String NAME_OF_SUPPLIER_ACTUAL = "address";
	public static final String ADDRESS_ACTUAL = "address";
	
	//Creation of the database tables	
	private static final String CREATE_TRIPS_TABLE = "create table " + TABLE_TRIPS + "( "
			+ AUTO_TRIP_ID + " integer primary key autoincrement,"
			+ TRIP_ID + " integer,"
			+ CREATED_ON + " date,"
			+ UPDATED_ON + " date,"
			+ CLOSED_ON + " date,"
			+ TRIP_NAME + " text,"
			+ TRIP_DESC + " text);";
	
	public static final String CREATE_LOCATIONS_TABLE = "create table " + TABLE_LOCATIONS + "( "
			+ AUTO_LOCATION_ID + " integer primary key autoincrement,"
			+ LOCATION_NAME + " text,"
			+ LOCATION_DESC + " text,"
			+ CITY + " text,"
			+ COUNTRY_CODE + " text);";
	
	public static final String CREATE_BUDGETED_EXPENSES_TABLE = "create table " + TABLE_BUDGETED_EXPENSES +"( "
			+ AUTO_LOCATION_ID + " integer primary key autoincrement,"
			+ LOCATION_ID_FKEY + " integer,"
			+ TRIP_ID_FKEY + " integer"
			+ DATE_ARRIVE_PLANNED + " date,"
			+ DATE_DEPART_PLANNED + " date,"
			+ AMOUNT_PLANNED + " real,"
			+ BUDGETED_EXPENSE_DESC + " text,"
			+ CATEGORY + " text,"
			+ NAME_OF_SUPPLIER + " text,"
			+ ADDRESS + " text);";
	
	public static final String CREATE_ACTUAL_EXPENSES_TABLE = "create table " + TABLE_ACTUAL_EXPENSES + "( "
			+ AUTO_ACTUAL_EXPENSE_ID + " integer primary key autoincrement,"
			+ BUDGETED_EXPENSE_ID_FKEY + " integer,"
			+ DATE_ARRIVE + " date,"
			+ DATE_DEPART + " date,"
			+ AMOUNT + " real,"
			+ ACTUAL_EXPENSE_DESC + " text,"
			+ CATEGORY_ACTUAL + " text,"
			+ NAME_OF_SUPPLIER_ACTUAL + " text,"
			+ ADDRESS_ACTUAL + " text);";
	
	private DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public static DBHelper getDBHelper(Context context)	{
		if(dbh==null)
			dbh = new DBHelper(context.getApplicationContext());
		
		return dbh;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIPS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUDGETED_EXPENSES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTUAL_EXPENSES);
		db.execSQL(CREATE_TRIPS_TABLE);
		db.execSQL(CREATE_LOCATIONS_TABLE);
		db.execSQL(CREATE_BUDGETED_EXPENSES_TABLE);
		db.execSQL(CREATE_ACTUAL_EXPENSES_TABLE);
		//populateDatabaseWithTestData(db);		
	}
	
//	private void populateDatabaseWithTestData() {	
//		// Insert trip
//		insertNewTrip("1", "123", "124", "125", "My trip name", "Trip description");
//	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
	
	public long insertNewTrip(String tripId, String createdOn, String updatedOn, String closedOn, String name, String description) {
		SQLiteDatabase db = getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put(TRIP_ID, tripId);
		cv.put(CREATED_ON, createdOn);
		cv.put(UPDATED_ON, updatedOn);
		cv.put(CLOSED_ON, closedOn);
		cv.put(TRIP_NAME, name);
		cv.put(TRIP_DESC, description);
		
		long code1 = db.insert(TABLE_TRIPS, null, cv);
		
		return code1;
	}
	
}