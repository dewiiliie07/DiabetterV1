package com.example.dewiiliie.diabetter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dewiiliie.diabetter.Service.Session;
import com.example.dewiiliie.diabetter.handler.LoginUser;
import com.example.dewiiliie.diabetter.model.User;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView tv_register;
    private ApiInterface mApiInterface;


    //    ProgressDialog loading;
    // TODO : install retrofit
    // Install retrofit will be done on partner's computer
    // Already added permission to use internet on this project
    @Override // Root
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences prefs = getSharedPreferences("Login", MODE_PRIVATE);

        if (!prefs.getString("user","").equals("")){

            System.out.println("SP : " + prefs.getString("user",""));
            Gson gson = new Gson();
            String json = prefs.getString("user", "");
            User obj = gson.fromJson(json, User.class);
            Global.user = obj;
            Intent i = new Intent(this, MenuUtama.class);
            startActivity(i);
            finish();
//            Toast.makeText(this, "Session berhasil", Toast.LENGTH_SHORT).show();
        }

//        session = new Session(this);
//        if (!session.getusename().equals("") || !session.getusename().isEmpty()){
//            System.out.println("SP DALEM : " + session.getusename());
//        }
//        System.out.println("SP ON CREATE : " + session.getusename());

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

//                                loading = ProgressDialog.show( null, "Harap Tunggu...", true, false);
                                Intent intent = new Intent(MainActivity.this,MenuUtama.class);
                                ArrayList<User> users = response.body().getUsers();
                                Bundle bundle = new Bundle();
                                System.out.println("COUNT USER : "+ users.size());
                                intent.putExtra("user",users);

                                final User user = users.get(0);
                                Global.user = user;

//                                if (user.getCounter_login()==0){
//                                    Toast.makeText(MainActivity.this, "PERTAMA LOGIN", Toast.LENGTH_SHORT).show();
//                                    Call<String> first = Global.mApi.first_quest(user.getUser_id());
//                                    try{
//                                        String result = first.execute().body();
//                                        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
//                                    }catch (Exception ex){
//                                        ex.printStackTrace();
//                                    }
//                                }

                                SharedPreferences.Editor editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
                                Gson gson = new Gson();
                                String json = gson.toJson(Global.user);
                                editor.putString("user",json);
                                editor.apply();



//                                String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.

//                                Toast.makeText(MainActivity.this, "User Id : " + user_id, Toast.LENGTH_SHORT).show();
//                                if (Global.user.getCounter_login()==0){
//                                    Call<String> f = Global.mApi.first_quest(Global.user.getUser_id());
//                                    try{
//                                        f.execute();
//                                    }catch (Exception ex){
//
//                                    }
//                                }
//                                Toast.makeText(MainActivity.this, users.get(0).getFull_name(), Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();
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
