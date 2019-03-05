package com.example.hiennv.loigiaihay.ui.event.listevent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.example.hiennv.loigiaihay.ui.articledetail.ArticleDetailActivity;
import com.example.hiennv.loigiaihay.ui.base.BaseFragment;
import com.example.hiennv.loigiaihay.ui.event.EventContract;
import com.example.hiennv.loigiaihay.ui.event.EventPresenterImpl;
import com.example.hiennv.loigiaihay.ui.event.listarticle.FragmentListArticle;
import com.example.hiennv.loigiaihay.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import timber.log.Timber;

public class FragmentEvent extends BaseFragment implements EventContract.EventView,
        ItemBaseEventListener {
    private static final String TAG = FragmentEvent.class.getSimpleName();
    @BindView(R.id.iv_dot)
    ImageView ivDot;
    @BindView(R.id.tv_event_title)
    TextView tvEventTitle;
    @BindView(R.id.ll_event_title)
    LinearLayout llEventTitle;
    @BindView(R.id.rv_event)
    RecyclerView rvEvent;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    //Unbinder unbinder;

    private List<Article> articles;
    private List<MostView> mostViews;
    private List<SubEvent> subEvents;
    private List<BaseEvent> baseEvents;
    private int itemId;
    private EventViewAdapter eventViewAdapter;

    private EventPresenterImpl eventPresenter;

    public static FragmentEvent newInstance(int itemId) {
        FragmentEvent fragmentEvent = new FragmentEvent();
        Bundle bundle = new Bundle();
        bundle.putInt("item_id", itemId);
        fragmentEvent.setArguments(bundle);
        return fragmentEvent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            itemId = bundle.getInt("item_id");
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_event;
    }

    @Override
    protected void initData() {
        baseEvents = new ArrayList<>();
        eventPresenter = new EventPresenterImpl(this);
        eventViewAdapter = new EventViewAdapter(getActivity(), baseEvents);
        rvEvent.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvEvent.setAdapter(eventViewAdapter);
        eventPresenter.loadEvent(itemId, AppConstants.TYPE_BASE_EVENT);
    }

    @Override
    protected void initEvents() {
        eventViewAdapter.setItemBaseEventListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }

    @Override
    public void loadEventSuccess(ResponseEvent event, int type) {
        if (event != null) {
            tvEventTitle.setText(event.getEventInfo().getTitle());
            if (type == AppConstants.TYPE_BASE_EVENT) {
                articles = event.getListArticles();
                mostViews = event.getMostViews();
                subEvents = event.getSubEvents();

                Log.i(TAG, "loadEventSuccess: " + event.getListArticles().size());
                baseEvents.addAll(subEvents);
                baseEvents.addAll(articles);
                eventViewAdapter.notifyDataSetChanged();
            } else if (type == AppConstants.TYPE_ARTICLE) {
                baseEvents.clear();
                articles = event.getListArticles();
                baseEvents.addAll(articles);
                eventViewAdapter.notifyDataSetChanged();
            }
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
            //Open new activity
            Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
            intent.putExtra(AppConstants.KEY_ARTICLE_ID, ((Article) baseEvent).getArticleId());
            getActivity().startActivity(intent);
        } else if (baseEvent instanceof SubEvent) {
            Timber.i("%s", baseEvent.getTitle() + "\nId:" + ((SubEvent) baseEvent).getId());
            baseEvents.clear();
            eventPresenter.loadEvent(((SubEvent) baseEvent).getItemId(), AppConstants.TYPE_BASE_EVENT);
        }
    }
}
