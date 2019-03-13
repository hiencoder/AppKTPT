package com.example.hiennv.loigiaihay.ui.saved;

import android.content.Context;

import com.example.hiennv.loigiaihay.db.DatabaseHelper;
import com.example.hiennv.loigiaihay.db.model.Save;

import java.util.List;

public class SavePresenterImpl implements SaveContract.SavePresenter {
    private SaveContract.SaveView saveView;
    private DatabaseHelper databaseHelper;

    public SavePresenterImpl(Context context, SaveContract.SaveView view) {
        databaseHelper = new DatabaseHelper(context);
        this.saveView = view;
    }

    @Override
    public void loadAllSave() {
        List<Save> saves = databaseHelper.getAllSave();
        if (saves != null && saves.size() > 0) {
            saveView.loadAllSaveSuccess(saves);
        } else {
            saveView.loadAllSaveError();
        }
    }

    @Override
    public void deleteSaveById(int id) {
        if (databaseHelper.deleteSaveById(id)){
            saveView.deleteSaveSuccess();
        }else {
            saveView.deleteSaveError();
        }
    }

    @Override
    public void deleteAllSave() {

        databaseHelper.deleteAllSave();

    }
}
