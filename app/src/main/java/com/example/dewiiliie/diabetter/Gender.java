package com.example.dewiiliie.diabetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class Gender extends AppCompatActivity {
    String full_name, email, password, birthdate;
    float height, weight;

    private Button btnNext, btnMale, btnFemale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                full_name = extras.getString("FULLNAME");
                email = extras.getString("EMAIL");
                password = extras.getString("PASSWORD");
                //birthdate = extras.getString("BIRTHDATE");
                //height = extras.getFloat("HEIGHT");
                //weight = extras.getFloat("WEIGHT");
            }
        } else{
            full_name = (String) savedInstanceState.getSerializable("FULLNAME");
            email = (String) savedInstanceState.getSerializable("EMAIL");
            password = (String) savedInstanceState.getSerializable("PASSWORD");
            //birthdate = (String) savedInstanceState.getSerializable("BIRTHDATE");
            //height = (Float) savedInstanceState.getSerializable("HEIGHT");
            //weight = (Float) savedInstanceState.getSerializable("WEIGHT");
        }

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_gender);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DIABETTER");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnMale = (Button) findViewById(R.id.btn_male);
        btnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gender.this,Birthdate.class);
                intent.putExtra("FULLNAME", full_name);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PASSWORD", password);
                intent.putExtra("GENDER", "M");
                /*intent.putExtra("BIRTHDATE", birthdate);
                intent.putExtra("HEIGHT", height);
                intent.putExtra("WEIGHT", weight);*/

//                Toast.makeText(Gender.this,full_name+" "+email+ " "+password,Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });

        btnFemale = (Button) findViewById(R.id.btn_female);
        btnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gender.this,Birthdate.class);
                intent.putExtra("FULLNAME", full_name);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PASSWORD", password);
                intent.putExtra("GENDER", "F");
                /*intent.putExtra("BIRTHDATE", birthdate);
                intent.putExtra("HEIGHT", height);
                intent.putExtra("WEIGHT", weight);*/

                //Toast.makeText(Gender.this,"Female",Toast.LENGTH_SHORT).show();
                Toast.makeText(Gender.this,full_name+" "+email+ " "+password,Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

//        btnNext = (Button) findViewById(R.id.btn_next_to_birthdate);
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Gender.this,Birthdate.class);
//
//                intent.putExtra("FULLNAME", full_name);
//                intent.putExtra("EMAIL", email);
//                intent.putExtra("PASSWORD", password);
//                intent.putExtra("BIRTHDATE", birthdate);
//                intent.putExtra("HEIGHT", height);
//                intent.putExtra("WEIGHT", weight);
//                intent.putExtra("GENDER", "M");
//                startActivity(intent);
//                finish();
//            }
//        });
    }
}