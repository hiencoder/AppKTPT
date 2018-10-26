package com.example.hiennv.loigiaihay.ui.home;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.ui.base.BaseFragment;

public class FragmentHome extends BaseFragment {
    public static FragmentHome newInstance() {
        FragmentHome fragmentHome = new FragmentHome();

        return fragmentHome;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

    }
}
