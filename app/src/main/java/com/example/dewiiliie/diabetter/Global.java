package com.example.dewiiliie.diabetter;

import com.example.dewiiliie.diabetter.model.ListQuest;
import com.example.dewiiliie.diabetter.model.Quest;
import com.example.dewiiliie.diabetter.model.User;
import com.example.dewiiliie.diabetter.rest.ApiClient;
import com.example.dewiiliie.diabetter.rest.ApiInterface;

import java.util.ArrayList;

public class Global {
    public static User user;
    public static double totalCalories;
    public static ApiInterface mApi = ApiClient.getClient().create(ApiInterface.class);
    public static ArrayList<Quest> quest;

    public static String getMaxLevel(int points){
        if (points>350){
            return "500";
        }
        else if (points>250){
            return "350";
        }
        else if (points>150){
            return "250";
        }
        else if (points>70){
            return "150";
        }
        else if (points>30){
            return "70";
        }
        else if (points>10){
            return "30";
        }
        else return "10";
    }

    public static String level(int points){
        if (points>500){
            return "7";
        }
        else if (points>350){
            return "6";
        }
        else if (points>250){
            return "5";
        }
        else if (points>150){
            return "4";
        }
        else if (points>70){
            return "3";
        }
        else if (points>30){
            return "2";
        }
        else if(points>10){
            return "1";
        }
        else {
            return "0";
        }
    }
}
