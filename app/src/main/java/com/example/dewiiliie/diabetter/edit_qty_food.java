package com.example.dewiiliie.diabetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

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
    }
}
