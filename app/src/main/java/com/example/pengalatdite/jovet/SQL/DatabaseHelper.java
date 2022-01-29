package com.example.pengalatdite.jovet.SQL;

import static com.example.pengalatdite.jovet.AddBookingContract.BookingEntry.TABLE_NAME;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "Databasehelper";
    public static final String DATABASE_NAME = "Jovet.db";
//    public static final String TABLE_NAME = "booking_table";
//    public static final String COL_1 = "ID";
//    public static final String COL_2 = "DATE";
//    public static final String COL_3 = "TIME";
//    public static final String COL_4 = "timestamp";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE STRING NOT NULL, TIME STRING NOT NULL, TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
//                ");");
//        final String SQL_CREATE_BOOKING_TABLE = "CREATE TABLE " +
//                TABLE_NAME + " (";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

//    public boolean insertData(String date, String time) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_2, date);
//        contentValues.put(COL_3, time);
//
//        Log.d(TAG, "insertData: Adding " + date + " and " + time + " to " + TABLE_NAME);
//
//        long result = db.insert(TABLE_NAME, null, contentValues);
//        if (result == -1)
//            return false;
//        else
//            return true;
//
//    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = getReadableDatabase().rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

}
