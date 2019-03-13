package com.example.hiennv.loigiaihay.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.changeclass.ChangeClassActivity;
import com.example.hiennv.loigiaihay.ui.changesubject.ChangeSubjectActivity;
import com.example.hiennv.loigiaihay.ui.customview.MyAutoCompleteTextView;
import com.example.hiennv.loigiaihay.ui.saved.SaveActivity;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import me.grantland.widget.AutofitTextView;

//https://stackoverflow.com/questions/31367270/exporting-sqlite-database-to-csv-file-in-android
//https://stackoverflow.com/questions/43055661/reading-csv-file-in-android-app
//http://codesfor.in/how-to-export-sqlite-database-to-a-csv-file/
public class MainActivity extends BaseActivity {
    //https://stackoverflow.com/questions/33284812/android-change-navigation-drawer-menu-items-text-programmatically
    //https://api.loigiaihay.com/v3/categories/47 api get main
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;
    /*@BindView(R.id.btn_open_menu)
    ImageView btnOpenMenu;*/
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    /*@BindView(R.id.tv_title_subject)
    TextView tvTitleSubject;*/
    @BindView(R.id.atv_title)
    AutofitTextView atvTitle;
    @BindView(R.id.mact_search)
    MyAutoCompleteTextView mactSearch;
    @BindView(R.id.nv_menu)
    NavigationView nvMenu;
    //Menu id
    @BindView(R.id.menu_home)
    LinearLayout menuHome;
    @BindView(R.id.menu_search)
    LinearLayout menuSearch;
    @BindView(R.id.menu_change_subject)
    LinearLayout menuChangeSubject;
    @BindView(R.id.menu_change_class)
    LinearLayout menuChangeClass;
    @BindView(R.id.menu_open_saved)
    LinearLayout menuOpenSaved;
    @BindView(R.id.menu_save_offline)
    LinearLayout menuSaveOffline;
    @BindView(R.id.menu_seen)
    LinearLayout menuSeen;
    @BindView(R.id.menu_rate)
    LinearLayout menuRate;
    @BindView(R.id.menu_share)
    LinearLayout menuShare;
    @BindView(R.id.menu_feed_back)
    LinearLayout menuFeedback;
    @BindView(R.id.menu_notify)
    LinearLayout menuNotify;

    @BindView(R.id.tv_change_class)
    TextView tvChangeClass;
    @BindView(R.id.tv_change_subject)
    TextView tvChangeSubject;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.iv_drop)
    ImageView ivDrop;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.fl_main)
    FrameLayout flMain;

    //Id class
    private String tagId;
    //Title class
    private String titleClass;
    //Title subject
    private String titleSubject;

    private boolean doubleBackToExitApp = false;

    private FragmentManager fragmentManager;

    private ActionBarDrawerToggle drawerToggle;

    //Menu navigation view
    private Menu menu;
    private MenuItem itemChangeClass;
    private MenuItem itemChangeSubject;

    private String itemId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

        tagId = sharedPrefUtils.getString(AppConstants.KEY_CLASS_ID, "");

        drawerToggle = new ActionBarDrawerToggle(this, dlMain, toolbar, R.string.txt_open, R.string.txt_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        dlMain.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        //Fetch title menu navigationview
        //menu = nvMenu.getMenu();
        /*itemChangeClass = menu.findItem(R.id.menu_change_class);
        itemChangeSubject = menu.findItem(R.id.menu_change_subject);
        itemChangeClass.setTitle("Đổi môn (" + titleClass + "-" + titleSubject + ")");
        itemChangeSubject.setTitle("Đổi lớp (" + titleClass + ")");*/
        tvChangeSubject.setText("Đổi môn (" + titleClass + " - " + titleSubject + ")");

        tvChangeClass.setText("Đổi lớp (" + titleClass + ")");
        fragmentManager = getSupportFragmentManager();
        itemId = sharedPrefUtils.getString(AppConstants.KEY_SUBJECT_ID, "");
        replaceFragment(FragmentHome.newInstance(Integer.parseInt(itemId)), "fragment_home");
    }

    @Override
    protected void setUpToolbar() {
        setSupportActionBar(toolbar);
        btnBack.setVisibility(View.INVISIBLE);
        atvTitle.setVisibility(View.VISIBLE);
        sharedPrefUtils = new SharedPrefUtils(this);
        titleClass = sharedPrefUtils.getString(AppConstants.KEY_CLASS_TITLE, "");
        titleSubject = sharedPrefUtils.getString(AppConstants.KEY_SUBJECT_TITLE, "");
        atvTitle.setText(titleClass + " - " + titleSubject);
    }

    @Override
    protected void onResume() {
        super.onResume();
       /* btnBack.setVisibility(View.INVISIBLE);
        atvTitle.setVisibility(View.VISIBLE);*/
    }

    @Override
    protected void initEvents() {
        //Event for autocompletetextview
        mactSearch.setOnEditorActionListener((textView, i, keyEvent) -> false);
    }

    /**
     * @param fragment
     * @param tag
     */
    private void replaceFragment(Fragment fragment, String tag) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fl_main, fragment, tag);
        ft.addToBackStack(tag);
        ft.commit();
    }

    /**
     * @param fragment
     * @param tag
     */
    private void addFragment(Fragment fragment, String tag) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fl_main, fragment, tag);
        ft.addToBackStack(tag);
        ft.commit();
    }


    @OnClick({/*R.id.btn_open_menu, */R.id.atv_title, R.id.menu_home, R.id.menu_search, R.id.menu_change_subject,
            R.id.menu_change_class, R.id.menu_open_saved, R.id.menu_save_offline, R.id.menu_seen, R.id.menu_rate,
            R.id.menu_share, R.id.menu_feed_back, R.id.menu_notify, R.id.mact_search})
    void doClick(View v) {
        switch (v.getId()) {
            /*case R.id.btn_open_menu:

                break;*/
            case R.id.atv_title:
                break;
            case R.id.menu_home:
                break;
            case R.id.menu_search:
                mactSearch.setVisibility(View.VISIBLE);
                break;
            case R.id.menu_change_subject:
                //Mở màn hình chọn môn
                dlMain.closeDrawer(Gravity.START);
                startActivity(new Intent(this, ChangeSubjectActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.menu_change_class:
                //Mở màn hình chọn lớp
                dlMain.closeDrawer(Gravity.START);
                startActivity(new Intent(this, ChangeClassActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.menu_open_saved:
                //Mở ra màn hình thông tin các bài học đã tải về
                dlMain.closeDrawer(Gravity.START);
                startActivity(new Intent(this, SaveActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.menu_save_offline:
                //Mở màn hình lưu cả môn học
                dlMain.closeDrawer(Gravity.START);
                break;
            case R.id.menu_seen:
                //Mở màn hình các bài học đã xem
                dlMain.closeDrawer(Gravity.START);
                break;
            case R.id.menu_rate:
                //Đánh giá ứng dụng
                dlMain.closeDrawer(Gravity.START);
                break;
            case R.id.menu_share:
                //Chia sẻ ứng dụng
                dlMain.closeDrawer(Gravity.START);
                break;
            case R.id.menu_feed_back:
                //Phản hồi ứng dụng
                dlMain.closeDrawer(Gravity.START);
                break;
            case R.id.menu_notify:
                //Mở màn hình thông báo
                dlMain.closeDrawer(Gravity.START);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (dlMain.isDrawerOpen(Gravity.START)) {
            dlMain.closeDrawer(Gravity.START);
        } else {
            if (doubleBackToExitApp) {
                super.onBackPressed();
                return;
            }
            this.doubleBackToExitApp = true;
            //Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();
            Toasty.info(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitApp = false;
                }
            }, 2000);
        }

        /*if (this.getSupportFragmentManager().getBackStackEntryCount() >= 1) {
            this.getSupportFragmentManager().popBackStack();
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getSupportFragmentManager().getBackStackEntryCount());
            stringBuilder.append("");
        } else if (this.doubleBackToExitApp) {
            super.onBackPressed();
        } else {
            this.doubleBackToExitApp = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MainActivity.this.doubleBackToExitApp = true;
                }
            }, 2000);
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
