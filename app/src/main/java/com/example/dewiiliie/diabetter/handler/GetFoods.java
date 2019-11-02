package com.example.dewiiliie.diabetter.handler;

import com.example.dewiiliie.diabetter.model.Food;
import com.google.gson.annotations.SerializedName;

public class GetFoods {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Food food;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public Food getFood() {
        return food;
    }

    /*public void setUser(Food user) {
        this.user = user;
    }*/

    public String getMessage() {
        return message;
    }
}
