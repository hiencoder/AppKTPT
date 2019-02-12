package com.example.hiennv.loigiaihay.ui.changesubject;


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

import java.sql.Time;

import butterknife.BindView;
import timber.log.Timber;

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
        Timber.d("TagId: %s", tagId);
        apiService = ApiClient.getClient().create(ApiService.class);
        changeSubjectPresenter = new ChangeSubjectPresenterImpl(this, apiService);
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
    public void loadListSubjectError(String message) {
        Timber.e("ChangeSubject: %s", message);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
