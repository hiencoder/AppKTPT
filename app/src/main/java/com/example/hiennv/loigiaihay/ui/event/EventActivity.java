package com.example.hiennv.loigiaihay.ui.event;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.EventViewAdapter;
import com.example.hiennv.loigiaihay.callback.ItemBaseEventListener;
import com.example.hiennv.loigiaihay.network.pojo.event.Article;
import com.example.hiennv.loigiaihay.network.pojo.event.BaseEvent;
import com.example.hiennv.loigiaihay.network.pojo.event.MostView;
import com.example.hiennv.loigiaihay.network.pojo.event.ResponseEvent;
import com.example.hiennv.loigiaihay.network.pojo.event.SubEvent;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.customview.MyAutoCompleteTextView;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.grantland.widget.AutofitTextView;
import timber.log.Timber;

public class EventActivity extends BaseActivity implements EventContract.EventView,
        ItemBaseEventListener {
    //Fetch data when click Event
    public static final String TAG = EventActivity.class.getSimpleName();
    /*@BindView(R.id.tv_title_subject)
    TextView tvTitleSubject;*/
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.atv_title)
    AutofitTextView atvTitle;
    @BindView(R.id.mact_search)
    MyAutoCompleteTextView mactSearch;
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
        baseEvents = new ArrayList<>();
        eventViewAdapter = new EventViewAdapter(this, baseEvents);
        rvEvent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvEvent.setAdapter(eventViewAdapter);
        eventPresenter.loadEvent(itemId, AppConstants.TYPE_BASE_EVENT);
    }

    @Override
    protected void setUpToolbar() {
        sharedPrefUtils = new SharedPrefUtils(this);
        String subjectName = sharedPrefUtils.getString(AppConstants.KEY_SUBJECT_TITLE, "");
        atvTitle.setText(subjectName);

    }

    @Override
    protected void initEvents() {
        eventViewAdapter.setItemBaseEventListener(this::doItemBaseClick);
    }

    @Override
    public void loadEventSuccess(ResponseEvent event, int type) {
        if (event != null) {
            //baseEvents = new ArrayList<>();
            tvEventTitle.setText(event.getEventInfo().getTitle());
            articles = event.getListArticles();
            mostViews = event.getMostViews();
            subEvents = event.getSubEvents();

            baseEvents.addAll(subEvents);
            baseEvents.addAll(articles);
            eventViewAdapter.notifyDataSetChanged();
            /*eventViewAdapter = new EventViewAdapter(this, baseEvents);
            rvEvent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rvEvent.setAdapter(eventViewAdapter);*/


        }
    }

    @Override
    public void loadEventError(String message) {
        Timber.e("%s", message);
    }

    @Override
    public void showLoading() {
        Log.i(TAG, "showLoading: ");
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @OnClick({R.id.iv_search, R.id.btn_back})
    void doClick(View v) {
        switch (v.getId()) {
            case R.id.iv_search:
                atvTitle.setVisibility(View.GONE);
                mactSearch.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_back:
                onBackPressed();
                break;
        }
    }

    @Override
    public void doItemBaseClick(BaseEvent baseEvent) {
        List<Article> articles = new ArrayList<>();
        List<SubEvent> subEvents = new ArrayList<>();
        for (BaseEvent event : baseEvents) {
            if (event instanceof Article) {
                articles.add((Article) event);
            } else {
                subEvents.add((SubEvent) event);
            }
        }
        if (baseEvent instanceof Article) {
            Timber.i("%s", baseEvent.getTitle());
            //Send list articles
            //Intent intent = new Intent()
        } else if (baseEvent instanceof SubEvent) {
            Timber.i("%s", baseEvent.getTitle());
        }
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}