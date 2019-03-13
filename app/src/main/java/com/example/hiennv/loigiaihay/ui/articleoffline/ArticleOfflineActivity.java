package com.example.hiennv.loigiaihay.ui.articleoffline;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.db.model.Save;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.customview.MyAutoCompleteTextView;
import com.example.hiennv.loigiaihay.utils.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.kexanie.library.MathView;
import me.grantland.widget.AutofitTextView;
import timber.log.Timber;

public class ArticleOfflineActivity extends BaseActivity implements ArticleOfflineContract.ArticleOfflineView {
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
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_lesson_title)
    TextView tvLessonTitle;
    @BindView(R.id.tv_lesson_intro_text)
    TextView tvLessonIntroText;
    @BindView(R.id.mv_content)
    MathView mvContent;
    private Save saveSelected;
    private int saveIdSelected;
    private ArticleDetailOfflinePresenterImpl articleDetailOfflinePresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_offline;
    }

    @Override
    protected void initData() {
        saveIdSelected = getIntent().getIntExtra(AppConstants.KEY_ARTICLE_OFFLINE_ID, 0);
        articleDetailOfflinePresenter = new ArticleDetailOfflinePresenterImpl(this, this);
        articleDetailOfflinePresenter.loadArticleDetail(saveIdSelected);
    }

    @Override
    protected void setUpToolbar() {
        atvTitle.setText(getResources().getString(R.string.txt_title_saved));
        btnBack.setVisibility(View.VISIBLE);
        ivDrop.setVisibility(View.INVISIBLE);
        ivSearch.setVisibility(View.INVISIBLE);
        atvTitle.setVisibility(View.VISIBLE);
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

    @OnClick(R.id.btn_back)
    public void doClick(View v) {
        switch (v.getId()) {
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
    public void loadArticleDetailSuccess(Save save) {
        saveSelected = save;
        tvLessonTitle.setText(save.getSaveName());
        tvLessonIntroText.setText(save.getSaveIntro());
        mvContent.setText(save.getSaveBody());
    }

    @Override
    public void loadArticleDetailError() {
        Timber.e("%s", "Error");
    }
}
