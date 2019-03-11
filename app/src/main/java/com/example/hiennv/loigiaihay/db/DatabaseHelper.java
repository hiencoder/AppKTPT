package com.example.hiennv.loigiaihay.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hiennv.loigiaihay.db.model.Save;
import com.example.hiennv.loigiaihay.db.model.Search;
import com.example.hiennv.loigiaihay.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        super(context, AppConstants.DATABASE_NAME, null, AppConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSearch = "CREATE TABLE " + AppConstants.TABLE_SEARCH + "(" +
                AppConstants.SEARCH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AppConstants.SEARCH_SUBJECT_ID + " TEXT, " +
                AppConstants.SEARCH_SUBJECT_TYPE + " TEXT, " +
                AppConstants.SEARCH_NAME_TEXT + " TEXT, " +
                AppConstants.SEARCH_NAME_NOT_SIGNED + " TEXT, " +
                AppConstants.SEARCH_ARTICLE_ID + " TEXT, " +
                AppConstants.SEARCH_IS_LINK + " TEXT, " +
                AppConstants.SEARCH_REDIRECT_LINK + " TEXT);";

        String createTableSave = "CREATE TABLE " + AppConstants.TABLE_SAVE + "(" +
                AppConstants.SAVE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AppConstants.SAVE_NAME + " TEXT NOT NULL, " +
                AppConstants.SAVE_INTRO + " TEXT NOT NULL, " +
                AppConstants.SAVE_BODY + " TEXT NOT NULL, " +
                AppConstants.SAVE_URL + " TEXT NOT NULL, " +
                AppConstants.SAVE_ARTICLE_ID + " TEXT NOT NULL);";

        String createTableHistory = "CREATE TABLE " + AppConstants.TABLE_HISTORY + "(" +
                AppConstants.HISTORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AppConstants.HISTORY_NAME + " TEXT NOT NULL, " +
                AppConstants.HISTORY_INTRO + " TEXT NOT NULL, " +
                AppConstants.HISTORY_AVATAR + " TEXT NOT NULL, " +
                AppConstants.HISTORY_URL + " TEXT NOT NULL, " +
                AppConstants.HISTORY_ARTICLE_ID + " TEXT NOT NULL);";

        String createTableNotify = "CREATE TABLE " + AppConstants.TABLE_NOTIFICATION + "(" +
                AppConstants.NOTIFICATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AppConstants.NOTIFICATION_TITLE + " TEXT NOT NULL, " +
                AppConstants.NOTIFICATION_CONTENT + " TEXT NOT NULL, " +
                AppConstants.NOTIFICATION_URL + " TEXT NOT NULL, " +
                AppConstants.NOTIFICATION_DATE + " TEXT NOT NULL, " +
                AppConstants.NOTIFICATION_STATUS + " TEXT NOT NULL);";

        String createTableTicked = "CREATE TABLE " + AppConstants.TABLE_TICKED + "(" +
                AppConstants.TICKED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AppConstants.TICKED_SUBJECT_ID + " TEXT NOT NULL, " +
                AppConstants.TICKED_SUBJECT_DOWNLOAD + " TEXT NOT NULL);";

        String createTableOrderId = "CREATE TABLE " + AppConstants.TABLE_ORDER_ID + "(" +
                AppConstants.ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AppConstants.ORDER_ID_NAME + " TEXT NOT NULL);";

        db.execSQL(createTableSearch);
        db.execSQL(createTableSave);
        db.execSQL(createTableHistory);
        db.execSQL(createTableNotify);
        db.execSQL(createTableTicked);
        db.execSQL(createTableOrderId);
    }

    public void open() {
        database = this.getWritableDatabase();
    }


    public void close() {
        database.close();
    }

    /**
     * @param search
     * @return
     */
    public boolean insertSearch(Search search) {
        this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AppConstants.SEARCH_ID, search.getSearchId());
        values.put(AppConstants.SEARCH_SUBJECT_ID, search.getSearchSubjectId());
        values.put(AppConstants.SEARCH_SUBJECT_TYPE, search.getSearchSubjectType());
        values.put(AppConstants.SEARCH_ARTICLE_ID, search.getSearchArticleId());
        values.put(AppConstants.SEARCH_IS_LINK, search.getSearchIsLink());
        values.put(AppConstants.SEARCH_NAME_TEXT, search.getSearchNameText());
        values.put(AppConstants.SEARCH_NAME_NOT_SIGNED, search.getSearchNameNotSigned());
        values.put(AppConstants.SEARCH_REDIRECT_LINK, search.getSearchRedirectLink());
        long result = database.insert(AppConstants.TABLE_SEARCH, null, values);
        return (result != 0) ? true : false;
    }

    /**
     * @return
     */
    public List<Search> getListSearch() {
        List<Search> list = new ArrayList<>();
        String query = "SELECT * FROM " + AppConstants.TABLE_SEARCH;

        return list;
    }

    /**
     * @param save
     * @return
     */
    public boolean insertSave(Save save) {
        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AppConstants.SAVE_ID, save.getSaveId());
        values.put(AppConstants.SAVE_ARTICLE_ID, save.getSaveArticleId());
        values.put(AppConstants.SAVE_BODY, save.getSaveBody());
        values.put(AppConstants.SAVE_NAME, save.getSaveName());
        values.put(AppConstants.SAVE_INTRO, save.getSaveIntro());
        values.put(AppConstants.SAVE_URL, save.getSaveUrl());
        long result = database.insert(AppConstants.TABLE_SAVE, null, values);
        return (result > 0);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
