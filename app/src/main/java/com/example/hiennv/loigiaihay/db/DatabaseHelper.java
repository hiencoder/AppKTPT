package com.example.hiennv.loigiaihay.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hiennv.loigiaihay.utils.AppConstants;


public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, AppConstants.DATABASE_NAME, null, AppConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*String createTableSave = "CREATE TABLE " + AppConstants.TABLE_SAVE + "(" +
        AppConstants.SAVE_ID + " INTEGER PRIMARY KEY, " +
        AppConstants.SAVE_NAME + " TEXT NOT NULL, " +
        AppConstants.SAVE_INTRO + " TEXT NOT NULL, " +
        AppConstants.S*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
