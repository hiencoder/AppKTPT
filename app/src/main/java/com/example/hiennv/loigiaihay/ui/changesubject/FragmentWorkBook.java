package com.example.hiennv.loigiaihay.ui.changesubject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.BookAdapter;
import com.example.hiennv.loigiaihay.callback.ItemSubjectListener;
import com.example.hiennv.loigiaihay.network.pojo.subject.Subject;
import com.example.hiennv.loigiaihay.ui.base.BaseFragment;
import com.example.hiennv.loigiaihay.ui.home.MainActivity;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;

public class FragmentWorkBook extends BaseFragment implements ItemSubjectListener {
    @BindView(R.id.rv_workbooks)
    RecyclerView rvWorkbooks;
    private BookAdapter bookAdapter;
    private List<Subject> subjects;

    public static FragmentWorkBook newInstance(List<Subject> subjects) {
        FragmentWorkBook fragmentWorkBook = new FragmentWorkBook();
        Bundle bundle = new Bundle();
        bundle.putSerializable("sbt", (Serializable) subjects);
        fragmentWorkBook.setArguments(bundle);
        return fragmentWorkBook;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            subjects = (List<Subject>) bundle.getSerializable("sbt");
        }
        sharedPrefUtils = new SharedPrefUtils(getActivity());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_book;
    }

    @Override
    protected void initData() {
        bookAdapter = new BookAdapter(getActivity(), subjects, this);
        rvWorkbooks.setHasFixedSize(false);
        rvWorkbooks.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rvWorkbooks.setAdapter(bookAdapter);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void subjectClick(Subject subject) {
        //Save subject
        sharedPrefUtils.putString(AppConstants.KEY_SUBJECT_ID, String.valueOf(subject.getItemId()));
        sharedPrefUtils.putString(AppConstants.KEY_SUBJECT_TITLE,subject.getTitle());
        //Open MainActivity
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
