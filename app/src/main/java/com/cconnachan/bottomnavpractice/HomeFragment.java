package com.cconnachan.bottomnavpractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    TextView breakfastsLogged;
    TextView lunchesLogged;
    TextView dinnersLogged;
    TextView snacksLogged;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewToInflate = inflater.inflate(R.layout.fragment_home, null);

        FoodRecord foodRecord = new FoodRecord();
        Food chips = new Food("chips", "18/03/2018", MealType.BREAKFAST);
        Food lasagne = new Food("lasagne", "12/04/2017", MealType.DINNER);
        foodRecord.addFood(lasagne);
        foodRecord.addFood(chips);
        ArrayList<Food> loggedFood = foodRecord.getLoggedFood();

        breakfastsLogged = viewToInflate.findViewById(R.id.totalBreakfastsId);
        lunchesLogged = viewToInflate.findViewById(R.id.totalLunchesId);
        dinnersLogged = viewToInflate.findViewById(R.id.totalDinnersId);
        snacksLogged = viewToInflate.findViewById(R.id.totalSnacksId);

        breakfastsLogged.setText(foodRecord.getBreakfastTotal().toString() + " breakfast foods logged");
        lunchesLogged.setText(foodRecord.getLunchTotal().toString() + " lunch foods logged");
        dinnersLogged.setText(foodRecord.getDinnerTotal().toString() + " dinner foods logged");
        snacksLogged.setText(foodRecord.getSnackTotal().toString() + " snack foods logged");

        return viewToInflate;
    }
}
