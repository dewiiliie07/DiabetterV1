package com.example.dewiiliie.diabetter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    View v;
    private RecyclerView recyclerView;
    private ArrayList<Model> addFoodList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_home,container,false);

        recyclerView = (RecyclerView) v.findViewById(R.id.rv_add_food) ;
//        recyclerView = recyclerView.findViewById(R.id.rv_add_food);
        Adapter adapter = new Adapter(getContext(),addFoodList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        recyclerView.setAdapter(adapter);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addFoodList = new ArrayList<>();

        addFoodList.add(new Model(R.drawable.base_add_food,"Today's Breakfast","Add Food"));
        addFoodList.add(new Model(R.drawable.base_add_food,"Today's Breakfast Snacks","Add Food"));
        addFoodList.add(new Model(R.drawable.base_add_food,"Today's Lunch","Add Food"));
        addFoodList.add(new Model(R.drawable.base_add_food,"Today's Lunch Snacks","Add Food"));
        addFoodList.add(new Model(R.drawable.base_add_food,"Today's Dinner","Add Food"));

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
//
//        recyclerView.setLayoutManager(rvLiLayoutManager);
//
//        Adapter adapter = new Adapter(this,addFoodList);
//
//        recyclerView.setAdapter(adapter);
    }
}
