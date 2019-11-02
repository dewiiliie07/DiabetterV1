package com.example.dewiiliie.diabetter.model;

public class Food {
    private int id;
    private String name;
    private float calories;
    private int serving_calories; // satuannya gram


    public Food(){}

    public Food(int id, String name, float calories, int serving_calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.serving_calories = serving_calories;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCalories() {
        return calories;
    }

    public int getServing_calories() {
        return serving_calories;
    }
}
