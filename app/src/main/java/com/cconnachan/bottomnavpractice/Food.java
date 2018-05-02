package com.cconnachan.bottomnavpractice;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
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

    public boolean isSameAs(Food otherFood){
        boolean isNameSame = this.getName().equals(otherFood.getName());
        boolean isDateSame = this.getDate().compareTo(otherFood.getDate()) == 0 ;
        return (isDateSame && isNameSame);

    }
//    public Date getPrettyDate(){
//    }





}
