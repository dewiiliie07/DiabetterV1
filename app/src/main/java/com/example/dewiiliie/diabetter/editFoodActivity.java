package com.example.dewiiliie.diabetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;

import com.example.dewiiliie.diabetter.Interface.FoodInterface;
import com.example.dewiiliie.diabetter.model.Food;

import java.util.ArrayList;

public class editFoodActivity extends AppCompatActivity implements FoodInterface {

    private ArrayList<Food> mFood = new ArrayList<>();
    private ArrayList<String> mCalories = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public void onAddFood(int foodID, int serving_calories) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);

        Toolbar toolbar = findViewById(R.id.toolbar_edit_food);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Your Food");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void initFoodList(){
//        mFoodNames.add("Jagung Rebus");
//        mCalories.add("90.2");
//
//        mFoodNames.add("Kentang Rebus");
//        mCalories.add("166");
//
//        mFoodNames.add("Ketan Putih");
//        mCalories.add("217");
//
//        mFoodNames.add("Ketupat");
//        mCalories.add("32");
//
//        mFoodNames.add("Lontong");
//        mCalories.add("38");
//
//        mFoodNames.add("Nasi Putih");
//        mCalories.add("175");
//
//        mFoodNames.add("Bubur");
//        mCalories.add("44");
//
//        mFoodNames.add("Makaroni");
//        mCalories.add("91");

        initRecycleView();
    }

    private void initRecycleView(){
        RecyclerView recyclerView = findViewById(R.id.rv_edit_food);
        FoodAdapter adapter = new FoodAdapter(this,mFood,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
