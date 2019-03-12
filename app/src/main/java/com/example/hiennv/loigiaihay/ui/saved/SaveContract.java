package com.example.hiennv.loigiaihay.ui.saved;

import com.example.hiennv.loigiaihay.db.model.Save;

import java.util.List;

public interface SaveContract {
    interface SaveView {
        void loadAllSaveSuccess(List<Save> saves);

        void loadAllSaveError();
    }

    interface SavePresenter {
        void loadAllSave();
    }
}
