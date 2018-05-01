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

    public MealType getMealTypeFromString(String stringMealType){

        for (MealType meal : MealType.values()) {
            if (stringMealType == meal.getEnumMealName()){
                return meal;
            }
        }
        throw new IllegalArgumentException("No meal here.");
    }
}
