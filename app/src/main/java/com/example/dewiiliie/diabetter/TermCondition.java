package com.example.dewiiliie.diabetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dewiiliie.diabetter.handler.RegisterUser;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TermCondition extends AppCompatActivity {
    String full_name, email, password, birthdate, gender, activity_level;
    float height, weight;
    ApiInterface mApiInterface;

    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_condition);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                full_name = extras.getString("FULLNAME");
                email = extras.getString("EMAIL");
                password = extras.getString("PASSWORD");
                birthdate = extras.getString("BIRTHDATE");
                height = extras.getFloat("HEIGHT");
                weight = extras.getFloat("WEIGHT");
                gender = extras.getString("GENDER");
                activity_level = extras.getString("ACTIVITY_LEVEL");
            }
        } else{
            full_name = (String) savedInstanceState.getSerializable("FULLNAME");
            email = (String) savedInstanceState.getSerializable("EMAIL");
            password = (String) savedInstanceState.getSerializable("PASSWORD");
            birthdate = (String) savedInstanceState.getSerializable("BIRTHDATE");
            height = (Float) savedInstanceState.getSerializable("HEIGHT");
            weight = (Float) savedInstanceState.getSerializable("WEIGHT");
            gender = (String) savedInstanceState.getSerializable("GENDER");
            activity_level = (String) savedInstanceState.getSerializable("ACTIVITY_LEVEL");
        }

        Toolbar toolbar = findViewById(R.id.toolbar_term);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DIABETTER");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnNext = (Button) findViewById(R.id.btn_next_to_home);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(TermCondition.this,MenuUtama.class);
                /*Toast.makeText(TermCondition.this,
                        full_name+" "
                        +email+" "
                        +password+" "
                        +birthdate+" "
                        +height+" "
                        +weight+" "
                        +gender+" "
                        +activity_level,
                        Toast.LENGTH_SHORT).show();*/
                mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<RegisterUser> postRegUsers = mApiInterface.postUser(
                        full_name,
                        email,
                        password,
                        birthdate,
                        height,
                        weight,
                        gender,
                        activity_level
                );

                postRegUsers.enqueue(new Callback<RegisterUser>() {
                    @Override
                    public void onResponse(Call<RegisterUser> call, Response<RegisterUser> response) {
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<RegisterUser> call, Throwable t) {
                        Toast.makeText(TermCondition.this, t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                //startActivity(intent);
                //finish();
            }
        });
    }
}