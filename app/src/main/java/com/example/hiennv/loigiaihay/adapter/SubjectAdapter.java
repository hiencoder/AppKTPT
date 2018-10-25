package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hiennv.loigiaihay.network.pojo.subject.SubjectResponse;
import com.example.hiennv.loigiaihay.ui.listclass.listsubject.FragmentTextBook;
import com.example.hiennv.loigiaihay.ui.listclass.listsubject.FragmentWorkBook;

public class SubjectAdapter extends FragmentStatePagerAdapter{
    private Context context;
    private SubjectResponse subjectResponse;

    public SubjectAdapter(FragmentManager fm, Context context, SubjectResponse subjectResponse) {
        super(fm);
        this.context = context;
        this.subjectResponse = subjectResponse;
    }

    public SubjectAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FragmentTextBook();
                break;
            case 1:
                fragment = new FragmentWorkBook();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return subjectResponse.getListData().size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title =  subjectResponse.getListData().get(0).getTitle();
                break;
            case 1:
                title = subjectResponse.getListData().get(1).getTitle();
                break;
        }
        return title;
    }
}
