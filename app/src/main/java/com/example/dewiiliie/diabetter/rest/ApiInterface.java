package com.example.dewiiliie.diabetter.rest;

import com.example.dewiiliie.diabetter.handler.GetFoods;
import com.example.dewiiliie.diabetter.handler.ListConsumeType;
import com.example.dewiiliie.diabetter.handler.ListConsumption;
import com.example.dewiiliie.diabetter.handler.LoginUser;
import com.example.dewiiliie.diabetter.handler.RegisterUser;
import com.example.dewiiliie.diabetter.handler.ResultConsumption;
import com.example.dewiiliie.diabetter.handler.UserInformation;
import com.example.dewiiliie.diabetter.model.Consumption;
import com.example.dewiiliie.diabetter.model.ListQuest;
import com.example.dewiiliie.diabetter.model.ListQuestCounter;
import com.example.dewiiliie.diabetter.model.Quest;
import com.example.dewiiliie.diabetter.model.TotalConsumptionUser;

import java.util.ArrayList;

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

    @GET("user_consumption_android/total_calories_user")
    Call<TotalConsumptionUser> getTotalCaloriesUser(
            @Query("user_id") int user_id
    );

    @GET("Quest_android/quest_by_user")
    Call<ListQuest> getQuestByUser(
            @Query("user_id") int user_id
    );

    @GET("Quest_android/check_user_quest")
    Call<ListQuestCounter> checkUserQuest(
            @Query("user_id") int user_id
    );


    @GET("Quest_android/quest")
    Call<ListQuest> getQuestSpesified(
            @Query("user_id") int user_id,
            @Query("quest_id") int quest_id
    );

    @GET("Quest_android/done_quest")
    Call<String> setDoneQuest(
            @Query("user_id") int user_id,
            @Query("quest_id") int quest_id
    );

    @GET("user_android/user_add_point")
    Call<String> addPoint(
            @Query("user_id") int user_id,
            @Query("point") int point
    );

    @GET("User_android/user_last_login")
    Call<String> lastLogin(
            @Query("user_id") int user_id
    );

    @GET("User_android/user_leaderboard")
    Call<LoginUser> getUsers();

    @GET("user_consumption_android/consumption_delete")
    Call<String> delete_consumption(
            @Query("user_id") int user_id,
            @Query("user_consumption_id") int user_consumption_id
    );

    @GET("User_android/first_quest")
    Call<String> first_quest(
            @Query("user_id") int user_id
    );

    @GET("user_android/change_password")
    Call<String> change_password(
            @Query("user_id") int user_id,
            @Query("password") String password
    );
}
