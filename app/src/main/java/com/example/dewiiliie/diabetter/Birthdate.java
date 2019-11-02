package com.example.dewiiliie.diabetter;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Birthdate extends AppCompatActivity {
    String full_name, email, password;

    private Button btnNext;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthdate);

        mDisplayDate = (TextView) findViewById(R.id.tv_birthdate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Birthdate.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                full_name = extras.getString("FULLNAME");
                email = extras.getString("EMAIL");
                password = extras.getString("PASSWORD");
            }
        } else{
            full_name = (String) savedInstanceState.getSerializable("FULLNAME");
            email = (String) savedInstanceState.getSerializable("EMAIL");
            password = (String) savedInstanceState.getSerializable("PASSWORD");
        }


        Toolbar toolbar = findViewById(R.id.toolbar_birthdate);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DIABETTER");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnNext = (Button) findViewById(R.id.btn_next_to_tall);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Birthdate.this,Tall.class);
                intent.putExtra("FULLNAME", full_name);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PASSWORD", password);
                intent.putExtra("BIRTHDATE", "2019-10-09");
                startActivity(intent);
                finish();
            }
        });

    }
}