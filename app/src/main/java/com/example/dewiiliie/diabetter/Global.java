package com.example.dewiiliie.diabetter;

import com.example.dewiiliie.diabetter.model.User;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;

public class Global {
    public static User user;
    public static double totalCalories;
    public static ApiInterface mApi = ApiClient.getClient().create(ApiInterface.class);
}
