package com.example.hiennv.loigiaihay.ui.event.listarticle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.ArticleAdapter;
import com.example.hiennv.loigiaihay.network.pojo.event.Article;
import com.example.hiennv.loigiaihay.network.pojo.event.SubEvent;
import com.example.hiennv.loigiaihay.ui.base.BaseFragment;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

public class FragmentListArticle extends BaseFragment {
    private static final String TAG = FragmentListArticle.class.getSimpleName();
    @BindView(R.id.rv_articles)
    RecyclerView rvArticles;
    private List<Article> articles;
    private ArticleAdapter articleAdapter;
    Unbinder unbinder;

    public static FragmentListArticle newInstance(List<Article> subEvents) {
        FragmentListArticle fragmentListArticle = new FragmentListArticle();
        Bundle bundle = new Bundle();
        bundle.putSerializable("list_sub_event", (Serializable) subEvents);
        return fragmentListArticle;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            articles = (List<Article>) bundle.getSerializable("list_sub_event");
            Timber.i("%s : ", articles.size() + "");
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list_sub_event;
    }

    @Override
    protected void initData() {
        articleAdapter = new ArticleAdapter(getActivity(), articles);
        rvArticles.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvArticles.setItemAnimator(new DefaultItemAnimator());
        rvArticles.setAdapter(articleAdapter);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
