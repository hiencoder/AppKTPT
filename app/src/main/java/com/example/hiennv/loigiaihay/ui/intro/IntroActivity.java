package com.example.hiennv.loigiaihay.ui.intro;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.IntroAdapter;
import com.example.hiennv.loigiaihay.model.Intro;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

public class IntroActivity extends BaseActivity {
    @BindView(R.id.vp_intro)
    ViewPager vpIntro;
    @BindView(R.id.cpi_intro)
    CirclePageIndicator ciIntro;
    @BindView(R.id.btn_skip)
    TextView btnSkip;
    @BindView(R.id.btn_next)
    ImageView btnNext;

    private IntroAdapter introAdapter;
    private List<Intro> listIntro;

    private int pageSelected;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_intro;
    }

    @Override
    protected void initData() {
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);*/
    }

    @OnClick({R.id.btn_skip, R.id.btn_next})
    void doClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip:
                handleSkip();
                break;
            case R.id.btn_next:
                break;
        }
    }

    private void handleSkip() {

    }
}
