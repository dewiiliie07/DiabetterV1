package com.example.dewiiliie.diabetter.handler;

import com.example.dewiiliie.diabetter.model.Food;
import com.example.dewiiliie.diabetter.model.User;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserInformation {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    User user;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }
}
