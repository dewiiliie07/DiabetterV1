package com.example.dewiiliie.diabetter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuestPagerAdaptor extends FragmentStatePagerAdapter {
    int mCountTab;

    private final ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();
//    private List<Fragment> fragmentList = new ArrayList<>();
//    private List<String> titleList = new ArrayList<>();

    public QuestPagerAdaptor(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

//        Fragment fragment = null;
//
//        switch (position){
//
//            case 0 :
//                fragment  = new DailyQuestFragment();
//                break;
//
//            case 1 :
//                MainQuestFragment tabTwo = new MainQuestFragment();
//                return tabTwo;
//        }

        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
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
