package com.example.dewiiliie.diabetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dewiiliie.diabetter.handler.LoginUser;
import com.example.dewiiliie.diabetter.model.User;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView tv_register;
    private ApiInterface mApiInterface;
    // TODO : install retrofit
    // Install retrofit will be done on partner's computer
    // Already added permission to use internet on this project
    @Override // Root
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        final EditText et_username = (EditText) findViewById(R.id.et_username);
        final EditText et_password = (EditText) findViewById(R.id.et_password);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        button = (Button) findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
//                Intent intent = new Intent(MainActivity.this,MenuUtama.class);
                //startActivity(intent);
                if(username.equals(null) || username.equals("") || password.equals(null) || password.equals("")){
                    Toast.makeText(MainActivity.this, "Email/password is empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Call<LoginUser> login = mApiInterface.loginUser(username, password);
                    login.enqueue(new Callback<LoginUser>() {
                        @Override
                        public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                            //String code = Integer.toString(response.code());
                            //Toast.makeText(MainActivity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                            String status = response.body().getStatus();
                            if(status.equals("success")){
                                Intent intent = new Intent(MainActivity.this,MenuUtama.class);
                                ArrayList<User> users = response.body().getUsers();
                                Bundle bundle = new Bundle();
                                System.out.println("COUNT USER : "+ users.size());
                                intent.putExtra("user",users);
//                                Toast.makeText(MainActivity.this, users.get(0).getFull_name(), Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Invalid email/password", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginUser> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Something went wrong on server", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

        tv_register = (TextView) findViewById(R.id.tv_register);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }

//    public void openActivity2(){
//        Intent intent = new Intent(this, MenuUtama.class);
//        startActivity(intent);
//    }
}
