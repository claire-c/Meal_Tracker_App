package com.cconnachan.bottomnavpractice;

import java.util.Comparator;

public class FoodDateComparator implements Comparator<Food> {

    public int compare(Food food, Food secondFood) {
        if (food.getDate().before(secondFood.getDate())) {
            return -1;
        } else if (food.getDate().after(secondFood.getDate())) {
            return 1;
        } else {
            return 0;
        }
    }
}

