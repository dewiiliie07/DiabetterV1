package com.example.dewiiliie.diabetter.handler;

import com.example.dewiiliie.diabetter.model.Food;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetFoods {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    ArrayList<Food> foods;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    /*public void setUser(Food user) {
        this.user = user;
    }*/

    public String getMessage() {
        return message;
    }
}
