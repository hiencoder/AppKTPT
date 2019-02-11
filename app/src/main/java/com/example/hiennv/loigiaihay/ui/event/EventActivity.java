package com.example.hiennv.loigiaihay.ui.event;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.network.pojo.event.ResponseEvent;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;

public class EventActivity extends BaseActivity implements EventContract.EventView {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_event_detail;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setUpToolbar() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void loadEventSuccess(ResponseEvent event) {

    }

    @Override
    public void loadEventError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
