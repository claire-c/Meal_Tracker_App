package com.cconnachan.bottomnavpractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

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


    public Date getDateFromString(String dateToConvert) {
       Date dateToReturn = null;
        try {
            dateToReturn = new SimpleDateFormat("dd/MM/yyyy", Locale.UK).parse(dateToConvert);
        } catch (ParseException e) {
            e.printStackTrace();
            
        }
        return dateToReturn;
    }
}

