package com.example.dewiiliie.diabetter;

public class ChildModel {

    String foodName, calChoosen, cal;

    public ChildModel(String foodName, String calChoosen, String cal) {
        this.foodName = foodName;
        this.calChoosen = calChoosen;
        this.cal = cal;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCalChoosen() {
        return calChoosen;
    }

    public void setCalChoosen(String calChoosen) {
        this.calChoosen = calChoosen;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

}
