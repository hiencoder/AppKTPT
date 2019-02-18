package com.example.hiennv.loigiaihay.ui.event;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.network.pojo.category.SubItem;
import com.example.hiennv.loigiaihay.network.pojo.event.Article;
import com.example.hiennv.loigiaihay.network.pojo.event.MostView;
import com.example.hiennv.loigiaihay.network.pojo.event.ResponseEvent;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EventActivity extends BaseActivity implements EventContract.EventView {
    //Fetch data when click Event
    public static final String TAG = EventActivity.class.getSimpleName();
    @BindView(R.id.tv_title_subject)
    TextView tvTitleSubject;
    @BindView(R.id.tv_event_title)
    TextView tvEventTitle;
    @BindView(R.id.rv_articles)
    RecyclerView rvArticles;
    @BindView(R.id.rv_most_views)
    RecyclerView rvMostViews;
    @BindView(R.id.rv_list_subItem)
    RecyclerView rvListSubItem;

    private List<Article> articles;
    private List<MostView> mostViews;
    private List<SubItem> subItems;

    private EventPresenterImpl eventPresenter;

    //Id event
    private int itemId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_event_detail;
    }

    @Override
    protected void initData() {
        itemId = getIntent().getIntExtra(AppConstants.KEY_ITEM_ID, 0);
        eventPresenter = new EventPresenterImpl(this);
        eventPresenter.loadEvent(itemId);
    }

    @Override
    protected void setUpToolbar() {
        sharedPrefUtils = new SharedPrefUtils(this);
        String subjectName = sharedPrefUtils.getString(AppConstants.KEY_SUBJECT_TITLE, "");
        tvEventTitle.setText(subjectName);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void loadEventSuccess(ResponseEvent event) {

    }

    @Override
    public void loadEventError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick({R.id.iv_search})
    void doClick(View v) {
        switch (v.getId()) {
            case R.id.iv_search:
                break;
        }
    }
}
