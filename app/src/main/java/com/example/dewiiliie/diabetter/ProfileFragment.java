package com.example.dewiiliie.diabetter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener{

    View v;
    ListView listView;
    ArrayList<String> listMenuProfile;
    ArrayAdapter <String> profileAdapter;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_profile,container,false);

        Button btnAcv = (Button) v.findViewById(R.id.btn_acv);
        Button btnNotif = (Button) v.findViewById(R.id.btn_notif);
        Button btnSetting = (Button) v.findViewById(R.id.btn_setting);
        Button btnHelp = (Button) v.findViewById(R.id.btn_help);
        Button btnCredit = (Button) v.findViewById(R.id.btn_credit);

        btnAcv.setOnClickListener(this);
        btnNotif.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
        btnHelp.setOnClickListener(this);
        btnCredit.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_acv :
                AchievementFragment achievementFragment = new AchievementFragment();
                FragmentTransaction frAcv = getFragmentManager().beginTransaction();
                frAcv.replace(R.id.main_frame, achievementFragment);
                frAcv.commit();
                break;
            case R.id.btn_notif :
                NotificationFragment notificationFragment = new NotificationFragment();
                FragmentTransaction frNotif = getFragmentManager().beginTransaction();
                frNotif.replace(R.id.main_frame, notificationFragment);
                frNotif.commit();
                break;
//            case R.id.btn_setting :
//                SettingFragment settingFrgment = new SettingFragment();
//                FragmentTransaction frSetting = getFragmentManager().beginTransaction();
//                frSetting.replace(R.id.main_frame, settingFrgment);
//                frSetting.commit();
//                break;
//            case R.id.btn_setting :
//                SettingFragment settingFrgment = new SettingFragment();
//                FragmentTransaction frSetting = getFragmentManager().beginTransaction();
//                frSetting.replace(R.id.main_frame, settingFrgment);
//                frSetting.commit();
//                break;
//                Intent in = new Intent(getActivity(),SettingActivity.class);
//                startActivity(in);
//                break;
            case R.id.btn_help :
                HelpFragment helpFragment = new HelpFragment();
                FragmentTransaction frHelp = getFragmentManager().beginTransaction();
                frHelp.replace(R.id.main_frame, helpFragment);
                frHelp.commit();
                break;
            case R.id.btn_credit :
                CreditFragment creditFragment = new CreditFragment();
                FragmentTransaction frCredit = getFragmentManager().beginTransaction();
                frCredit.replace(R.id.main_frame, creditFragment);
                frCredit.commit();
                break;
        }
    }
}
