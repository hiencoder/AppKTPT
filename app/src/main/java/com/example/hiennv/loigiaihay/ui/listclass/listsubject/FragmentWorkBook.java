package com.example.hiennv.loigiaihay.ui.listclass.listsubject;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.ui.base.BaseFragment;

public class FragmentWorkBook extends BaseFragment{
    public static FragmentWorkBook newInstance(){
        FragmentWorkBook fragmentWorkBook = new FragmentWorkBook();

        return fragmentWorkBook;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_book;
    }

    @Override
    protected void initData() {

    }
}
