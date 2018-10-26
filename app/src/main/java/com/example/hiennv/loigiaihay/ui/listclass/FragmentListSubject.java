package com.example.hiennv.loigiaihay.ui.listclass;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.SubjectAdapter;
import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.subject.SubjectResponse;
import com.example.hiennv.loigiaihay.ui.base.BaseFragment;
import com.example.hiennv.loigiaihay.ui.listclass.listsubject.ListSubjectContract;
import com.example.hiennv.loigiaihay.ui.listclass.listsubject.ListSubjectPresenterImpl;
import com.example.hiennv.loigiaihay.utils.AppLogger;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import butterknife.BindView;
import butterknife.OnClick;

public class FragmentListSubject extends BaseFragment implements ListSubjectContract.ListSubjectView {
    private static final String TAG = FragmentListSubject.class.getSimpleName();
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.vp_choose_subject)
    ViewPager vpChooseSubject;
    @BindView(R.id.tpi_choose_subject)
    TabPageIndicator tpiChooseSubject;

    private SubjectAdapter subjectAdapter;
    private ApiService apiService;
    private SubjectResponse subjectResponse;
    private ListSubjectPresenterImpl subjectPresenter;
    private String tagId;

    public static FragmentListSubject newInstance(String tagId) {
        FragmentListSubject fragmentListSubject = new FragmentListSubject();

        return fragmentListSubject;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list_subject;
    }

    @Override
    protected void initData() {
        tagId = getArguments().getString("tagId");
        AppLogger.i("TagId", tagId);
        Log.d("TagId", tagId);
        apiService = ApiClient.getClient().create(ApiService.class);
        subjectPresenter = new ListSubjectPresenterImpl(this, apiService);
        subjectPresenter.loadListSubject(tagId);
    }

    @Override
    public void loadListSubjectSuccess(SubjectResponse subjectResponse) {
        if (subjectResponse != null) {
            subjectAdapter = new SubjectAdapter(getFragmentManager(), getActivity(), subjectResponse);
            //subjectAdapter = new SubjectAdapter(getFragmentManager());
            vpChooseSubject.setAdapter(subjectAdapter);
            vpChooseSubject.setOffscreenPageLimit(2);
            tpiChooseSubject.setViewPager(vpChooseSubject);
            tpiChooseSubject.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("", "onActivityCreated: ");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
    void doClick(View v){
        switch (v.getId()){
            case R.id.btn_back:
                getActivity().onBackPressed();
                break;
        }
    }
}
