package com.example.dewiiliie.diabetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class edit_qty_food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_qty_food);

        Toolbar toolbar = findViewById(R.id.toolbar_food_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Choose Your Food");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        TextView tv_Food_Name = (TextView) findViewById(R.id.tv_food_choosen);
//        TextView tv_calories = (TextView) findViewById(R.id.tv_calories_choosen);
//        TextView tv_edit_gram = (TextView) findViewById(R.id.tv_food_weight);

        getIncomingIntent();

    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("food_name") && getIntent().hasExtra("calories")){
            String foodName = getIntent().getStringExtra("food_name");
            String calories = getIntent().getStringExtra("calories");

            setEditFood(foodName,calories);
        }
    }

    private void setEditFood(String foodName, String calories){
        TextView tv_Food_Name = (TextView) findViewById(R.id.tv_food_choosen);
        tv_Food_Name.setText(foodName);

        TextView tv_calories = (TextView) findViewById(R.id.tv_calories_choosen);
        tv_calories.setText(calories);
    }
}
