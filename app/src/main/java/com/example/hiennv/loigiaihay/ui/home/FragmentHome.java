package com.example.hiennv.loigiaihay.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ExpandableListView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.ChapAdapter;
import com.example.hiennv.loigiaihay.network.pojo.category.Event;
import com.example.hiennv.loigiaihay.ui.base.BaseFragment;

import java.util.List;

import butterknife.BindView;

public class FragmentHome extends BaseFragment implements MainContract.MainView {
    //https://api.loigiaihay.com/v3/categories/47
    @BindView(R.id.elv_subject)
    ExpandableListView elvSubject;
    private int itemId;
    private ChapAdapter chapAdapter;
    private MainPresenterImpl mainPresenter;

    public static FragmentHome newInstance(int itemId) {
        FragmentHome fragmentHome = new FragmentHome();
        Bundle bundle = new Bundle();
        bundle.putInt("itemId", itemId);
        fragmentHome.setArguments(bundle);
        return fragmentHome;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            itemId = bundle.getInt("itemId");
        } else {

        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        mainPresenter = new MainPresenterImpl(this);
    }

    @Override
    public void loadListSessionSuccess(List<Event> events) {
        //Fetch data
    }

    @Override
    public void loadListSessionError(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
