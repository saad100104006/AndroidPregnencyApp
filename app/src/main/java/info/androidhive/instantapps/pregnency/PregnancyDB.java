package info.androidhive.instantapps.pregnency;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
