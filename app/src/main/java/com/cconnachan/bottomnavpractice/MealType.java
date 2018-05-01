package com.cconnachan.bottomnavpractice;

public enum MealType {

    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SUPPER("Supper"),
    SNACK("Snack");


    private final String mealName;

    MealType(String mealName){
        this.mealName = mealName;
    }

    public String getEnumMealName(){
        return this.mealName;
    }
}
