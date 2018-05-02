package com.cconnachan.bottomnavpractice;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class Persister {

    public static void save(Context c, FoodRecord foodRecordToSave) {
        Gson gson = new Gson();
        SharedPreferences sharedPref = c.getSharedPreferences(c.getString(R.string.app_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("FoodRecord", gson.toJson(foodRecordToSave));
        editor.apply();
    }

    public static FoodRecord load(Context c) {
        SharedPreferences sharedPref = c.getSharedPreferences(c.getString(R.string.app_name), Context.MODE_PRIVATE);
        String foodRecordAsJSON = sharedPref.getString("FoodRecord", "{}");
        Gson gson = new Gson();
        //This is deserializing the JSON format into a FoodRecord object.
        FoodRecord foodRecord = gson.fromJson(foodRecordAsJSON, FoodRecord.class);
        return foodRecord;
    }
}
