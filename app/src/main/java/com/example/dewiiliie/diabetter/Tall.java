package com.example.dewiiliie.diabetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tall extends AppCompatActivity {
    String full_name, email, password, gender, birthdate;

    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tall);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                full_name = extras.getString("FULLNAME");
                email = extras.getString("EMAIL");
                password = extras.getString("PASSWORD");
                gender = extras.getString("GENDER");
                birthdate = extras.getString("BIRTHDATE");
            }
        } else{
            full_name = (String) savedInstanceState.getSerializable("FULLNAME");
            email = (String) savedInstanceState.getSerializable("EMAIL");
            password = (String) savedInstanceState.getSerializable("PASSWORD");
            gender = (String) savedInstanceState.getSerializable("GENDER");
            birthdate = (String) savedInstanceState.getSerializable("BIRTHDATE");
        }

        final EditText et_height = (EditText) findViewById(R.id.et_height);

        Toolbar toolbar = findViewById(R.id.toolbar_tall);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DIABETTER");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnNext = (Button) findViewById(R.id.btn_next_to_weight);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float height = Float.parseFloat(et_height.getText().toString());

                Intent intent = new Intent(Tall.this,Weight.class);

                intent.putExtra("FULLNAME", full_name);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PASSWORD", password);
                intent.putExtra("GENDER", gender);
                intent.putExtra("BIRTHDATE", birthdate);
                intent.putExtra("HEIGHT", height);

//                Toast.makeText(Tall.this,
//                        full_name+" "+
//                                email+" "+
//                                password+" "+
//                                gender+" "+
//                                birthdate+" "+
//                                height
//                        , Toast.LENGTH_SHORT).show();

                startActivity(intent);
                finish();
            }
        });
    }
}
