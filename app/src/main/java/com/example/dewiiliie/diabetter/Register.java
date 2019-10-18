package com.example.dewiiliie.diabetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText et_full_name = (EditText) findViewById(R.id.et_full_name);
        final EditText et_email = (EditText) findViewById(R.id.et_email);
        final EditText et_password = (EditText) findViewById(R.id.et_password);

        Toolbar toolbar = findViewById(R.id.toolbar_register);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DIABETTER");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_next = (Button) findViewById(R.id.btn_next_to_gender);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String full_name = et_full_name.getText().toString();
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                Intent intent = new Intent(Register.this,Gender.class);
                intent.putExtra("FULLNAME", full_name);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PASSWORD", password);

                startActivity(intent);
                finish();
            }
        });
    }
}
