package com.example.dewiiliie.diabetter.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TotalConsumptionUser {
    @SerializedName("result")
    private ArrayList<TotalConsumption> totalCalories;

    public ArrayList<TotalConsumption> getTotalCalories() {
        return totalCalories;
    }

    public double caloriesTotal(){
        return getTotalCalories().get(0).getCalories();
    }

    public void setTotalCalories(ArrayList<TotalConsumption> totalCalories) {
        this.totalCalories = totalCalories;
    }
}

class TotalConsumption {
    @SerializedName("totalCalories")
    private double calories;

    public double getCalories() {
        return calories;
    }

}
