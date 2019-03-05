package com.example.hiennv.loigiaihay.ui.articledetail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.network.pojo.event.Article;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.customview.MyAutoCompleteTextView;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.grantland.widget.AutofitTextView;
import timber.log.Timber;

public class ArticleDetailActivity extends BaseActivity implements ArticleDetailContract.ArticleDetailView {

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
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    private int itemId;
    private ArticleDetailPresenterImpl articleDetailPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_detail;
    }

    @Override
    protected void initData() {
        setSupportActionBar(toolbar);
        ivSearch.setVisibility(View.GONE);
        itemId = getIntent().getIntExtra(AppConstants.KEY_ARTICLE_ID, 0);
        Timber.i("%s", "ItemId: " + itemId);
        articleDetailPresenter = new ArticleDetailPresenterImpl(this);
        articleDetailPresenter.loadArticleDetail(itemId);
    }

    @Override
    protected void setUpToolbar() {
        setSupportActionBar(toolbar);
        ivSearch.setVisibility(View.INVISIBLE);
        sharedPrefUtils = new SharedPrefUtils(this);
        String subjectName = sharedPrefUtils.getString(AppConstants.KEY_SUBJECT_TITLE, "");
        atvTitle.setText(subjectName);
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

    @OnClick({R.id.atv_title, R.id.iv_drop, R.id.iv_search, R.id.btn_back})
    public void doClick(View view) {
        switch (view.getId()) {
            case R.id.atv_title:
                break;
            case R.id.iv_drop:
                break;
            case R.id.iv_search:
                break;
            case R.id.btn_back:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void loadArticleDetailSuccess(Article article) {

    }

    @Override
    public void loadArticleDetailError(String message) {

    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }


}
