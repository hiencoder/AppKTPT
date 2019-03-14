package com.example.hiennv.loigiaihay.ui.changesubject;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.SubjectAdapter;
import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.subject.SubjectResponse;
import com.example.hiennv.loigiaihay.network.pojo.tag.ClassEntity;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;
import com.viewpagerindicator.TabPageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeSubjectActivity extends BaseActivity implements ChangeSubjectContract.ChangeSubjectView {
    private static final String TAG = ChangeSubjectActivity.class.getSimpleName();
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.vp_choose_subject)
    ViewPager vpChooseSubject;
    @BindView(R.id.tpi_choose_subject)
    TabPageIndicator tpiChooseSubject;

    private SubjectAdapter subjectAdapter;
    private ApiService apiService;
    private ChangeSubjectPresenterImpl changeSubjectPresenter;
    private String tagId;
    private ClassEntity classEntity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_subject;
    }

    @Override
    protected void initData() {
        sharedPrefUtils = new SharedPrefUtils(this);
        classEntity = (ClassEntity) getIntent().getSerializableExtra("class_entity");
        if (classEntity != null) {
            tagId = classEntity.getTagId();
        } else {
            tagId = sharedPrefUtils.getString(AppConstants.KEY_CLASS_ID, "");
        }

        changeSubjectPresenter = new ChangeSubjectPresenterImpl(this);
        changeSubjectPresenter.loadListSubject(tagId);
    }

    @Override
    protected void setUpToolbar() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void loadListSubjectSuccess(SubjectResponse subjectResponse) {
        if (subjectResponse != null) {
            subjectAdapter = new SubjectAdapter(getSupportFragmentManager(), this, subjectResponse);
            vpChooseSubject.setAdapter(subjectAdapter);
            vpChooseSubject.setOffscreenPageLimit(2);
            tpiChooseSubject.setViewPager(vpChooseSubject);
            tpiChooseSubject.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void loadListSubjectError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @OnClick(R.id.btn_back)
    public void doClick() {
        onBackPressed();
    }
}
