package com.example.hiennv.loigiaihay.ui.articledetail;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.OtherInCatAdapter;
import com.example.hiennv.loigiaihay.callback.ItemArticleListener;
import com.example.hiennv.loigiaihay.network.pojo.article.ArticleInfo;
import com.example.hiennv.loigiaihay.network.pojo.article.OtherInCat;
import com.example.hiennv.loigiaihay.network.pojo.article.ResponseArticle;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.customview.MyAutoCompleteTextView;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.kexanie.library.MathView;
import me.grantland.widget.AutofitTextView;
import timber.log.Timber;

public class ArticleDetailActivity extends BaseActivity implements ArticleDetailContract.ArticleDetailView, ItemArticleListener {

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
    @BindView(R.id.tv_lesson_title)
    TextView tvLessonTitle;
    @BindView(R.id.tv_lesson_intro_text)
    TextView tvLessonIntroText;
    @BindView(R.id.mv_content)
    MathView mvContent;
    @BindView(R.id.btn_download_offline)
    LinearLayout btnDownloadOffline;
    @BindView(R.id.btn_share)
    LinearLayout btnShare;
    @BindView(R.id.btn_comment)
    LinearLayout btnComment;
    @BindView(R.id.btn_feedback)
    LinearLayout btnFeedback;
    @BindView(R.id.ll_button)
    LinearLayout llButton;
    @BindView(R.id.rv_other_article)
    RecyclerView rvOtherArticle;
    @BindView(R.id.sv_lesson)
    ScrollView svLesson;
    @BindView(R.id.ll_detail_lesson)
    LinearLayout llDetailLesson;
    @BindView(R.id.fl_loading)
    FrameLayout flLoading;
    private int itemId;
    private ArticleDetailPresenterImpl articleDetailPresenter;

    private boolean checkFirstOpenDetail = false;
    //Lesson display
    private ArticleInfo articleInfoSelected;
    private OtherInCatAdapter otherInCatAdapter;
    private List<OtherInCat> otherInCats;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_detail;
    }

    @Override
    protected void initData() {
        itemId = getIntent().getIntExtra(AppConstants.KEY_ARTICLE_ID, 0);
        Timber.i("%s", "ItemId: " + itemId);
        otherInCats = new ArrayList<>();
        otherInCatAdapter = new OtherInCatAdapter(this, otherInCats);
        rvOtherArticle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvOtherArticle.setItemAnimator(new DefaultItemAnimator());
        rvOtherArticle.setAdapter(otherInCatAdapter);

        articleDetailPresenter = new ArticleDetailPresenterImpl(this);
        articleDetailPresenter.loadArticleDetail(itemId);
    }

    @Override
    protected void setUpToolbar() {
        setSupportActionBar(toolbar);
        ivSearch.setVisibility(View.INVISIBLE);
        atvTitle.setVisibility(View.VISIBLE);
        String subjectName = sharedPrefUtils.getString(AppConstants.KEY_SUBJECT_TITLE, "");
        atvTitle.setText(subjectName);
    }

    @Override
    protected void initEvents() {
        otherInCatAdapter.setItemArticleListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isNetworkConnected) {
            checkFirstOpenDetail = true;
        }
    }

    @OnClick({R.id.atv_title, R.id.iv_drop, R.id.iv_search, R.id.btn_back,
            R.id.btn_next_lesson, R.id.btn_download_offline, R.id.btn_share, R.id.btn_comment, R.id.btn_feedback})
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
            case R.id.btn_download_offline:
                handleDownloadOffline();
                break;
            case R.id.btn_share:
                break;
            case R.id.btn_comment:
                break;
            case R.id.btn_feedback:
                break;
            case R.id.btn_next_lesson:
                handleNextLesson();
                break;
        }
    }

    //Handle download
    private void handleDownloadOffline() {
        //Check runtime permission
        if (!PermissionUtils.checkPermissionStorageGranted(this)){
            PermissionUtils.requestStoragePermission(this);
        }else {

        }
    }

    //Handle next lesson
    private void handleNextLesson() {
        itemId = otherInCats.get(0).getArticleId();
        articleDetailPresenter.loadArticleDetail(itemId);
        //scrollview to top
        svLesson.fullScroll(View.FOCUS_UP);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void loadArticleDetailSuccess(ResponseArticle article) {
        hideLoading();
        llDetailLesson.setVisibility(View.VISIBLE);
        //Fetch data
        articleInfoSelected = article.getArticleInfo();
        tvLessonTitle.setText(articleInfoSelected.getTitle());
        tvLessonIntroText.setText(articleInfoSelected.getIntroText());
        mvContent.setText(articleInfoSelected.getContent());

        otherInCats.clear();
        otherInCats.addAll(article.getOtherInCats());
        Timber.i("OtherInCat: %d", otherInCats.size());
        otherInCatAdapter.notifyDataSetChanged();

    }

    @Override
    public void loadArticleDetailError(String message) {
        Timber.e("%s", message);
    }

    @Override
    public void showLoading() {
        llDetailLesson.setVisibility(View.GONE);
        flLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        flLoading.setVisibility(View.GONE);
    }

    @Override
    public void doItemArticleClick(int articleId) {
        Timber.i("OtherCatId: %d", articleId);
        articleDetailPresenter.loadArticleDetail(articleId);
        svLesson.fullScroll(View.FOCUS_UP);
    }
}
