package com.example.dewiiliie.diabetter.model;
import com.google.gson.annotations.SerializedName;

public class Quest {
    @SerializedName("quest_id")
    private int id;
    @SerializedName("quest_type")
    private int quest_type;
    @SerializedName("quest_name")
    private String quest_name;
    @SerializedName("quest_point")
    private int quest_point;

    public Quest(int id, int quest_type, String quest_name, int quest_point) {
        this.id = id;
        this.quest_type = quest_type;
        this.quest_name = quest_name;
        this.quest_point = quest_point;
    }

    public int getId() {
        return id;
    }

    public int getQuest_type() {
        return quest_type;
    }

    public String getQuest_name() {
        return quest_name;
    }

    public int getQuest_point() {
        return quest_point;
    }
}
