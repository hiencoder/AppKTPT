package com.example.hiennv.loigiaihay.ui.saved;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.ArticleOfflineAdaper;
import com.example.hiennv.loigiaihay.db.model.Save;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.customview.MyAutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.grantland.widget.AutofitTextView;

public class SaveActivity extends BaseActivity implements SaveContract.SaveView {

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
    @BindView(R.id.rv_lesson_offline)
    RecyclerView rvLessonOffline;

    private SavePresenterImpl savePresenter;
    private List<Save> saves;
    private ArticleOfflineAdaper articleOfflineAdaper;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_saved;
    }

    @Override
    protected void initData() {
        saves = new ArrayList<>();
        articleOfflineAdaper = new ArticleOfflineAdaper(this, saves);
        rvLessonOffline.setAdapter(articleOfflineAdaper);
        savePresenter = new SavePresenterImpl(this, this);
        savePresenter.loadAllSave();
    }

    @Override
    protected void setUpToolbar() {
        setSupportActionBar(toolbar);
        btnBack.setVisibility(View.VISIBLE);
        atvTitle.setVisibility(View.INVISIBLE);
        ivDrop.setVisibility(View.INVISIBLE);
        ivSearch.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void loadAllSaveSuccess(List<Save> saves) {

    }

    @Override
    public void loadAllSaveError() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
