package com.example.hiennv.loigiaihay.ui.articledetail;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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
import android.widget.Toast;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.OtherInCatAdapter;
import com.example.hiennv.loigiaihay.callback.ItemArticleListener;
import com.example.hiennv.loigiaihay.db.model.History;
import com.example.hiennv.loigiaihay.db.model.Save;
import com.example.hiennv.loigiaihay.download.Decompress;
import com.example.hiennv.loigiaihay.download.DownloadFileAsync;
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
import es.dmoral.toasty.Toasty;
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
    @BindView(R.id.tv_title_button_download)
    TextView tvTitleButtonDownload;
    @BindView(R.id.btn_next_lesson)
    LinearLayout btnNextLesson;
    @BindView(R.id.cl_list_article)
    ConstraintLayout clListArticle;
    private int itemId;
    private ArticleDetailPresenterImpl articleDetailPresenter;

    private boolean checkFirstOpenDetail = false;
    //Lesson display
    private ArticleInfo articleInfoSelected;
    private OtherInCatAdapter otherInCatAdapter;
    private List<OtherInCat> otherInCats;
    private History history;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_detail;
    }

    @Override
    protected void initData() {
        svLesson.fullScroll(View.FOCUS_UP);
        itemId = getIntent().getIntExtra(AppConstants.KEY_ARTICLE_ID, 0);
        Timber.i("%s", "ItemId: " + itemId);
        otherInCats = new ArrayList<>();
        otherInCatAdapter = new OtherInCatAdapter(this, otherInCats);
        rvOtherArticle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvOtherArticle.setItemAnimator(new DefaultItemAnimator());
        rvOtherArticle.setAdapter(otherInCatAdapter);

        articleDetailPresenter = new ArticleDetailPresenterImpl(this, this);
        articleDetailPresenter.loadArticleDetail(itemId);
        articleDetailPresenter.checkLessonDownloaded(String.valueOf(itemId));
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
                handleShare();
                break;
            case R.id.btn_comment:
                handleComment();
                break;
            case R.id.btn_feedback:
                handleFeedback();
                break;
            case R.id.btn_next_lesson:
                handleNextLesson();
                break;
        }
    }

    /**
     * Handle comment
     */
    private void handleComment() {

    }

    //Handle share
    private void handleShare() {

    }

    /**
     * Handle feedback
     */
    private void handleFeedback() {

    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        super.onNetworkConnectionChanged(isConnected);
        //isNetworkConnected = isConnected;
    }

    //Handle download
    private void handleDownloadOffline() {
        //Check runtime permission
        if (checkNetwork()) {
            if (!PermissionUtils.checkPermissionStorageGranted(this)) {
                PermissionUtils.requestStoragePermission(this);
            } else {
                handleDownload(articleInfoSelected.getZipLink());
                //Handle save lesson to database
                Save save = new Save();
                save.setSaveName(articleInfoSelected.getTitle());
                save.setSaveIntro(articleInfoSelected.getIntroText());
                save.setSaveBody(articleInfoSelected.getContent());
                save.setSaveArticleId(String.valueOf(articleInfoSelected.getArticleId()));
                save.setSaveUrl(articleInfoSelected.getOriginUrl());
                articleDetailPresenter.saveLesson(save);
            }
        } else {
            Toasty.error(this, getResources().getString(R.string.txt_network), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * @param zipLink
     */
    private void handleDownload(String zipLink) {
        Timber.i("Link: %s", zipLink);
        downloadAndUnzipContent(zipLink);
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
        history = new History(articleInfoSelected.getTitle(),
                articleInfoSelected.getIntroText(),
                articleInfoSelected.getPicture(),
                articleInfoSelected.getOriginUrl(),
                String.valueOf(articleInfoSelected.getArticleId()));
        articleDetailPresenter.checkLessonDownloaded(String.valueOf(articleInfoSelected.getArticleId()));

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
    public void saveLessonSuccess() {
        Toasty.success(this, getResources().getString(R.string.txt_save_success), Toast.LENGTH_SHORT).show();
        btnDownloadOffline.setBackgroundResource(R.drawable.bg_button_downloaded);
        tvTitleButtonDownload.setText(getResources().getString(R.string.txt_downloaded));
    }

    @Override
    public void saveLessonError() {
        Toasty.error(this, getResources().getString(R.string.txt_save_error), Toast.LENGTH_SHORT).show();
        Timber.e("%s", "Error");
        btnDownloadOffline.setBackgroundResource(R.drawable.bg_button_download_offline);
        tvTitleButtonDownload.setText(getResources().getString(R.string.txt_save_offline));
    }

    @Override
    public void lessonDownloaded(boolean downloaded) {
        if (downloaded) {
            btnDownloadOffline.setBackgroundResource(R.drawable.bg_button_downloaded);
            tvTitleButtonDownload.setText(getResources().getString(R.string.txt_downloaded));
        } else {
            btnDownloadOffline.setBackgroundResource(R.drawable.bg_button_download_offline);
            tvTitleButtonDownload.setText(getResources().getString(R.string.txt_save_offline));
        }
    }

    @Override
    public void checkHistory(boolean value) {
        if (value) {
            //Đã tồn tại k insert vào db
        } else {
            databaseHelper.insertHistory(history);
        }
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

    private void downloadAndUnzipContent(String zipLink) {
        String url = "https://github.com/NanoHttpd/nanohttpd/archive/master.zip";
        String fileLocation = "/sdcard/";
        int lastIndex = zipLink.lastIndexOf("/");
        String fileName = zipLink.substring(lastIndex + 1);
        fileLocation = fileLocation + fileName;
        Timber.i("FileName: %s", fileName);
        DownloadFileAsync download = new DownloadFileAsync(this, fileLocation, file -> {
            Timber.i(TAG, "file download completed");

            // check unzip file now
            Decompress unzip = new Decompress(ArticleDetailActivity.this, file);
            unzip.unzip();

            Timber.i(TAG, "file unzip completed");
        });
        //download.execute(zipLink);
    }
}
