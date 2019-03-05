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
import com.example.hiennv.loigiaihay.ui.event.listevent.FragmentEvent;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.grantland.widget.AutofitTextView;
import timber.log.Timber;

public class EventActivityVer2 extends BaseActivity {
    //Fetch data when click Event
    public static final String TAG = EventActivityVer2.class.getSimpleName();
    /*@BindView(R.id.tv_title_subject)
    TextView tvTitleSubject;*/
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.atv_title)
    AutofitTextView atvTitle;
    @BindView(R.id.mact_search)
    MyAutoCompleteTextView mactSearch;


    //Id event
    private int itemId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_event_ver2;
    }

    @Override
    protected void initData() {
        itemId = getIntent().getIntExtra(AppConstants.KEY_ITEM_ID, 0);
        replaceFragment(R.id.fl_list_event, FragmentEvent.newInstance(itemId));
    }

    @Override
    protected void setUpToolbar() {
        sharedPrefUtils = new SharedPrefUtils(this);
        String subjectName = sharedPrefUtils.getString(AppConstants.KEY_SUBJECT_TITLE, "");
        atvTitle.setText(subjectName);
    }

    @Override
    protected void initEvents() {

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
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
