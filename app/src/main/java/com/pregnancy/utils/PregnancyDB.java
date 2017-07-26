package com.pregnancy.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import com.pregnancy.model.Calendar;

public class PregnancyDB extends SQLiteOpenHelper {

	private SQLiteDatabase db;

	private static final String DB_NAME = "quizDb";

	private static final int DB_VERSION = 1;

	private Context context;

	private final String CALENDAR_TBL = "calendar_tbl";
	private final String QUIZ_TBL = "quiz_tbl";

	public boolean isDbOpen() {
		return db.isOpen();
	}

	// Table - Category
	/**
	 * Insert into category
	 * */
	public void insertCalendar( String calDate, String calNote
		) {
		String query = "insert into " + CALENDAR_TBL+" (caldate,calnote)"+ " values ('" + calDate + "','" + calNote + "')";
		System.out.println("query" + query);
		db.execSQL(query);
	}

	
	/*public void insertQuiz(String id,String setid, String title, String option1, String option2,String option3,String option4,String correctans,String difficulty,
			String category,String uploadedfile) {
		String query = "insert into " + QUIZ_TBL + " values ('" + id
				+ "','" + setid + "','"+
				title + "','" + option1 + "','" + 
				option2 + "','"+option3+"','" + option4 + "','"+correctans+"','" + difficulty + "','"+ category + "','"+uploadedfile + "')";
		System.out.println("query" + query);
		try {
			db.execSQL(query);
		}catch (SQLException e){
			e.printStackTrace();
			Log.d("CATEGORY", "not succesful");
		}
	}*/
	
	
	public List<Calendar> GetAllCalendar() {
		List<Calendar> myCategories = new ArrayList<Calendar>();

		String query = "select *  from " + CALENDAR_TBL + "";

		Cursor cursor = db.rawQuery(query, null);

		cursor.move(-1);
		while (cursor.moveToNext()) {
			Calendar category = new Calendar();

			//category.setId(cursor.getString(0));// id
			category.setCal_date(cursor.getString(1));//our custom
			category.setCal_note(cursor.getString(2));// title

			

			myCategories.add(category);

		}

		cursor.close();

		return myCategories;

	}

/*	public int updatequiz(String oldname, String name, String title, String date,
						  String description) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("title", title);
		values.put("date", date);
		values.put("description", description);


		String[] where = { oldname };
		int count = db.update(DAIRY_TBL, values, "title" + " =? ", where);
		System.out.println("count " + count);
		return count;
	}*/

/*
	public List<Category> GetAllCategorieseasy() {
		List<Category> myCategories = new ArrayList<Category>();

		String query = "select *  from " + CATEGORY_TBL + "";

		Cursor cursor = db.rawQuery(query, null);

		cursor.move(-1);
		while (cursor.moveToNext()) {
			Category category = new Category();

			//category.setId(cursor.getString(0));// id
			category.setcatId(cursor.getString(4));//our custom
			category.setTitle(cursor.getString(1));// title
			category.setDate(cursor.getString(2));// date
			category.setStatus(cursor.getString(3));// status
			
			

			myCategories.add(category);

		}

		cursor.close();

		return myCategories;

	}*/
	
	
	
	
	
	
	
	
	/*public List<String> Getsaad() {
		List<String> myCategories = new ArrayList<String>();

		String query = "select *  from " + CATEGORY_TBL + "";

		Cursor cursor = db.rawQuery(query, null);

		cursor.move(-1);
		while (cursor.moveToNext()) {
			//String category ;
			Log.i("iN","iNFO");
			 String category = cursor.getString(1);

			//category.setId(cursor.getString(0));// id
			//category.setcatId(cursor.getString(4));//our custom
		//	category.add(cursor.getString(1));// title
			//category.setDate(cursor.getString(2));// date
			//category.setStatus(cursor.getString(3));// status
			
			

			myCategories.add(category);

		}

		cursor.close();

		return myCategories;

	}
*/
	/**
	 * Close Opened SQLiteDatabase
	 */
	public void closeDb() {
		db.close();
	}

	// Constructor to simplify Business logic access to the repository
	public PregnancyDB(Context context) {

		super(context, DB_NAME, null, DB_VERSION);

		this.context = context;
		if (this.db == null) {
			// db=context.
			this.db = getWritableDatabase();

		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		this.db = db;
		createDataBase();

	}

	/**
	 * Create Database
	 */
	private void createDataBase() {

		// Log.i("DB:", "created");

		db.execSQL("CREATE TABLE IF NOT EXISTS android_metadata ('locale' TEXT DEFAULT 'en_US')");

		

		db.execSQL("CREATE TABLE IF NOT EXISTS "
				+ CALENDAR_TBL
				+ "(id TEXT PRIMARY KEY , caldate TEXT NOT NULL ,calnote TEXT NOT NULL );");
		
		
		db.execSQL("CREATE TABLE IF NOT EXISTS "
				+ QUIZ_TBL
				+ "(quizid TEXT PRIMARY KEY NOT NULL , " +
				"setid TEXT NOT NULL , " +
				"quiztitle TEXT NOT NULL , " +
				"option1 TEXT NOT NULL ," +
				"option2 TEXT NOT NULL," +
				"option3 TEXT NOT NULL ," +
				"option4 TEXT NOT NULL ," +
				"correctans TEXT NOT NULL ," +
				"difficulty TEXT NOT NULL ," +
				"category TEXT NOT NULL ," +
				"uploadedfile TEXT NOT NULL);");
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

}





/*
public class DairyDb extends SQLiteOpenHelper {

	public DairyDb(Context context) {

		super(context, DB_NAME, null, DB_VERSION);

		this.context = context;
		if (this.db == null) {
			// db=context.
			this.db = getWritableDatabase();

		}
	}

	private SQLiteDatabase db;

	private static final String DB_NAME = "DairyDb";

	private static final int DB_VERSION = 1;

	private Context context;

	private final String LOGIN_TBL = "login_tbl";
	private final String DAIRY_TBL = "dairy_tbl";

	public boolean isDbOpen() {
		return db.isOpen();
	}

	*//**
	 * Insert into category
	 * *//*
	*//*
	 * public void insertCategory(String cat_id, String title, String date,
	 * String status) { String query = "insert into " + CATEGORY_TBL +
	 * " (cat_id,title,date,status)" + " values ('" + cat_id + "','" + title +
	 * "','" + date + "','" + status + "')"; System.out.println("query" +
	 * query); db.execSQL(query); }
	 *//*

	public void insertInfo(String id, String username, String password,
						   String email) {
		// for logging
		// Log.d("InsertDatabase", title);
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put("loginid", id);
		values.put("username", username);
		values.put("password", password);
		values.put("email", email);

		// 3. insert
		db.insert(LOGIN_TBL, null, values);
		// 4. close
		db.close();
	}

	public void insertInfoDairy(String name, String title, String date,
								String description) {
		// for logging
		// Log.d("InsertDatabase", title);
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("title", title);
		values.put("date", date);
		values.put("description", description);

		// 3. insert
		db.insert(DAIRY_TBL, null, values);
		// 4. close
		// db.close();
	}

	public List<LoginModel> GetAllWhereUsername(String useranme) {
		List<LoginModel> myCategories = new ArrayList<LoginModel>();
		// String query = "SELECT * FROM " + QUIZ_TBL + "";
		String query = "SELECT * FROM " + LOGIN_TBL + " WHERE username='"
				+ useranme + "'";
		Cursor cursor = db.rawQuery(query, null);
		System.out.println("query " + cursor);
		cursor.move(-1);
		while (cursor.moveToNext()) {

			LoginModel login = new LoginModel();
			Log.i("iN", "iNFO");

			String loginid = cursor.getString(0);
			String username = cursor.getString(1);
			String password = cursor.getString(2);
			String email = cursor.getString(3);

			login.setLoginId(loginid);
			login.setUseranme(username);
			login.setPassword(password);
			login.setEmail(email);

			myCategories.add(login);

		}
		cursor.close();
		return myCategories;
	}

	public List<LoginModel> GetAllWhereAll() {
		List<LoginModel> myCategories = new ArrayList<LoginModel>();
		// String query = "SELECT * FROM " + QUIZ_TBL + "";
		String query = "select *  from " + LOGIN_TBL + "";
		Cursor cursor = db.rawQuery(query, null);
		System.out.println("query " + cursor);
		cursor.move(-1);
		while (cursor.moveToNext()) {

			LoginModel login = new LoginModel();
			Log.i("iN", "iNFO");

			String loginid = cursor.getString(0);
			String username = cursor.getString(1);
			String password = cursor.getString(2);
			String email = cursor.getString(3);

			login.setLoginId(loginid);
			login.setUseranme(username);
			login.setPassword(password);
			login.setEmail(email);

			myCategories.add(login);

		}
		cursor.close();
		return myCategories;
	}

	public List<String> GetAllWhereDairy(String useranme) {
		List<String> myCategories = new ArrayList<String>();
		// String query = "SELECT * FROM " + QUIZ_TBL + "";
		String query = "SELECT title FROM " + DAIRY_TBL + " WHERE name='"
				+ useranme + "'";
		Cursor cursor = db.rawQuery(query, null);
		System.out.println("query " + cursor);
		cursor.move(-1);
		while (cursor.moveToNext()) {

			Log.i("iN", "iNFO");

			String loginid = cursor.getString(0);

			myCategories.add(loginid);

		}
		// cursor.close();
		return myCategories;
	}

	public List<String> GetAllWhereDairyDetails(String useranme) {
		List<String> myCategories = new ArrayList<String>();
		// String query = "SELECT * FROM " + QUIZ_TBL + "";
		String query = "SELECT title,description FROM " + DAIRY_TBL + " WHERE name='"
				+ useranme + "'";
		Cursor cursor = db.rawQuery(query, null);
		System.out.println("query " + cursor);
		cursor.move(-1);
		while (cursor.moveToNext()) {

			Log.i("iN", "iNFO");

			String loginid = cursor.getString(0);
			String des = cursor.getString(1);

			myCategories.add(loginid);
			myCategories.add(des);

		}
		// cursor.close();
		return myCategories;
	}

	public List<String> GetAllWhereDairyTitle(String title) {
		List<String> myCategories = new ArrayList<String>();
		// String query = "SELECT * FROM " + QUIZ_TBL + "";
		String query = "SELECT * FROM " + DAIRY_TBL + " WHERE title='" + title
				+ "'";
		Cursor cursor = db.rawQuery(query, null);
		System.out.println("query " + cursor);
		cursor.move(-1);
		while (cursor.moveToNext()) {

			Log.i("iN", "iNFO");

			String loginid = cursor.getString(0);
			String titles = cursor.getString(1);
			String date = cursor.getString(2);
			String desc = cursor.getString(3);

			myCategories.add(loginid);
			myCategories.add(titles);
			myCategories.add(date);
			myCategories.add(desc);

		}
		// cursor.close();
		return myCategories;
	}

	public List<String> GetEmail(String username) {
		List<String> myCategories = new ArrayList<String>();

		String query = "SELECT email FROM " + LOGIN_TBL + " WHERE username='" + username
				+ "'";

		Cursor cursor = db.rawQuery(query, null);

		cursor.move(-1);
		while (cursor.moveToNext()) {
			// String category ;
			Log.i("iN", "iNFO");
			String category = cursor.getString(0);

			myCategories.add(category);

		}

		cursor.close();

		return myCategories;

	}

	public int updatequiz(String oldname, String name, String title, String date,
						  String description) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("title", title);
		values.put("date", date);
		values.put("description", description);


		String[] where = { oldname };
		int count = db.update(DAIRY_TBL, values, "title" + " =? ", where);
		System.out.println("count " + count);
		return count;
	}

	public void delete(String id) {

		SQLiteDatabase db = this.getWritableDatabase();
		// db.delete("quiz_tbl", "option1", new String[] {id});
		int count = db.delete("quiz_tbl", "quizid" + "=" + id, null);

		System.out.println("marr" + count);

	}

	public List<String> GetAllInfo() {
		List<String> myCategories = new ArrayList<String>();

		String query = "select *  from " + LOGIN_TBL + "";

		Cursor cursor = db.rawQuery(query, null);

		cursor.move(-1);
		while (cursor.moveToNext()) {
			// String category ;
			Log.i("iN", "iNFO");
			String category = cursor.getString(1);

			myCategories.add(category);

		}

		cursor.close();

		return myCategories;

	}

	public void closeDb() {
		db.close();
	}

	// Constructor to simplify Business logic access to the repository

	@Override
	public void onCreate(SQLiteDatabase db) {
		this.db = db;
		createDataBase();

	}

	*//**
	 * Create Database
	 *//*

	private void createDataBase() {

		// Log.i("DB:", "created");

		db.execSQL("CREATE TABLE IF NOT EXISTS android_metadata ('locale' TEXT DEFAULT 'en_US')");

		db.execSQL("CREATE TABLE IF NOT EXISTS " + LOGIN_TBL
				+ "(loginid TEXT PRIMARY KEY NOT NULL , "
				+ "username TEXT NOT NULL , " + "password TEXT NOT NULL , "
				+ "email TEXT NOT NULL);");

		db.execSQL("CREATE TABLE IF NOT EXISTS " + DAIRY_TBL
				+ "(name TEXT NOT NULL , " + "title TEXT NOT NULL , "
				+ "date TEXT NOT NULL , " + "description TEXT NOT NULL);");

	}

	*//*
	 * public void droptable() { db.delete(CATEGORY_TBL, null, null); }
	 *//*

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

}*/

