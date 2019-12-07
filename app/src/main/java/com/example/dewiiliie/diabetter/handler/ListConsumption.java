package com.example.dewiiliie.diabetter.handler;

import com.example.dewiiliie.diabetter.model.Consumption;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListConsumption  {
    @SerializedName("result")
    ArrayList<Consumption> consumptions;

    public ArrayList<Consumption> getConsumptions() {
        return consumptions;
    }
}
