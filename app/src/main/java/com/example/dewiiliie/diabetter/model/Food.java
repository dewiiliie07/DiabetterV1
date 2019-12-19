package com.example.dewiiliie.diabetter.model;

import com.google.gson.annotations.SerializedName;

public class Food {
    @SerializedName("food_id")
    private int id;
    @SerializedName("food_name")
    private String name;
    @SerializedName("calories")
    private float calories;
    @SerializedName("serving_calory")
    private int serving_calory; // satuannya gram


    public Food(){}

    public Food(int id, String name, float calories, int serving_calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.serving_calory = serving_calories;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCalories() {
        return calories;
    }

    public int getServing_calories() {
        return serving_calory;
    }
}
