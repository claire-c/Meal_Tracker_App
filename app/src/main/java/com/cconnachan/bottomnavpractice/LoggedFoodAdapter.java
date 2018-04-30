package com.cconnachan.bottomnavpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LoggedFoodAdapter extends ArrayAdapter<Food> {

    public LoggedFoodAdapter(Context context, ArrayList<Food> loggedFood) {
        super(context, 0, loggedFood);
    }


    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }

        Food currentFoodItem = getItem(position);

        TextView foodName = (TextView) listItemView.findViewById(R.id.foodItemNameId);
        foodName.setText(currentFoodItem.getName().toString());

        TextView foodDate = (TextView) listItemView.findViewById(R.id.foodItemDateId);
        foodName.setText(currentFoodItem.getDate().toString());

        TextView mealType = (TextView) listItemView.findViewById(R.id.foodMealTypeId);
        foodName.setText(currentFoodItem.getMealType().toString());

        return listItemView;
    }

}
