package com.example.hiennv.loigiaihay.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hiennv.loigiaihay.db.model.History;
import com.example.hiennv.loigiaihay.db.model.Save;
import com.example.hiennv.loigiaihay.db.model.Search;
import com.example.hiennv.loigiaihay.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;


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
     * Insert new search to database
     *
     * @param search
     * @return true if insert success or false otherwise
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
        return result != 0;
    }

    /**
     * @return List search in database
     */
    public List<Search> getAllSearch() {
        List<Search> list = new ArrayList<>();
        String query = "SELECT * FROM " + AppConstants.TABLE_SEARCH;
        Cursor cursor = database.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(AppConstants.SEARCH_ID));
                String subjectId = cursor.getString(cursor.getColumnIndex(AppConstants.SEARCH_SUBJECT_ID));
                String subjectType = cursor.getString(cursor.getColumnIndex(AppConstants.SEARCH_SUBJECT_TYPE));
                String articleId = cursor.getString(cursor.getColumnIndex(AppConstants.SEARCH_ARTICLE_ID));
                String nameText = cursor.getString(cursor.getColumnIndex(AppConstants.SEARCH_NAME_TEXT));
                String nameNotSigned = cursor.getString(cursor.getColumnIndex(AppConstants.SEARCH_NAME_NOT_SIGNED));
                String searchLink = cursor.getString(cursor.getColumnIndex(AppConstants.SEARCH_IS_LINK));
                String searchDirectLink = cursor.getString(cursor.getColumnIndex(AppConstants.SEARCH_REDIRECT_LINK));

                Search search = new Search(id, subjectId, subjectType, articleId, nameText, nameNotSigned, searchLink, searchDirectLink);
                list.add(search);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return list;
    }

    /**
     * Insert new
     *
     * @param save
     * @return
     */
    public boolean insertSave(Save save) {
        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(AppConstants.SAVE_ID, save.getSaveId());
        values.put(AppConstants.SAVE_ARTICLE_ID, save.getSaveArticleId());
        values.put(AppConstants.SAVE_BODY, save.getSaveBody());
        values.put(AppConstants.SAVE_NAME, save.getSaveName());
        values.put(AppConstants.SAVE_INTRO, save.getSaveIntro());
        values.put(AppConstants.SAVE_URL, save.getSaveUrl());
        long result = database.insert(AppConstants.TABLE_SAVE, null, values);
        return (result > 0);
    }

    /**
     * @return list save in database
     */
    public List<Save> getAllSave() {
        database = this.getReadableDatabase();
        List<Save> saves = new ArrayList<>();
        String query = "SELECT * FROM " + AppConstants.TABLE_SAVE;
        Cursor cursor = database.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(AppConstants.SAVE_ID));
                String name = cursor.getString(cursor.getColumnIndex(AppConstants.SAVE_NAME));
                String intro = cursor.getString(cursor.getColumnIndex(AppConstants.SAVE_INTRO));
                String body = cursor.getString(cursor.getColumnIndex(AppConstants.SAVE_BODY));
                String url = cursor.getString(cursor.getColumnIndex(AppConstants.SAVE_URL));
                String articleId = cursor.getString(cursor.getColumnIndex(AppConstants.SAVE_ARTICLE_ID));

                saves.add(new Save(id, name, intro, body, url, articleId));

                cursor.moveToNext();
            }
        }
        cursor.close();
        return saves;
    }

    /**
     * @param id
     * @return
     */
    public boolean deleteSaveById(int id) {
        database = this.getWritableDatabase();
        int result = database.delete(AppConstants.TABLE_SAVE, AppConstants.SAVE_ID + "=?", new String[]{String.valueOf(id)});
        return result > 0;
    }

    /**
     * Get save by id
     *
     * @param id
     * @return
     */
    public Save getSaveById(int id) {
        database = this.getReadableDatabase();
        Save save = null;
        String query = "SELECT * FROM " + AppConstants.TABLE_SAVE + " WHERE " + AppConstants.SAVE_ID + " ='" + id + "'";
        Cursor cursor = database.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex(AppConstants.SAVE_NAME));
                String intro = cursor.getString(cursor.getColumnIndex(AppConstants.SAVE_INTRO));
                String body = cursor.getString(cursor.getColumnIndex(AppConstants.SAVE_BODY));
                String url = cursor.getString(cursor.getColumnIndex(AppConstants.SAVE_URL));
                String articleId = cursor.getString(cursor.getColumnIndex(AppConstants.SAVE_ARTICLE_ID));
                save = new Save(id, name, intro, body, url, articleId);
                cursor.moveToNext();
            }
        }
        return save;
    }

    //Count lessons saved
    public int countSave() {
        database = this.getReadableDatabase();
        String query = "SELECT * FROM " + AppConstants.TABLE_SAVE;
        Cursor cursor = database.rawQuery(query, null);
        return cursor.getCount();
    }


    /**
     * Delete all save
     *
     * @return
     */
    public void deleteAllSave() {
        database = this.getWritableDatabase();
        String delete = "DELETE FROM " + AppConstants.TABLE_SAVE;
        database.execSQL(delete);
    }

    /**
     * @param articleId
     * @return
     */
    public boolean checkLessonDownload(String articleId) {
        database = this.getReadableDatabase();
        String query = "SELECT * FROM " + AppConstants.TABLE_SAVE + " WHERE " + AppConstants.SAVE_ARTICLE_ID + " ='" + articleId + "'";
        Cursor cursor = database.rawQuery(query, null);
        return cursor.getCount() > 0;
    }

    /**
     * @param history
     * @return
     */
    public boolean insertHistory(History history) {
        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AppConstants.HISTORY_NAME, history.getHistoryName());
        values.put(AppConstants.HISTORY_INTRO, history.getHistoryIntro());
        values.put(AppConstants.HISTORY_AVATAR, history.getHistoryAvatar());
        values.put(AppConstants.HISTORY_ARTICLE_ID, history.getHistoryArticleId());
        values.put(AppConstants.HISTORY_URL, history.getHistoryUrl());
        long result = database.insert(AppConstants.TABLE_HISTORY, null, values);
        Timber.i("Insert history: %s", result);
        return result > 0;
    }

    /**
     * @return
     */
    public List<History> getAllHistory() {
        database = this.getReadableDatabase();
        List<History> histories = new ArrayList<>();
        String query = "SELECT * FROM " + AppConstants.TABLE_HISTORY;
        Cursor cursor = database.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(AppConstants.HISTORY_ID));
                String name = cursor.getString(cursor.getColumnIndex(AppConstants.HISTORY_NAME));
                String intro = cursor.getString(cursor.getColumnIndex(AppConstants.HISTORY_INTRO));
                String avatar = cursor.getString(cursor.getColumnIndex(AppConstants.HISTORY_AVATAR));
                String url = cursor.getString(cursor.getColumnIndex(AppConstants.HISTORY_URL));
                String articleId = cursor.getString(cursor.getColumnIndex(AppConstants.HISTORY_ARTICLE_ID));

                histories.add(new History(id, name, intro, avatar, url, articleId));

                cursor.moveToNext();
            }
        }
        cursor.close();
        return histories;
    }

    /**
     * @param articleId
     * @return
     */
    public boolean checkHistoryByArticleId(String articleId) {
        database = this.getReadableDatabase();
        String query = "SELECT * FROM " + AppConstants.TABLE_HISTORY + " WHERE " + AppConstants.HISTORY_ARTICLE_ID + " ='" + articleId + "'";
        Cursor cursor = database.rawQuery(query, null);
        return cursor.getCount() > 0;
    }

    //Delete all history
    public void deleteAllHistory() {
        database = this.getWritableDatabase();
        String query = "DELETE FROM " + AppConstants.TABLE_HISTORY;
        database.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
