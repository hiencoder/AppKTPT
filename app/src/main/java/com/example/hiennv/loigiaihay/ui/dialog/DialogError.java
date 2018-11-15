package com.example.hiennv.loigiaihay.ui.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class DialogError extends DialogFragment {
    public static DialogError newInstance() {
        DialogError dialogError = new DialogError();

        return dialogError;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
