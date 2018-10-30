package com.example.hiennv.loigiaihay.ui.home;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;


import com.example.hiennv.loigiaihay.ui.changeclass.ChangeClassActivity;
import com.example.hiennv.loigiaihay.ui.changesubject.ChangeSubjectActivity;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;


import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    //https://stackoverflow.com/questions/33284812/android-change-navigation-drawer-menu-items-text-programmatically
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;
    /*@BindView(R.id.btn_open_menu)
    ImageView btnOpenMenu;*/
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title_subject)
    TextView tvTitleSubject;
    @BindView(R.id.nv_menu)
    NavigationView nvMenu;
    //Id class
    private String tagId;
    //Title class
    private String titleClass;
    //Title subject
    private String titleSubject;

    private boolean doubleBackToExitApp = false;

    private FragmentManager fragmentManager;

    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

        tagId = sharedPrefUtils.getString(AppConstants.KEY_CLASS_ID,"");
        drawerToggle = new ActionBarDrawerToggle(this,dlMain,toolbar,R.string.txt_open,R.string.txt_close){
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
    }

    @Override
    protected void setUpToolbar() {
        sharedPrefUtils = new SharedPrefUtils(this);
        setSupportActionBar(toolbar);
        titleClass = sharedPrefUtils.getString(AppConstants.KEY_CLASS_TITLE, "");
        titleSubject = sharedPrefUtils.getString(AppConstants.KEY_SUBJECT_TITLE, "");
        tvTitleSubject.setText(titleClass + "-" + titleSubject);
    }

    @Override
    protected void initEvents() {
        nvMenu.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            replaceFragment(FragmentHome.newInstance(), "fragment_home");
        }*/

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                dlMain.closeDrawer(Gravity.NO_GRAVITY);
                break;
            case R.id.menu_search:
                dlMain.closeDrawer(Gravity.NO_GRAVITY);
                break;
            case R.id.menu_change_subject:
                startActivity(new Intent(MainActivity.this, ChangeSubjectActivity.class));
                dlMain.closeDrawer(Gravity.NO_GRAVITY);
                break;
            case R.id.menu_change_class:
                startActivity(new Intent(MainActivity.this, ChangeClassActivity.class));
                dlMain.closeDrawer(Gravity.NO_GRAVITY);
                break;
            case R.id.menu_open_saved:
                dlMain.closeDrawer(Gravity.NO_GRAVITY);
                break;
            case R.id.menu_save_offline:
                dlMain.closeDrawer(Gravity.NO_GRAVITY);
                break;
            case R.id.menu_seen:
                dlMain.closeDrawer(Gravity.NO_GRAVITY);
                break;
            case R.id.menu_rate:
                break;
            case R.id.menu_share:
                break;
        }
        return false;
    }

    @OnClick({/*R.id.btn_open_menu, */R.id.tv_title_subject})
    void doClick(View v) {
        switch (v.getId()) {
            /*case R.id.btn_open_menu:

                break;*/
            case R.id.tv_title_subject:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitApp){
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitApp = true;
        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitApp = false;
            }
        },2000);

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
}
