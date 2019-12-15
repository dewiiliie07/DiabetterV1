package com.example.dewiiliie.diabetter.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListQuestCounter {
    @SerializedName("result")
    ArrayList<QuestCounter> result;

    public ArrayList<QuestCounter> getResult() {
        return result;
    }

    public void setResult(ArrayList<QuestCounter> result) {
        this.result = result;
    }

    public int getCounter_add_food(int i){
        return result.get(i).getCounter_add_food();
    }
    public int getConsumetype_id(int i){
        return result.get(i).getConsumetype_id();
    }
}

class QuestCounter{
    @SerializedName("user_id")
    int user_id;
    @SerializedName("counter_add_food")
    int counter_add_food;
    @SerializedName("consumetype_id")
    int consumetype_id;
    @SerializedName("date")
    String date;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCounter_add_food() {
        return counter_add_food;
    }

    public void setCounter_add_food(int counter_add_food) {
        this.counter_add_food = counter_add_food;
    }

    public int getConsumetype_id() {
        return consumetype_id;
    }

    public void setConsumetype_id(int consumetype_id) {
        this.consumetype_id = consumetype_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
