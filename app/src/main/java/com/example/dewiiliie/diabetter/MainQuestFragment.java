package com.example.dewiiliie.diabetter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dewiiliie.diabetter.model.ListQuest;
import com.example.dewiiliie.diabetter.model.Quest;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainQuestFragment extends Fragment {
    View v;
    ArrayList<Quest> quests = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_main_quest, container, false);

        final RecyclerView recyclerView = v.findViewById(R.id.rv_main_quest);
        ApiInterface mApi = ApiClient.getClient().create(ApiInterface.class);

        Call<ListQuest> questCall = mApi.getQuestByUser(Global.user.getUser_id());
        questCall.enqueue(new Callback<ListQuest>() {
            @Override
            public void onResponse(Call<ListQuest> call, Response<ListQuest> response) {
                quests = response.body().getQuestList();

                ArrayList<Quest> dailyQuest = new ArrayList<>();
                for (Quest q:quests) {
                    if (q.getQuest_type()==2){
                        dailyQuest.add(q);
                    }
                }

                DailyQuestAdapter adapter = new DailyQuestAdapter(getContext(),dailyQuest);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListQuest> call, Throwable t) {

            }
        });

        return v;
    }
}
