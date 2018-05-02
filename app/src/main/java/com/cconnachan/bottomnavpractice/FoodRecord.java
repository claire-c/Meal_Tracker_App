package com.cconnachan.bottomnavpractice;

import android.graphics.Movie;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

public class FoodRecord {

    private ArrayList<Food> loggedFood;
    private HashMap<MealType, Integer> loggedMeals;

    public FoodRecord() {
        this.loggedFood = new ArrayList<Food>();
        this.loggedMeals = new HashMap<>();
    }

    public ArrayList<Food> getLoggedFood() {
        return loggedFood;
    }

    public void addFood(Food foodToAdd) {
        loggedFood.add(foodToAdd);
    }

    public int totalLogged() {
        return loggedFood.size();
    }

    //This is reliant on passing in the same object that has been logged. Not sure if I will need to refactor this?
    public void removeFood(Food foodToRemove) {
        ArrayList<Food> newLoggedFood = new ArrayList<>();
        for (Food food : loggedFood) {
            if (!food.isSameAs(foodToRemove)) {
                newLoggedFood.add(food);
            }
        }
        loggedFood = newLoggedFood;
    }

    //This is a nonsense function - think I will refactor to count through arrayList and pass in an argument so that it will work for all meal types.
    public HashMap<MealType, Integer> getLoggedMeals(ArrayList<Food> foodToCount) {
        HashMap<MealType, Integer> loggedMeals = new HashMap<>();
        Integer breakfast = 0;
        Integer lunch = 0;
        Integer dinner = 0;
        Integer supper = 0;
        Integer snack = 0;

        for (Food food : foodToCount) {
            if (food.getMealType() == MealType.BREAKFAST) {
                breakfast += 1;
            } else if (food.getMealType() == MealType.LUNCH) {
                lunch += 1;
            } else if (food.getMealType() == MealType.DINNER) {
                dinner += 1;
            } else if (food.getMealType() == MealType.SUPPER) {
                supper += 1;
            } else if (food.getMealType() == MealType.SNACK) {
                snack += 1;
            }
        }

        loggedMeals.put(MealType.BREAKFAST, breakfast);
        loggedMeals.put(MealType.LUNCH, lunch);
        loggedMeals.put(MealType.DINNER, dinner);
        loggedMeals.put(MealType.SUPPER, supper);
        loggedMeals.put(MealType.SNACK, snack);

        this.loggedMeals = loggedMeals;
        return this.loggedMeals;
    }


    public Integer getBreakfastTotal() {
        getLoggedMeals(loggedFood);
        return loggedMeals.get(MealType.BREAKFAST);
    }

    public Integer getLunchTotal() {
        getLoggedMeals(loggedFood);
        return loggedMeals.get(MealType.LUNCH);
    }

    public Integer getDinnerTotal() {
        getLoggedMeals(loggedFood);
        return loggedMeals.get(MealType.DINNER);
    }

    public Integer getSupperTotal() {
        getLoggedMeals(loggedFood);
        return loggedMeals.get(MealType.SUPPER);
    }

    public Integer getSnackTotal() {
        getLoggedMeals(loggedFood);
        return loggedMeals.get(MealType.SNACK);
    }


    public ArrayList<Food> dateSortedLoggedFood() {
        Collections.sort(loggedFood, new FoodDateComparator());
        return loggedFood;
    }

    public ArrayList<Food> getFoodBetweenDates(String stringDate1, String stringDate2) {
        Date date1 = FoodDateComparator.getDateFromString(stringDate1);
        Date date2 = FoodDateComparator.getDateFromString(stringDate2);

        ArrayList<Food> foodBetweenDates = new ArrayList<Food>();
        for (Food food : loggedFood) {
            if (food.getDate().after(date1) && food.getDate().before(date2)) {
                foodBetweenDates.add(food);
            }
        }
        return foodBetweenDates;
    }
}


