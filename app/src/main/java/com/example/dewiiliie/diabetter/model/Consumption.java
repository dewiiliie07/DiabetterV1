package com.example.dewiiliie.diabetter.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Consumption implements Serializable {
    @SerializedName("full_name")
    private String fullname;
    @SerializedName("serving_calories")
    private int serving_calories;
    @SerializedName("serving_calory")
    private int serving_calory;
    @SerializedName("calories")
    private float calories;
    @SerializedName("food_name")
    private String foodname;
    @SerializedName("consumetype_id")
    private int consumetypeID;
    @SerializedName("consumetype_name")
    private String consumetypeName;
    @SerializedName("user_consumption_id")
    private int user_consumption_id;
    @SerializedName("food_id")
    private int food_id;

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public Consumption(String fullname, int serving_calories, int serving_calory, float calories, String foodname, int consumetypeID, String consumetypeName) {
        this.fullname = fullname;
        this.serving_calories = serving_calories;
        this.serving_calory = serving_calory;
        this.calories = calories;
        this.foodname = foodname;
        this.consumetypeID = consumetypeID;
        this.consumetypeName = consumetypeName;
    }

    public String getFullname() {
        return fullname;
    }

    public int getServing_calories() {
        return serving_calories;
    }

    public int getServing_calory() {
        return serving_calory;
    }

    public String getFoodname() {
        return foodname;
    }

    public int getConsumetypeID() {
        return consumetypeID;
    }

    public String getConsumetypeName() {
        return consumetypeName;
    }

    public float getCalories() {
        return calories;
    }

    public int getUser_consumption_id() {
        return user_consumption_id;
    }

    public void setUser_consumption_id(int user_consumption_id) {
        this.user_consumption_id = user_consumption_id;
    }
}
