package com.example.dewiiliie.diabetter.model;

public class FoodConsumed {
    int food_id;
    int consumetype_id;
    int user_id;
    int serving_calories;

    public FoodConsumed(int food_id, int consumetype_id, int user_id, int serving_calories) {
        this.food_id = food_id;
        this.consumetype_id = consumetype_id;
        this.user_id = user_id;
        this.serving_calories = serving_calories;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getConsumetype_id() {
        return consumetype_id;
    }

    public void setConsumetype_id(int consumetype_id) {
        this.consumetype_id = consumetype_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getServing_calories() {
        return serving_calories;
    }

    public void setServing_calories(int serving_calories) {
        this.serving_calories = serving_calories;
    }
}
