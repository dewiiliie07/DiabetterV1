package com.example.dewiiliie.diabetter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestFragment extends Fragment {

    View v;

    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_quest, container, false);

//        setupViewPager(viewPager);

//      TAB LAYOUT
        tabLayout = v.findViewById(R.id.tab_quest);
        tabLayout.addTab(tabLayout.newTab().setText("Daily Quest"));
        tabLayout.addTab(tabLayout.newTab().setText("Main Quest"));

        //VIEW PAGER
        viewPager = v.findViewById(R.id.vp_quest);
//        QuestPagerAdaptor adapter = new QuestPagerAdaptor(getFragmentManager());
//        adapter.addFragment(new DailyQuestFragment(),"One");
//        adapter.addFragment(new MainQuestFragment(),"Two");
//        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.addTab(tabLayout.newTab().setText("Daily Quest"));
//        tabLayout.addTab(tabLayout.newTab().setText("Main Quest"));

//        QuestPagerAdaptor adapter = new QuestPagerAdaptor(getChildFragmentManager());
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){

        super.onActivityCreated(savedInstanceState);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        QuestPagerAdaptor adapter = new QuestPagerAdaptor(getChildFragmentManager());
        adapter.addFragment(new DailyQuestFragment(),"Daily");
        adapter.addFragment(new MainQuestFragment(),"Main");
        viewPager.setAdapter(adapter);
     }


}
