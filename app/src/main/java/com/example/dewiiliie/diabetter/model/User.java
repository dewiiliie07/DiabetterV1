package com.example.dewiiliie.diabetter.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("full_name")
    private String full_name;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("birthdate")
    private String birthdate;
    @SerializedName("height")
    private float height;
    @SerializedName("weight")
    private float weight;
    @SerializedName("gender")
    private char gender;
    @SerializedName("activity_level")
    private char activity_level;
    @SerializedName("last_login")
    private String last_login;
    @SerializedName("points")
    private int points;
    @SerializedName("counter_daily_quest")
    private int counter_daily_quest;

    public int getCounter_daily_quest() {
        return counter_daily_quest;
    }

    public void setCounter_daily_quest(int counter_daily_quest) {
        this.counter_daily_quest = counter_daily_quest;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCounter_login() {
        return counter_login;
    }

    public void setCounter_login(int counter_login) {
        this.counter_login = counter_login;
    }

    @SerializedName("counter_login")
    private int counter_login;



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getActivity_level() {
        return activity_level;
    }

    public void setActivity_level(char activity_level) {
        this.activity_level = activity_level;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}