package com.example.hiennv.loigiaihay.ui.history;

import android.content.Context;

import com.example.hiennv.loigiaihay.db.DatabaseHelper;

public class HistoryPresenterImpl implements HistoryContract.HistoryPresenter {
    private HistoryContract.HistoryView view;
    private DatabaseHelper databaseHelper;

    public HistoryPresenterImpl(Context context, HistoryContract.HistoryView view) {
        databaseHelper = new DatabaseHelper(context);
        this.view = view;
    }

    @Override
    public void getAllHistory() {

    }

    @Override
    public void deleteAllHistory() {

    }
}
