package com.example.dewiiliie.diabetter.model;
import com.google.gson.annotations.SerializedName;

public class Quest {
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("quest_type")
    private int quest_type;
    @SerializedName("quest_name")
    private String quest_name;
    @SerializedName("quest_point")
    private int quest_point;
    @SerializedName("isDone")
    private int isDone;
    @SerializedName("image_name")
    private String image_name;

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuest_type() {
        return quest_type;
    }

    public void setQuest_type(int quest_type) {
        this.quest_type = quest_type;
    }

    public String getQuest_name() {
        return quest_name;
    }

    public void setQuest_name(String quest_name) {
        this.quest_name = quest_name;
    }

    public int getQuest_point() {
        return quest_point;
    }

    public void setQuest_point(int quest_point) {
        this.quest_point = quest_point;
    }

    public int getIsDone() {
        return isDone;
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }

}
