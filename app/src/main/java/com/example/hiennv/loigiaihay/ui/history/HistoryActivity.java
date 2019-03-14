package com.example.hiennv.loigiaihay.ui.history;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.HistoryAdapter;
import com.example.hiennv.loigiaihay.callback.ItemArticleListener;
import com.example.hiennv.loigiaihay.db.model.History;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.customview.MyAutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import me.grantland.widget.AutofitTextView;
import timber.log.Timber;

public class HistoryActivity extends BaseActivity implements ItemArticleListener, HistoryContract.HistoryView {
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
    private HistoryPresenterImpl historyPresenter;
    private List<History> histories;
    private HistoryAdapter historyAdapter;

    @Override
    public void doItemArticleClick(int articleId) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    protected void initData() {
        histories = new ArrayList<>();
        historyAdapter = new HistoryAdapter(this, histories);
        rvArticles.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvArticles.setItemAnimator(new DefaultItemAnimator());
        rvArticles.setAdapter(historyAdapter);
        historyPresenter = new HistoryPresenterImpl(this, this);
        historyPresenter.getAllHistory();
    }

    @Override
    protected void setUpToolbar() {
        setSupportActionBar(toolbar);
        atvTitle.setText(getResources().getString(R.string.txt_title_history));
        atvTitle.setVisibility(View.VISIBLE);
        btnBack.setVisibility(View.VISIBLE);
        ivDrop.setVisibility(View.INVISIBLE);
        ivSearch.setVisibility(View.INVISIBLE);
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
                showDialogDelete();
                break;
        }
    }

    //Show dialog
    private void showDialogDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.txt_message_dialog_history));
        builder.setPositiveButton("Xóa", ((dialog, which) -> {
            dialog.cancel();
            historyPresenter.deleteAllHistory();
        }));
        builder.setNegativeButton("Không", ((dialog, which) -> {
            dialog.cancel();
        }));
        builder.create().show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void getAllHistory(List<History> histories) {
        this.histories.clear();
        this.histories.addAll(histories);
        historyAdapter.notifyDataSetChanged();
    }

    @Override
    public void getAllHistoryError() {
        Timber.e("%s", "Error");
    }

    @Override
    public void deleteAllHistorySuccess() {
        Toasty.success(this, getResources().getString(R.string.txt_message_delete_history_success), Toast.LENGTH_SHORT).show();
        this.histories.clear();
        historyAdapter.notifyDataSetChanged();
    }

    @Override
    public void deleteAllHistoryError() {
        Toasty.success(this, getResources().getString(R.string.txt_message_delete_history_error), Toast.LENGTH_SHORT).show();
    }
}
