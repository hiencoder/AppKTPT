package com.example.hiennv.loigiaihay.ui.search;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.network.pojo.search.ArticleSearch;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.customview.MyAutoCompleteTextView;
import com.example.hiennv.loigiaihay.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.grantland.widget.AutofitTextView;

public class SearchActivity extends BaseActivity implements SearchContract.SearchView {
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
    @BindView(R.id.mact_search_result)
    MyAutoCompleteTextView mactSearchResult;
    @BindView(R.id.tv_title_search)
    TextView tvTitleSearch;
    @BindView(R.id.rv_articles)
    RecyclerView rvArticles;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.line_2)
    View line2;
    @BindView(R.id.btn_see_more)
    TextView btnSeeMore;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    private int catId;
    private String keyWord;
    private int page = 1;
    private SearchPresenterImpl searchPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initData() {
        //Lấy catId từ shared
        catId = sharedPrefUtils.getInt(AppConstants.KEY_SUBJECT_ID, 0);
        
    }

    @Override
    protected void setUpToolbar() {
        ivDrop.setVisibility(View.INVISIBLE);
        ivSearch.setVisibility(View.INVISIBLE);
        btnBack.setVisibility(View.VISIBLE);
        atvTitle.setText(getResources().getString(R.string.txt_search));
        atvTitle.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initEvents() {

    }


    @OnClick({R.id.btn_back, R.id.btn_see_more})
    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_see_more:
                handSeeMore();
                break;
        }
    }

    //Xử lý xem thêm
    private void handSeeMore() {
        //Tang page
        page += 1;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void searchArticleSuccess(List<ArticleSearch> articleSearches) {

    }

    @Override
    public void searchArticleError() {

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
