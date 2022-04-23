package com.example.macroeconomicfoodsecurity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import android.database.Cursor;
public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "mefsdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME_GDBPERCENT = "gdp_percent";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String YEAR = "year";

    // below variable id for our course duration column.
    private static final String CHINA_COUNTRY = "china";

    // below variable for our course description column.
    private static final String India_COUNTRY = "india";

    // below variable is for our course tracks column.
    private static final String USA_COUNTRY = "usa";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {

        super(context, "macroeconmics", null, 1);
        Log.e("mm", "create database");
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME_GDBPERCENT + " ("
                + YEAR + " TEXT, "
                + India_COUNTRY + " TEXT,"
                + CHINA_COUNTRY + " TEXT,"

                + USA_COUNTRY + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    public ArrayList<Model> readGDPPercentages() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME_GDBPERCENT
                , null);

        // on below line we are creating a new array list.
        ArrayList<Model> courseModalArrayList = new ArrayList<Model>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new Model(cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }
    // this method is use to add new course to our sqlite database.
    public void addNewGDPPercent(String year, String india, String china, String usa) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(YEAR, year);
        values.put(India_COUNTRY, india);
        values.put(CHINA_COUNTRY, china);
        values.put(USA_COUNTRY, usa);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME_GDBPERCENT, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_GDBPERCENT);
        onCreate(db);
    }
}
