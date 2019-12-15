package com.example.dewiiliie.diabetter.Interface;

public abstract interface FoodInterface {
    void onAddFood(int foodID, int serving_calories);

    void onAddCalories(double calories);

    void totalCalories(double totalCalory);
}
