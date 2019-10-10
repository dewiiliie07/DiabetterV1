package com.example.dewiiliie.diabetter;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.media.session.MediaSession;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class MenuUtama extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

//    ViewPager viewPager;
//    Adapter adapter;
//    List<Model> models;
//
//    private Button btnNext;
//    ArrayList<Model> addFoodList;
//    RecyclerView recyclerView;
    //TextView tv_addFoods;

//    private BottomNavigationView mMainNav;
//    private FrameLayout mMainFrame;
//
//    private HomeFragment homeFragment;
//    private QuestFragment questFragment;
//    private LeaderboardFragment leaderboardFragment;
//    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama);

//
//        activity.window.apply {
//            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//            statusBarColor = Color.TRANSPARENT
//        }
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

//        StatusBarUtil.setTransparent(this);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        loadFragment(new HomeFragment());

        BottomNavigationView navigationView = findViewById(R.id.main_nav);
        navigationView.setOnNavigationItemSelectedListener(this);

//        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
//        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
//
//
//        homeFragment = new HomeFragment();
//        questFragment = new QuestFragment();
//        leaderboardFragment = new LeaderboardFragment();
//        profileFragment = new ProfileFragment();


    }

    private boolean loadFragment(Fragment fragment) {

        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,fragment)
                    .commit();

            return true;
        }
        return false;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()){

            case R.id.nav_home :
                fragment = new HomeFragment();
                break;

            case R.id.nav_quest :
                fragment = new QuestFragment();
                break;

            case R.id.nav_leaderboard :
                fragment = new LeaderboardFragment();
                break;

            case R.id.nav_profile :
                fragment = new ProfileFragment();
                break;

        }

        return loadFragment(fragment);
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {

        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
