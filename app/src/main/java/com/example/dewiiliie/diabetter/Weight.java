package com.example.dewiiliie.diabetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Weight extends AppCompatActivity {
    String full_name, email, password, gender, birthdate;
    float height;

    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                full_name = extras.getString("FULLNAME");
                email = extras.getString("EMAIL");
                password = extras.getString("PASSWORD");
                gender = extras.getString("GENDER");
                birthdate = extras.getString("BIRTHDATE");
                height = extras.getFloat("HEIGHT");
            }
        } else{
            full_name = (String) savedInstanceState.getSerializable("FULLNAME");
            email = (String) savedInstanceState.getSerializable("EMAIL");
            password = (String) savedInstanceState.getSerializable("PASSWORD");
            gender = (String) savedInstanceState.getSerializable("GENDER");
            birthdate = (String) savedInstanceState.getSerializable("BIRTHDATE");
            height = (Float) savedInstanceState.getSerializable("HEIGHT");
        }

        Toolbar toolbar = findViewById(R.id.toolbar_weight);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DIABETTER");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText et_weight = (EditText) findViewById(R.id.et_weight);

        btnNext = (Button) findViewById(R.id.btn_next_to_jenis_aktivitas);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float weight = Float.parseFloat(et_weight.getText().toString());
                Intent intent = new Intent(Weight.this,JenisAktivitas.class);

                intent.putExtra("FULLNAME", full_name);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PASSWORD", password);
                intent.putExtra("GENDER", gender);
                intent.putExtra("BIRTHDATE", birthdate);
                intent.putExtra("HEIGHT", height);
                intent.putExtra("WEIGHT", weight);

                /*Toast.makeText(Weight.this,
                        full_name+" "+
                                email+" "+
                                password+" "+
                                gender+" "+
                                birthdate+" "+
                                height+" "+
                                weight
                        , Toast.LENGTH_SHORT).show();*/
                startActivity(intent);
                finish();
            }
        });
    }
}
