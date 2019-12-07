package com.example.dewiiliie.diabetter.handler;

import com.example.dewiiliie.diabetter.model.ConsumeType;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListConsumeType {
    @SerializedName("result")
    ArrayList<ConsumeType> consumeTypes;

    public ArrayList<ConsumeType> getConsumeTypes() {
        return consumeTypes;
    }
}
