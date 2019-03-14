package com.example.hiennv.loigiaihay.ui.history;

import android.content.Context;

import com.example.hiennv.loigiaihay.db.DatabaseHelper;
import com.example.hiennv.loigiaihay.db.model.History;

import java.util.List;

public class HistoryPresenterImpl implements HistoryContract.HistoryPresenter {
    private HistoryContract.HistoryView view;
    private DatabaseHelper databaseHelper;

    public HistoryPresenterImpl(Context context, HistoryContract.HistoryView view) {
        databaseHelper = new DatabaseHelper(context);
        this.view = view;
    }

    @Override
    public void getAllHistory() {
        List<History> list = databaseHelper.getAllHistory();
        if (list != null) {
            view.getAllHistory(list);
        } else {
            view.getAllHistoryError();
        }
    }

    @Override
    public void deleteAllHistory() {
        databaseHelper.deleteAllHistory();
        view.deleteAllHistorySuccess();

    }
}
