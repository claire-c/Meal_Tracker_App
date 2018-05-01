package com.cconnachan.bottomnavpractice;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Food implements Serializable {

    private String name;
    private MealType mealType;
    private Date date;
//    private String dateToConvert;

    public Food(String name, String dateToConvert, MealType mealType){
        this.name = name;
        try {
            this.date = new SimpleDateFormat("dd/MM/yyyy", Locale.UK).parse(dateToConvert);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.mealType = mealType;
    }

    public Date getDate() {
        return date;
    }

    public MealType getMealType() {
        return mealType;
    }

    public String getName() {
        return name;
    }

//    public Date getPrettyDate(){
//    }



}
