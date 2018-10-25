package com.example.hiennv.loigiaihay.ui.listclass;

import android.support.v4.view.ViewPager;
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

public class FragmentListSubject extends BaseFragment implements ListSubjectContract.ListSubjectView {
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.vp_choose_subject)
    ViewPager vpChooseSubject;
    @BindView(R.id.tpi_choose_subject)
    TitlePageIndicator tpiChooseSubject;

    private SubjectAdapter subjectAdapter;
    private ApiService apiService;
    private SubjectResponse subjectResponse;
    private ListSubjectPresenterImpl subjectPresenter;
    private String tagId;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list_subject;
    }

    @Override
    protected void initData() {
        tagId = getArguments().getString("tagId");
        AppLogger.i("TagId", tagId);
        apiService = ApiClient.getClient().create(ApiService.class);
        subjectPresenter = new ListSubjectPresenterImpl(this, apiService);
        subjectPresenter.loadListSubject(tagId);
    }

    @Override
    public void loadListSubjectSuccess(SubjectResponse subjectResponse) {
        if (subjectResponse != null) {
            subjectAdapter = new SubjectAdapter(getFragmentManager(),getActivity(),subjectResponse);
            vpChooseSubject.setAdapter(subjectAdapter);
            tpiChooseSubject.setViewPager(vpChooseSubject);
        }
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
}
