package com.example.dewiiliie.diabetter;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.dewiiliie.diabetter.Global.user;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener{

    View v;
    ListView listView;
    ArrayList<String> listMenuProfile;
    ArrayAdapter <String> profileAdapter;
    private TextView level_user;
    private TextView nama_user;
    private ProgressBar progressBar;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_profile,container,false);

        Button btnAcv = (Button) v.findViewById(R.id.btn_acv);
//        Button btnNotif = (Button) v.findViewById(R.id.btn_notif);
//        Button btnSetting = (Button) v.findViewById(R.id.btn_setting);
        Button btnTutorial = (Button) v.findViewById(R.id.btn_tutorial);
        Button btnChangePassword = (Button) v.findViewById(R.id.btn_change_password);
        Button btnLogout = (Button) v.findViewById(R.id.btn_logout);
        Button btnCredit = (Button) v.findViewById(R.id.btn_credit);
        level_user = (TextView) v.findViewById(R.id.level_user);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        nama_user = (TextView) v.findViewById(R.id.tv_nama_customer);

        if (user.getGender() == 'M'){
            nama_user.setText("Mr. " + user.getFull_name());
        }
        else if(user.getGender() == 'F')
        {
            nama_user.setText("Ms. " +user.getFull_name());
        }
        level_user.setText(Global.level(Global.user.getPoints()));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            progressBar.setMin(0);
            progressBar.setProgress(Global.user.getPoints());
            progressBar.setMax(Integer.parseInt(Global.getMaxLevel(Global.user.getPoints())));
        }


        btnAcv.setOnClickListener(this);
        btnTutorial.setOnClickListener(this);
        btnChangePassword.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
        btnCredit.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_acv :
//                AchievementFragment achievementFragment = new AchievementFragment();
//                FragmentTransaction frAcv = getFragmentManager().beginTransaction();
//                frAcv.replace(R.id.main_frame, achievementFragment);
//                frAcv.commit();
                Intent i = new Intent(getContext(),AchievementActivity.class);
                startActivity(i);
                break;
            case R.id.btn_tutorial :
                Intent i2 = new Intent(getContext(),Tutorial.class);
                startActivity(i2);
                break;
            case R.id.btn_change_password :
                Intent i3 = new Intent(getContext(),Change_Password_Activity.class);
                startActivity(i3);
                break;
            case R.id.btn_logout :
                SharedPreferences.Editor editor = getContext().getSharedPreferences("Login", MODE_PRIVATE).edit();
                Gson gson = new Gson();
                String json = "";
                editor.putString("user",json);
                editor.apply();
                startActivity(new Intent(getContext(),MainActivity.class));
                getActivity().finish();
//                Intent i4 = new Intent(getContext(),Logout_Activity.class);
//                startActivity(i4);
                break;
            case R.id.btn_credit :
                Intent i5 = new Intent(getContext(),Credit_Activity.class);
                startActivity(i5);
                break;
        }
    }
}
