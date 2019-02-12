package com.example.hiennv.loigiaihay.ui.changeclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.ListClassAdapter;
import com.example.hiennv.loigiaihay.callback.ItemClassListener;
import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.tag.ClassEntity;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.changesubject.ChangeSubjectActivity;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangeClassActivity extends BaseActivity implements ChangeClassContract.ChangeClassView, ItemClassListener {
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.rv_list_class)
    RecyclerView rvListClass;
    @BindView(R.id.btn_back)
    ImageView btnBack;

    private ApiService apiService;
    private ChangeClassPresenterImpl listClassPresenter;
    private List<ClassEntity> listClass;
    private ListClassAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_class;
    }

    @Override
    protected void initData() {
        sharedPrefUtils = new SharedPrefUtils(this);
        listClass = new ArrayList<>();
        apiService = ApiClient.getClient().create(ApiService.class);
        listClassPresenter = new ChangeClassPresenterImpl(this, apiService);
        listClassPresenter.loadListClass();
    }

    @Override
    protected void setUpToolbar() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void loadSuccess(List<ClassEntity> list) {
        if (list != null && list.size() > 0) {
            listClass.addAll(list);
            adapter = new ListClassAdapter(this, listClass, this::classClick);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            rvListClass.setHasFixedSize(true);
            rvListClass.setLayoutManager(gridLayoutManager);
            rvListClass.setAdapter(adapter);
        }
    }

    @Override
    public void loadError() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void classClick(ClassEntity classEntity) {
        sharedPrefUtils.putString(AppConstants.KEY_CLASS_ID,classEntity.getTagId());
        sharedPrefUtils.putString(AppConstants.KEY_CLASS_TITLE,classEntity.getTitle());
        //Put classEntity -> ChangeSubjectActivity
        /*Bundle bundle = new Bundle();
        bundle.putSerializable("class_entity",classEntity);*/
        Intent intent = new Intent(this, ChangeSubjectActivity.class);
        intent.putExtra("class_entity",classEntity);
        startActivity(intent);
    }

    @OnClick(R.id.btn_back)
    void doClick(View v){
        switch (v.getId()){
            case R.id.btn_back:
                //Open MainActivity
                break;
        }
    }
}
