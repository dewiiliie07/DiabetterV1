package com.example.dewiiliie.diabetter;

public class Model {

    private int image;
    String title, addFood;

    public Model(int image, String title, String addFood) {
        this.image = image;
        this.title = title;
        this.addFood = addFood;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddFood() {
        return addFood;
    }

    public void setAddFood(String addFood) {
        this.addFood = addFood;
    }

    //    private String text_view_breakfast;
//    private int button_add;
//
//    public Model(String text_view_breakfast, int button_add) {
//        this.text_view_breakfast = text_view_breakfast;
//        this.button_add = button_add;
//    }
//
//    public String getText_view_breakfast() {
//        return text_view_breakfast;
//    }
//
//    public void setText_view_breakfast(String text_view_breakfast) {
//        this.text_view_breakfast = text_view_breakfast;
//    }
//
//    public int getButton_add() {
//        return button_add;
//    }
//
//    public void setButton_add(int button_add) {
//        this.button_add = button_add;
//    }
}
