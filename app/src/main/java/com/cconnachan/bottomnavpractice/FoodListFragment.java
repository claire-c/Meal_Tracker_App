package com.cconnachan.bottomnavpractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cconnachan.bottomnavpractice.FoodRecord;


import java.util.ArrayList;

public class FoodListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        FoodRecord foodRecord = new FoodRecord();
        Food chips = new Food("chips", "18/03/2018", MealType.BREAKFAST);
        Food lasagne = new Food("lasagne", "12/04/2017", MealType.DINNER);
        foodRecord.addFood(lasagne);
        foodRecord.addFood(chips);
        ArrayList<Food> loggedFood = foodRecord.getLoggedFood();

        LoggedFoodAdapter foodAdapter = new LoggedFoodAdapter(getContext(), loggedFood);

        View viewToInflate = inflater.inflate(R.layout.fragment_food_list, null);
        ListView listView = viewToInflate.findViewById(R.id.foodLogListId);

        listView.setAdapter(foodAdapter);

        return viewToInflate;

    }
}
