package com.example.dewiiliie.diabetter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dewiiliie.diabetter.handler.LoginUser;
import com.example.dewiiliie.diabetter.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeaderboardFragment extends Fragment {

    View v;

    public LeaderboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        final TextView rank1 = (TextView) v.findViewById(R.id.name_1);
        final TextView rank2 = (TextView) v.findViewById(R.id.name_2);
        final TextView rank3 = (TextView) v.findViewById(R.id.name_3);

        Call<LoginUser> loginUserCall = Global.mApi.getUsers();
        loginUserCall.enqueue(new Callback<LoginUser>() {
            @Override
            public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                ArrayList<User> users = response.body().getUsers();
                rank1.setText(users.get(0).getFull_name());
                rank2.setText(users.get(1).getFull_name());
                rank3.setText(users.get(2).getFull_name());
            }

            @Override
            public void onFailure(Call<LoginUser> call, Throwable t) {

            }
        });
        // Inflate the layout for this fragment
        return v;





    }

}
