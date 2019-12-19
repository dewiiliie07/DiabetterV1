package com.example.dewiiliie.diabetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dewiiliie.diabetter.Interface.FoodInterface;
import com.example.dewiiliie.diabetter.model.Consumption;
import com.example.dewiiliie.diabetter.model.Food;
import com.example.dewiiliie.diabetter.model.FoodConsumed;

import java.util.ArrayList;

public class editFoodActivity extends AppCompatActivity implements FoodInterface {

    private ArrayList<Food> mFood = new ArrayList<>();
    private ArrayList<String> mCalories = new ArrayList<>();
    private RecyclerView recyclerView;
    private ArrayList<Consumption> consumptions = new ArrayList<>();
    private Button btnConfirm;

    @Override
    public void onAddFood(int foodID, int serving_calories) {

    }

    @Override
    public void onAddCalories(double calories) {

    }

    @Override
    public void totalCalories(double totalCalory) {

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MenuUtama.class);
        startActivity(i);
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);

        btnConfirm = (Button) findViewById(R.id.btn_confirm_edit_food) ;
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MenuUtama.class);
                startActivity(i);
                finish();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar_edit_food);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Your Food");
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Bundle bundle = this.getIntent().getExtras();
        if (bundle!=null){
            ArrayList<Consumption> tempCon = (ArrayList<Consumption>) bundle.getSerializable("user_consumption");
            consumptions.addAll((ArrayList<Consumption>) bundle.getSerializable("user_consumption"));
            Toast.makeText(this, "ADA MAKANAN : " + consumptions.size(), Toast.LENGTH_SHORT).show();
        }

        ArrayList<Food> foods = new ArrayList<>();
        for (Consumption c : consumptions){
            Food f = new Food(c.getFood_id(),c.getFoodname(), c.getCalories(), c.getServing_calory());
            foods.add(f);
        }

        RecyclerView recyclerView = findViewById(R.id.rv_edit_food);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        EditFoodAdapter editFoodAdapter = new EditFoodAdapter( this,consumptions);
        recyclerView.setAdapter(editFoodAdapter);


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
