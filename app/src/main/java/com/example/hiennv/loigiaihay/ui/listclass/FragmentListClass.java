package com.example.hiennv.loigiaihay.ui.listclass;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.ListClassAdapter;
import com.example.hiennv.loigiaihay.callback.ItemClassListener;
import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.tag.ClassEntity;
import com.example.hiennv.loigiaihay.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.OnClick;

public class FragmentListClass extends BaseFragment implements ListClassContract.ListClassView,
        ItemClassListener {
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.rv_list_class)
    RecyclerView rvListClass;
    @BindView(R.id.btn_back)
    ImageView btnBack;

    private ApiService apiService;
    private ListClassPresenterImpl listClassPresenter;
    private List<ClassEntity> listClass;
    private ListClassAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list_class;
    }

    @Override
    protected void initData() {
        listClass = new ArrayList<>();
        apiService = ApiClient.getClient().create(ApiService.class);
        listClassPresenter = new ListClassPresenterImpl(this, apiService);
        listClassPresenter.loadListClass();
    }

    @Override
    public void loadSuccess(List<ClassEntity> list) {
        if (list != null && list.size() > 0) {
            listClass.addAll(list);
            adapter = new ListClassAdapter(getActivity(), listClass, this::classClick);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
            rvListClass.setHasFixedSize(true);
            rvListClass.setLayoutManager(gridLayoutManager);
            rvListClass.setAdapter(adapter);
        }
    }

    @Override
    public void loadError() {

    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void classClick(String classId) {
        Bundle bundle = new Bundle();
        bundle.putString("tagId",classId);
        Navigation.findNavController(view).navigate(R.id.action_list_class_to_choose_subject,bundle);
    }

    @OnClick(R.id.btn_back)
    void doClick(View v){
        switch (v.getId()){
            case R.id.btn_back:
                //Open main activity
                getActivity().onBackPressed();
                break;
        }
    }
}
