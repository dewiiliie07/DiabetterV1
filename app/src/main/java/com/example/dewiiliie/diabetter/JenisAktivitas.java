package com.example.dewiiliie.diabetter;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class JenisAktivitas extends AppCompatActivity implements View.OnClickListener{
    String full_name, email, password, birthdate, gender;
    float height, weight;

    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_aktivitas);


        Button btnIstirahat = (Button) findViewById(R.id.btn_istirahat);
        Button btnRingan = (Button) findViewById(R.id.btn_ringan);
        Button btnSedang = (Button) findViewById(R.id.btn_sedang);
        Button btnBerat = (Button) findViewById(R.id.btn_berat);
        Button btnSangatBerat = (Button) findViewById(R.id.btn_sangat_berat);

        btnIstirahat.setOnClickListener(this);
        btnRingan.setOnClickListener(this);
        btnSedang.setOnClickListener(this);
        btnBerat.setOnClickListener(this);
        btnSangatBerat.setOnClickListener(this);

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
            }
        } else{
            full_name = (String) savedInstanceState.getSerializable("FULLNAME");
            email = (String) savedInstanceState.getSerializable("EMAIL");
            password = (String) savedInstanceState.getSerializable("PASSWORD");
            birthdate = (String) savedInstanceState.getSerializable("BIRTHDATE");
            height = (Float) savedInstanceState.getSerializable("HEIGHT");
            weight = (Float) savedInstanceState.getSerializable("WEIGHT");
            gender = (String) savedInstanceState.getSerializable("GENDER");
        }

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_jenis_aktivitas);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DIABETTER");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        btnNext = (Button) findViewById(R.id.btn_next_to_term);
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(JenisAktivitas.this,TermCondition.class);
//
//                intent.putExtra("FULLNAME", full_name);
//                intent.putExtra("EMAIL", email);
//                intent.putExtra("PASSWORD", password);
//                intent.putExtra("BIRTHDATE", birthdate);
//                intent.putExtra("HEIGHT", height);
//                intent.putExtra("WEIGHT", weight);
//                intent.putExtra("GENDER", "M");
//                intent.putExtra("ACTIVITY_LEVEL", "R");
//
//                startActivity(intent);
//                finish();
//            }
//        });
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_istirahat :
                Toast.makeText(this, "Istirahat", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(JenisAktivitas.this, TermCondition.class);
                startActivity(i);
                break;
            case R.id.btn_ringan :
                Toast.makeText(this, "Ringan", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(JenisAktivitas.this, TermCondition.class);
                startActivity(i2);
                break;
            case R.id.btn_sedang :
                Toast.makeText(this, "Sedang", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(JenisAktivitas.this, TermCondition.class);
                startActivity(i3);
                break;
            case R.id.btn_berat :
                Toast.makeText(this, "Berat", Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(JenisAktivitas.this, TermCondition.class);
                startActivity(i4);
                break;
            case R.id.btn_sangat_berat :
                Toast.makeText(this, "Sangat Berat", Toast.LENGTH_SHORT).show();
                Intent i5 = new Intent(JenisAktivitas.this, TermCondition.class);
                startActivity(i5);
                break;
        }
    }

}
