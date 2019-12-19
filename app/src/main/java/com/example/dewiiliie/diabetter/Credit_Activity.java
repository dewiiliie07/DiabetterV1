package com.example.dewiiliie.diabetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Credit_Activity extends AppCompatActivity {

    private ImageView iv_back_buttom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_);
        iv_back_buttom = (ImageView) findViewById(R.id.back_button_credit);
        iv_back_buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
