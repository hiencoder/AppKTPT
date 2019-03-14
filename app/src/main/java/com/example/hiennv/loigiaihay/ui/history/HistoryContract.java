package com.example.hiennv.loigiaihay.ui.history;

import com.example.hiennv.loigiaihay.db.model.History;

import java.util.List;

public interface HistoryContract {
    interface HistoryView {
        void getAllHistory(List<History> histories);

        void getAllHistoryError();

        void deleteAllHistorySuccess();

        void deleteAllHistoryError();
    }

    interface HistoryPresenter {
        void getAllHistory();

        void deleteAllHistory();
    }
}
