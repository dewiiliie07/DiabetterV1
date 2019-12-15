package com.example.dewiiliie.diabetter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuestPagerAdaptor extends FragmentPagerAdapter {
//    int mCountTab;

    private List<Fragment> fragmentsList = new ArrayList<>();
    private List<String> fragmentTitle = new ArrayList<>();
//    private List<Fragment> fragmentList = new ArrayList<>();
//    private List<String> titleList = new ArrayList<>();

    public QuestPagerAdaptor(FragmentManager fm){
        super(fm);
//        this.mCountTab = CountTab;
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentsList.get(position);
//        switch (position){
//            case 0 :
//                return new DailyQuestFragment();
////                DailyQuestFragment tabOne  = new DailyQuestFragment();
////                return tabOne;
//
//            case 1 :
//                return new MainQuestFragment();
////                MainQuestFragment tabTwo = new MainQuestFragment();
////                return tabTwo;
//
//            default:
//                return null;
//        }
    }

    @Override
    public int getCount() {
//        return mCountTab;
        return fragmentsList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }

    public void addFragment (Fragment fragment, String title){
        fragmentsList.add(fragment);
        fragmentTitle.add(title);
    }


}
