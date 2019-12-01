package com.example.dewiiliie.diabetter.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    @SerializedName("full_name")
    private String full_name;
    private String email;
    private String birthdate;
    private float height;
    private float weight;
    private char gender;
    private char activity_level;

    public User(){}

    public User(int id, String full_name, String email, String birthdate, float height, float weight, char gender, char activity_level) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.activity_level = activity_level;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public char getGender() {
        return gender;
    }

    public char getActivity_level() {
        return activity_level;
    }
}