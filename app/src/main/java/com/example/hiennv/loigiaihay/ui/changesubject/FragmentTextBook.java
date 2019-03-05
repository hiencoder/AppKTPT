package com.example.hiennv.loigiaihay.ui.changesubject;

import android.content.Context;
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

public class FragmentTextBook extends BaseFragment implements ItemSubjectListener {
    @BindView(R.id.rv_textbooks)
    RecyclerView rvTextBooks;

    private List<Subject> subjects;
    private BookAdapter bookAdapter;

    public static FragmentTextBook newInstance(List<Subject> list) {
        FragmentTextBook fragmentTextBook = new FragmentTextBook();
        Bundle bundle = new Bundle();
        bundle.putSerializable("sgk", (Serializable) list);
        fragmentTextBook.setArguments(bundle);
        return fragmentTextBook;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            subjects = (List<Subject>) bundle.getSerializable("sgk");
        }
        sharedPrefUtils = new SharedPrefUtils(getActivity());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_text_book;
    }

    @Override
    protected void initData() {
        bookAdapter = new BookAdapter(getActivity(), subjects, this);
        rvTextBooks.setHasFixedSize(false);
        rvTextBooks.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rvTextBooks.setAdapter(bookAdapter);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
