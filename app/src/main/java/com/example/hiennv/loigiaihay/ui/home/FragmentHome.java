package com.example.hiennv.loigiaihay.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ExpandableListView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.ChapAdapter;
import com.example.hiennv.loigiaihay.network.pojo.category.Event;
import com.example.hiennv.loigiaihay.ui.base.BaseFragment;
import com.example.hiennv.loigiaihay.utils.AppLogger;

import java.util.List;

import butterknife.BindView;
import timber.log.Timber;

public class FragmentHome extends BaseFragment implements MainContract.MainView {
    private static final String TAG = FragmentHome.class.getSimpleName();
    //https://api.loigiaihay.com/v3/categories/47
    @BindView(R.id.elv_subject)
    ExpandableListView elvSubject;
    private int itemId;
    private ChapAdapter chapAdapter;
    private MainPresenterImpl mainPresenter;
    private List<Event> listEvent;

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
        mainPresenter.loadListSession(itemId);
    }

    @Override
    public void loadListSessionSuccess(List<Event> events) {
        //Fetch data
        chapAdapter = new ChapAdapter(getActivity(), listEvent);
        elvSubject.setAdapter(chapAdapter);
    }

    @Override
    public void loadListSessionError(String message) {
        Timber.e(TAG, message);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
