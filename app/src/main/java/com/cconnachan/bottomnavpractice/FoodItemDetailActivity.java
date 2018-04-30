package com.cconnachan.bottomnavpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class FoodItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_detail);

        Intent intent = getIntent();
        Food foodItem = (Food) intent.getSerializableExtra("food");
        Log.d("Food name: ", foodItem.getName());

    }
}
