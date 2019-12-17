package com.example.dewiiliie.diabetter;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.media.session.MediaSession;
import android.os.AsyncTask;
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
import android.widget.Toast;

import com.example.dewiiliie.diabetter.model.ListQuest;
import com.example.dewiiliie.diabetter.model.ListQuestCounter;
import com.example.dewiiliie.diabetter.model.Quest;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;
import com.jaeger.library.StatusBarUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuUtama extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

//    ViewPager viewPager;
//    Adapter adapter;
//    List<Model> models;

    String full_name;
//
//    private Button btnNext;
//    ArrayList<Model> addFoodList;
//    RecyclerView recyclerView;
    //TextView tv_addFoods;

//    private BottomNavigationView mMainNav;
//    private FrameLayout mMainFrame;
//
      private HomeFragment homeFragment;
//    private QuestFragment questFragment;
//    private LeaderboardFragment leaderboardFragment;
//    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama);

        checkQuest();

        ApiInterface mApi = ApiClient.getClient().create(ApiInterface.class);

        Call<ListQuest> questCall = mApi.getQuestByUser(Global.user.getUser_id());
        questCall.enqueue(new Callback<ListQuest>() {
            @Override
            public void onResponse(Call<ListQuest> call, Response<ListQuest> response) {
                Global.quest = response.body().getQuestList();
            }

            @Override
            public void onFailure(Call<ListQuest> call, Throwable t) {

            }
        });


//        if(savedInstanceState == null){
//            Bundle extras = getIntent().getExtras();
//            if(extras != null){
//                full_name = extras.getString("FULLNAME");
//        } else{
//            full_name = (String) savedInstanceState.getSerializable("FULLNAME");
//        }

//
//        activity.window.apply {
//            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//            statusBarColor = Color.TRANSPARENT
//        }

//        Toast.makeText(this, getIntent().getExtras().getString("FULLNAME"), Toast.LENGTH_SHORT).show();
//        Bundle b2 = new Bundle();
//        b2.putString("FULLNAME",getIntent().getExtras().toString());
//        homeFragment.setArguments(b2);


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

    private void checkQuest(){
        new Connection().execute();
    }

    public class Connection extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            String[] s = Global.user.getLast_login().split("-");
//            System.out.println("Tahun : " + s[0] + " Bulan : " + s[1] + " Hari : " + s[2]);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            String[] s2 = String.valueOf(dateFormat.format(date)).split("-");
            if((Integer.parseInt(s2[2]) - Integer.parseInt(s[2])) > 0)
            {
                System.out.println("LOGIN KEMARIN");
                System.out.println("HASIL : " + (Integer.parseInt(s2[2]) - Integer.parseInt(s[2])));
                Call<String> lastLogin = Global.mApi.lastLogin(Global.user.getUser_id());
                try{
                    lastLogin.execute();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }

            Call<ListQuestCounter> listQuestCounterCall = Global.mApi.checkUserQuest(Global.user.getUser_id());
            try {
//            ListQuestCounter listQuestCounter = listQuestCounterCall.execute().body();
                int counter = 0;
                ListQuestCounter lqc = listQuestCounterCall.execute().body();
                setQuestAndPoint(1);
                setQuestAndPoint(9);
                if (lqc.getCounter_add_food(0)>0 && lqc.getConsumetype_id(0)==1){
                    setQuestAndPoint(2);
                    counter++;
                }
                if (lqc.getCounter_add_food(1)>0 && lqc.getConsumetype_id(1)==2){
                    setQuestAndPoint(3);
                    counter++;

                }
                if (lqc.getCounter_add_food(2)>0 && lqc.getConsumetype_id(2)==3){
                    setQuestAndPoint(4);
                    counter++;
                }
                if (lqc.getCounter_add_food(3)>0 && lqc.getConsumetype_id(3)==4){
                    setQuestAndPoint(5);
                    counter++;
                }
                if (lqc.getCounter_add_food(4)>0 && lqc.getConsumetype_id(4)==5){
                    setQuestAndPoint(6);
                    counter++;
                }
                if (counter>=3){
                    setQuestAndPoint(7);
                }
                if (counter>=5){
                    setQuestAndPoint(8);
                }
                if (counter>=8){
                    setQuestAndPoint(11);
                }
                if (Global.user.getCounter_login() >= 3){
                    setQuestAndPoint(10);
                }
                if (Global.user.getCounter_daily_quest() >=20){
                    setQuestAndPoint(12);
                }
                if (Global.user.getCounter_daily_quest() >=40){
                    setQuestAndPoint(13);
                }
                if (Global.user.getCounter_daily_quest() >=80){
                    setQuestAndPoint(14);
                }
                if (Global.user.getPoints() >= 30){
                    setQuestAndPoint(15);
                }
                if (Global.user.getPoints() >= 70){
                    setQuestAndPoint(16);
                }
                if (Global.user.getPoints() >= 250){
                    setQuestAndPoint(17);
                }
                if (Global.user.getPoints() >= 500){
                    setQuestAndPoint(15);
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
                System.out.println("ERROR : " + ex.getMessage().toString());
            }





            return null;
        }
    }

    void setQuestAndPoint(final int questID){
        Call<ListQuest> questCall = Global.mApi.getQuestSpesified(Global.user.getUser_id(),questID);
        questCall.enqueue(new Callback<ListQuest>() {
            @Override
            public void onResponse(Call<ListQuest> call, Response<ListQuest> response) {
//                Toast.makeText(getBaseContext(), "BERHASIL BUKA QUEST : " + response.body().getQuestList().get(0).getQuest_name(), Toast.LENGTH_SHORT).show();
                final Quest listQuests = response.body().getQuestList().get(0);
                if (response.body().getQuestList().get(0).getIsDone() != 1) {
                    Call<String> doneCall = Global.mApi.setDoneQuest(Global.user.getUser_id(), questID);
                    doneCall.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(getBaseContext(), "Done Quest ID " + questID, Toast.LENGTH_SHORT).show();
                                System.out.println("Done Quest ID " + questID);
                                Call<String> addPointCall = Global.mApi.addPoint(Global.user.getUser_id(), listQuests.getQuest_point());
                                addPointCall.enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {

                                        if (response.isSuccessful()) {
                                            Toast.makeText(getBaseContext(), "Added Point", Toast.LENGTH_SHORT).show();

                                        } else {
                                            Toast.makeText(getBaseContext(), "FAILED " + response.errorBody(), Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                        Toast.makeText(getBaseContext(), "Failed to add point", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                Toast.makeText(getBaseContext(), "FAILED " + response.errorBody(), Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(getBaseContext(), "Failed Quest ID 2", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<ListQuest> call, Throwable t) {
                Toast.makeText(getBaseContext(), "ERROR : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("ERROR : " + t.getMessage().toString());
            }
        });
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
