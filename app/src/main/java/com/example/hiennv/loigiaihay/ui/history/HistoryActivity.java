package com.example.hiennv.loigiaihay.ui.history;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.callback.ItemArticleListener;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.customview.MyAutoCompleteTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.grantland.widget.AutofitTextView;

public class HistoryActivity extends BaseActivity implements ItemArticleListener {
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.atv_title)
    AutofitTextView atvTitle;
    @BindView(R.id.mact_search)
    MyAutoCompleteTextView mactSearch;
    @BindView(R.id.iv_drop)
    ImageView ivDrop;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_articles)
    RecyclerView rvArticles;
    @BindView(R.id.btn_delete)
    FloatingActionButton btnDelete;

    @Override
    public void doItemArticleClick(int articleId) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setUpToolbar() {
        setSupportActionBar(toolbar);

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.iv_drop, R.id.iv_search, R.id.btn_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.iv_drop:
                break;
            case R.id.iv_search:
                break;
            case R.id.btn_delete:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
