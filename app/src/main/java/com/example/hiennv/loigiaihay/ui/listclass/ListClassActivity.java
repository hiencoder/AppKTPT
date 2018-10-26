package com.example.hiennv.loigiaihay.ui.listclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.home.MainActivity;

public class ListClassActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list_class;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
