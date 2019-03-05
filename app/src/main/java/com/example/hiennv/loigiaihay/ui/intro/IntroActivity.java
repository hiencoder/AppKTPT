package com.example.hiennv.loigiaihay.ui.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.IntroAdapter;
import com.example.hiennv.loigiaihay.model.Intro;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.changeclass.ChangeClassActivity;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class IntroActivity extends BaseActivity {
    @BindView(R.id.vp_intro)
    ViewPager vpIntro;
    @BindView(R.id.cpi_intro)
    CirclePageIndicator ciIntro;
    @BindView(R.id.btn_skip)
    TextView btnSkip;
    @BindView(R.id.btn_next)
    ImageView btnNext;
    @BindView(R.id.btn_ok)
    TextView btnOk;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private IntroAdapter introAdapter;
    private List<Intro> listIntro;

    private int pageSelected;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_intro;
    }

    @Override
    protected void initData() {
        sharedPrefUtils = new SharedPrefUtils(this);
        listIntro = new ArrayList<>();
        listIntro.add(new Intro("Chọn môn, lớp", R.drawable.manual_1));
        listIntro.add(new Intro("Tìm kiếm nhanh", R.drawable.manual_3));
        listIntro.add(new Intro("Lưu bài viết", R.drawable.manual_5));
        listIntro.add(new Intro("Chúc bạn học tập tốt", R.drawable.manual_1));
        pageSelected = 0;
        introAdapter = new IntroAdapter(this, listIntro);
        vpIntro.setCurrentItem(pageSelected);
        vpIntro.setAdapter(introAdapter);
        ciIntro.setViewPager(vpIntro);

        vpIntro.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageSelected = position;
                if (pageSelected == listIntro.size() - 1) {
                    btnNext.setVisibility(View.GONE);
                    btnOk.setVisibility(View.VISIBLE);
                } else {
                    btnNext.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.GONE);
                }
                sharedPrefUtils.putBoolean(AppConstants.IS_FIRST_LAUNCH, false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void setUpToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);*/
    }

    @OnClick({R.id.btn_skip, R.id.btn_next, R.id.btn_ok})
    void doClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip:
                handleSkip();
                break;
            case R.id.btn_next:
                handleNext();
                break;
            case R.id.btn_ok:
                handleSkip();
                break;
        }
    }

    private void handleNext() {
        if (pageSelected < listIntro.size() - 1) {
            pageSelected += 1;
            vpIntro.setCurrentItem(pageSelected);
        } else {
            btnNext.setVisibility(View.GONE);
            btnOk.setVisibility(View.VISIBLE);
        }
    }

    private void handleSkip() {
        //Save shared
        sharedPrefUtils.putBoolean(AppConstants.IS_FIRST_LAUNCH, false);
        startActivity(new Intent(this, ChangeClassActivity.class));
    }
}
