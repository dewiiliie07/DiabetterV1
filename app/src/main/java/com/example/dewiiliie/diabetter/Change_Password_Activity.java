package com.example.dewiiliie.diabetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Change_Password_Activity extends AppCompatActivity {

    private EditText et_old, et_new, et_confirm;
    private Button btnChange;
    private ImageView iv_back_buttom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__password_);
        et_old = (EditText) findViewById(R.id.et_old);
        et_new = (EditText) findViewById(R.id.et_new);
        et_confirm = (EditText) findViewById(R.id.et_confirm);
        btnChange = (Button) findViewById(R.id.btn_change_password);
        iv_back_buttom = (ImageView) findViewById(R.id.back_button_change_profile);
        iv_back_buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Password lama : " + Global.user.getPassword());
                if (et_old.getText().toString().equals(Global.user.getPassword())){
                    if(et_new.getText().toString().equals(et_confirm.getText().toString())){
                        Toast.makeText(Change_Password_Activity.this, "Berhasil ubah password", Toast.LENGTH_SHORT).show();
                        Call<String> changeCall = Global.mApi.change_password(Global.user.getUser_id(),et_new.getText().toString());
                        changeCall.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if (response.isSuccessful()){
                                    Toast.makeText(Change_Password_Activity.this, "Berhasil ubah password!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Change_Password_Activity.this, MenuUtama.class));
                                    finish();
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                    }
                    else {
                        Toast.makeText(Change_Password_Activity.this, "Password baru berbeda", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Change_Password_Activity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
