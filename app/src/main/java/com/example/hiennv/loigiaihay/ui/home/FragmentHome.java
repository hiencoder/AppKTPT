package com.example.hiennv.loigiaihay.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ExpandableListView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.ChapAdapter;
import com.example.hiennv.loigiaihay.callback.ItemEventListener;
import com.example.hiennv.loigiaihay.network.pojo.category.Event;
import com.example.hiennv.loigiaihay.ui.base.BaseFragment;
import com.example.hiennv.loigiaihay.ui.event.EventActivity;
import com.example.hiennv.loigiaihay.ui.event.EventActivityVer2;
import com.example.hiennv.loigiaihay.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import timber.log.Timber;

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
        mainPresenter.loadListSession(itemId);
    }

    @Override
    public void loadListSessionSuccess(List<Event> events) {
        //Fetch data
        if (events.size() > 0) {
            Timber.i("%s", events.size());
            for (int i = 0; i < events.size(); i++) {
                Timber.i("%s", events.get(i).getTitle());
            }
            chapAdapter = new ChapAdapter(getActivity(), events);
            elvSubject.setAdapter(chapAdapter);
            for (int i = 0; i < chapAdapter.getGroupCount(); i++) {
                elvSubject.expandGroup(i);
            }

            //Event
            chapAdapter.setItemEventListener(event -> {
                Intent intent = new Intent(getActivity(), EventActivityVer2.class);
                intent.putExtra(AppConstants.KEY_ITEM_ID, event.getItemId());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            });
            chapAdapter.setSubItemClickListener(subItem -> {
                Intent intent = new Intent(getActivity(), EventActivityVer2.class);
                intent.putExtra(AppConstants.KEY_ITEM_ID, subItem.getItemId());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            });
        }
    }

    @Override
    public void loadListSessionError(String message) {
        Timber.e("%s", message);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
