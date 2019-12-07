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

import com.example.dewiiliie.diabetter.Interface.FoodInterface;
import com.example.dewiiliie.diabetter.handler.GetFoods;
import com.example.dewiiliie.diabetter.handler.ResultConsumption;
import com.example.dewiiliie.diabetter.model.Food;
import com.example.dewiiliie.diabetter.model.FoodConsumed;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Menu_makanan extends AppCompatActivity implements FoodInterface {

    private ArrayList<String> mFoodNames = new ArrayList<>();
    private ArrayList<String> mCalories = new ArrayList<>();
    private Button btn_confirm;
    private RecyclerView recyclerView;
    private ApiInterface mApiInterface;
    private int[] foodconsumeds;
    private int consumetype_id;
    private ArrayList<Food> foods = new ArrayList<>();
//    private ArrayList<FoodConsumed> foodConsumeds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_makanan);

        Toolbar toolbar = findViewById(R.id.toolbar_food_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Choose Your Food");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                consumetype_id= 890321;
            } else {
                consumetype_id= extras.getInt("consumetype_id");
            }
        }
        else {
            consumetype_id= (int) savedInstanceState.getSerializable("consumetype_id");
        }
        System.out.println("CONSUMETYPE_ID " + consumetype_id);

//        consumetype_id = getIntent().getIntExtra("consumetype_id");

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btn_confirm = (Button) findViewById(R.id.btn_confirm);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FoodAdapter.getFood();
                //FoodAdapter.addedFood;

//                Intent intent = new Intent(getApplicationContext(), MenuUtama.class);
//                startActivity(intent);
                for(int i = 0 ; i< foodconsumeds.length;i++){
                    final int count= i;
                    if (foodconsumeds[i] != 0 && consumetype_id !=890321){

                        Call<ResultConsumption> foodAdd =  mApiInterface.addConsumption(Global.user.getId(),consumetype_id,foodconsumeds[i],i);
                        foodAdd.enqueue(new Callback<ResultConsumption>() {
                            @Override
                            public void onResponse(Call<ResultConsumption> call, Response<ResultConsumption> response) {
                                ResultConsumption result = response.body();
                                Toast.makeText(getApplicationContext(), result+" ADD FOOD : " + String.valueOf(count),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<ResultConsumption> call, Throwable t) {
                                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_SHORT).show();
                                System.out.println("ERROR : " + t.toString());
                            }
                        });
                    }
                }
                Intent i = new Intent(getApplicationContext(),MenuUtama.class);
                startActivity(i);
//                onBackPressed();

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
                foods = response.body().getFoods();
                foodconsumeds = new int[foods.size()];
                Arrays.fill(foodconsumeds,0);
//                for(Food food : foods){
//                    mFoodNames.add(food.getName());
//                    mCalories.add(Float.toString(food.getCalories()));
//                }
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
        FoodAdapter adapter = new FoodAdapter(this,foods,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onAddFood(int foodID, int serving_calories) {
        foodconsumeds[foodID] = serving_calories;
        System.out.println("CALORIES : "+foodconsumeds[foodID] + " DARI FOOD ID : " + foodID);
//        foodConsumeds.get(foodID).setConsumetype_id(consumetypeID);
//        foodConsumeds.get(foodID).setServing_calories(serving_calories);
//        foodConsumeds.get(foodID).setConsumetype_id();
    }
}
