package com.example.hiennv.loigiaihay.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    protected abstract int getLayoutId();

    protected abstract void initData();

    protected SharedPrefUtils sharedPrefUtils;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }
}
