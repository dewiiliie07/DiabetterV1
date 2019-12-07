package com.example.dewiiliie.diabetter.rest;

import com.example.dewiiliie.diabetter.handler.GetFoods;
import com.example.dewiiliie.diabetter.handler.ListConsumeType;
import com.example.dewiiliie.diabetter.handler.ListConsumption;
import com.example.dewiiliie.diabetter.handler.LoginUser;
import com.example.dewiiliie.diabetter.handler.RegisterUser;
import com.example.dewiiliie.diabetter.handler.ResultConsumption;
import com.example.dewiiliie.diabetter.handler.UserInformation;
import com.example.dewiiliie.diabetter.model.Consumption;
import com.example.dewiiliie.diabetter.model.Quest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    @GET("food_android")
    Call<GetFoods> getFoods();

    @GET("user_android")
    Call<UserInformation> getUser();

    @GET("user_consumption_android/food_consumption")
    Call<ListConsumption> getConsumption(
            @Query("user_id") int user_id,
            @Query("consumetype_id") int consumetype_id
    );

    @GET("user_consumption_android/food_consumption_by_user")
    Call<ListConsumption> getConsumptionByUser(
            @Query("user_id") int user_id
    );

    @FormUrlEncoded
    @POST("user_consumption_android/consumption_add")
    Call<ResultConsumption> addConsumption(
            @Field("user_id") int user_id,
            @Field("consumetype_id") int consumetype_id,
            @Field("serving_calories") int serving_calories,
            @Field("food_id") int food_id
    );

    @GET("consume_type_android")
    Call<ListConsumeType> getConsumeType();

    @GET("quest_android")
    Call<Quest> getQuest();

}
