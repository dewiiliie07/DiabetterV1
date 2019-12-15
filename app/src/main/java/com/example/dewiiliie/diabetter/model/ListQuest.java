package com.example.dewiiliie.diabetter.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListQuest {
    @SerializedName("result")
    ArrayList<Quest> questList;

    public ArrayList<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(ArrayList<Quest> questList) {
        this.questList = questList;
    }
}
