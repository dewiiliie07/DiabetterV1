package com.example.dewiiliie.diabetter.model;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class ConsumeType {
    @SerializedName("consumetype_id")
    private String consumetype_id;
    @SerializedName("consumetype_name")
    private String consumetype_name;
    @SerializedName("input_date")
    private String input_date;

    public String getConsumetype_id() {
        return consumetype_id;
    }

    public String getConsumetype_name() {
        return consumetype_name;
    }

    public String getInput_date() {
        return input_date;
    }
}
