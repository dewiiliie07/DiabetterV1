package com.example.dewiiliie.diabetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

public class Menu_makanan extends AppCompatActivity {

    private ArrayList<String> mFoodNames = new ArrayList<>();
    private ArrayList<String> mCalories = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_makanan);

        Toolbar toolbar = findViewById(R.id.toolbar_food_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Choose Your Food");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        initFoodList();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void initFoodList(){
        mFoodNames.add("Jagung Rebus");
        mCalories.add("90,2");

        mFoodNames.add("Kentang Rebus");
        mCalories.add("166");

        mFoodNames.add("Ketan Putih");
        mCalories.add("217");

        mFoodNames.add("Ketupat");
        mCalories.add("32");

        mFoodNames.add("Lontong");
        mCalories.add("38");

        mFoodNames.add("Nasi Putih");
        mCalories.add("175");

        mFoodNames.add("Bubur");
        mCalories.add("44");

        mFoodNames.add("Makaroni");
        mCalories.add("91");

        initRecycleView();
    }

    private void initRecycleView(){
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        FoodAdapter adapter = new FoodAdapter(this,mFoodNames,mCalories);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
