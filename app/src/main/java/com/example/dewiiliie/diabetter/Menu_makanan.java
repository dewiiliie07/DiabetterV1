package com.example.dewiiliie.diabetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dewiiliie.diabetter.handler.GetFoods;
import com.example.dewiiliie.diabetter.model.Food;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Menu_makanan extends AppCompatActivity {

    private ArrayList<String> mFoodNames = new ArrayList<>();
    private ArrayList<String> mCalories = new ArrayList<>();
    private Button btn_confirm;
    private RecyclerView recyclerView;
    private ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_makanan);

        Toolbar toolbar = findViewById(R.id.toolbar_food_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Choose Your Food");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btn_confirm = (Button) findViewById(R.id.btn_confirm);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodAdapter.getFood();
                //FoodAdapter.addedFood;

                Intent intent = new Intent(getApplicationContext(), MenuUtama.class);
                startActivity(intent);
                //intent.putStringArrayListExtra("stock_list", stock_list);
                // OR masukin ke db
            }
        });
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

        Call<GetFoods> foodsCall = mApiInterface.getFoods();
        foodsCall.enqueue(new Callback<GetFoods>() {
            @Override
            public void onResponse(Call<GetFoods> call, Response<GetFoods>
                    response) {
                ArrayList<Food> foods = response.body().getFoods();
                for(Food food : foods){
                    mFoodNames.add(food.getName());
                    mCalories.add(Float.toString(food.getCalories()));
                }
                initRecycleView();
            }

            @Override
            public void onFailure(Call<GetFoods> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });

    }

    private void initRecycleView(){
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        FoodAdapter adapter = new FoodAdapter(this,mFoodNames,mCalories);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
