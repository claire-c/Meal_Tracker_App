package com.cconnachan.bottomnavpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View listItem, int position, long id) {
                Log.d("hello there!", "we are being logged");
                Food food = (Food) listItem.getTag();
                Log.d("Food name: ", food.getName());

                // Create fragment and give it an argument specifying the article it should show
                FoodItemDetailFragment newFragment = new FoodItemDetailFragment();
                Bundle args = new Bundle();
                args.putSerializable(FoodItemDetailFragment.ARG_ALLTHEFOOD, food);
                newFragment.setArguments(args);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);

// Commit the transaction
                transaction.commit();
            }
        });

        return viewToInflate;

    }

//    public void onListItemClick(View listItem) {
//        Food food = (Food) listItem.getTag();
//        Log.d("Food name: ", food.getName());
//    }

    public void getFoodItem(View listItem) {
        Food food = (Food) listItem.getTag();
        Log.d("get food item: ", food.getName());

        Intent intent = new Intent(getContext(), FoodItemDetailActivity.class);
        intent.putExtra("food", food);
        startActivity(intent);
    }

}
