package com.tp.pals.databasepractise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pallav.choudhary on 03-07-2017.
 */

public class DatabaseActivity extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "empDB.db";
    public static final String TABLE_EMP = "emp";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMPNAME = "empname";
    public static final String COLUMN_EMPEMAIL = "empemail";

    public DatabaseActivity(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_EMP + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMPNAME + " TEXT, " + COLUMN_EMPEMAIL + " TEXT " + ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EMP);
        onCreate(sqLiteDatabase);
    }

    public void addEmp(Employee emp){
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMPNAME, emp.getEmpName());
        values.put(COLUMN_EMPEMAIL, emp.getEmpEmail());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_EMP, null, values);
        db.close();
    }

    public void deleteEmp(String empID){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_EMP + " WHERE " + COLUMN_ID + "=\"" + empID + "\";");
    }

    public String databasetoString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EMP + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("empname"))!=null || c.getString(c.getColumnIndex("empemail"))!=null){
                dbString += c.getString(c.getColumnIndex("_id"));
                dbString += " ";
                dbString += c.getString(c.getColumnIndex("empname"));
                dbString += " ";
                dbString += c.getString(c.getColumnIndex("empemail"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
