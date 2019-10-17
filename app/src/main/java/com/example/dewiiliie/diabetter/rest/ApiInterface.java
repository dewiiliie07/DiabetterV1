package com.example.dewiiliie.diabetter.rest;

import com.example.dewiiliie.diabetter.handler.LoginUser;
import com.example.dewiiliie.diabetter.handler.RegisterUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("user_android")
    Call<RegisterUser> postUser(
            @Field("full_name") String full_name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("birthdate") String birthdate,
            @Field("height") float height,
            @Field("weight") float weight,
            @Field("gender") String gender,
            @Field("activity_level") String activity_level
    );

    @FormUrlEncoded
    @POST("user_android/login")
    Call<LoginUser> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );
}
