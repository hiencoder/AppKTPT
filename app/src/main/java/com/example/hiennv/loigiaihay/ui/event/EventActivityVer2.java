package com.example.hiennv.loigiaihay.ui.event;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.ArticleAdapter;
import com.example.hiennv.loigiaihay.adapter.EventViewAdapter;
import com.example.hiennv.loigiaihay.adapter.MostViewAdapter;
import com.example.hiennv.loigiaihay.adapter.SubEventAdapter;
import com.example.hiennv.loigiaihay.callback.ItemArticleListener;
import com.example.hiennv.loigiaihay.callback.ItemMostViewListener;
import com.example.hiennv.loigiaihay.callback.ItemSubEventListener;
import com.example.hiennv.loigiaihay.network.pojo.event.Article;
import com.example.hiennv.loigiaihay.network.pojo.event.BaseEvent;
import com.example.hiennv.loigiaihay.network.pojo.event.MostView;
import com.example.hiennv.loigiaihay.network.pojo.event.ResponseEvent;
import com.example.hiennv.loigiaihay.network.pojo.event.SubEvent;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EventActivityVer2 extends BaseActivity implements EventContract.EventView,
        ItemArticleListener, ItemMostViewListener, ItemSubEventListener {
    //Fetch data when click Event
    public static final String TAG = EventActivityVer2.class.getSimpleName();
    @BindView(R.id.tv_title_subject)
    TextView tvTitleSubject;
    @BindView(R.id.tv_event_title)
    TextView tvEventTitle;
    @BindView(R.id.rv_event)
    RecyclerView rvEvent;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    private List<Article> articles;
    private List<MostView> mostViews;
    private List<SubEvent> subEvents;
    private List<BaseEvent> baseEvents;

    private EventViewAdapter eventViewAdapter;

    private EventPresenterImpl eventPresenter;

    //Id event
    private int itemId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_event;
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
        //tvEventTitle.setText(subjectName);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void loadEventSuccess(ResponseEvent event) {
        if (event != null) {
            baseEvents = new ArrayList<>();
            tvEventTitle.setText(event.getEventInfo().getTitle());
            articles = event.getListArticles();
            mostViews = event.getMostViews();
            subEvents = event.getSubEvents();

            baseEvents.addAll(subEvents);
            baseEvents.addAll(articles);
            eventViewAdapter = new EventViewAdapter(this, baseEvents);
            rvEvent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rvEvent.setAdapter(eventViewAdapter);


        }
    }

    @Override
    public void loadEventError() {

    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @OnClick({R.id.iv_search})
    void doClick(View v) {
        switch (v.getId()) {
            case R.id.iv_search:
                break;
        }
    }

    @Override
    public void doItemArticleClick(int articleId) {

    }

    @Override
    public void doItemMostViewClick(int mostViewId) {

    }

    @Override
    public void doItemSubEventClick(int subEventId) {

    }
}
