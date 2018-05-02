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
    TextView breakfastTotal;
    TextView lunchTotal;
    TextView dinnerTotal;
    TextView snackTotal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewToInflate = inflater.inflate(R.layout.fragment_home, null);

        //To get the persisted data from the shared preferences.
        FoodRecord foodRecord = Persister.load(getContext());

        breakfastsLogged = viewToInflate.findViewById(R.id.totalBreakfastsId);
        lunchesLogged = viewToInflate.findViewById(R.id.totalLunchesId);
        dinnersLogged = viewToInflate.findViewById(R.id.totalDinnersId);
        snacksLogged = viewToInflate.findViewById(R.id.totalSnacksId);
        breakfastTotal = viewToInflate.findViewById(R.id.breakfastNumber);
        lunchTotal = viewToInflate.findViewById(R.id.lunchNumber);
        dinnerTotal = viewToInflate.findViewById(R.id.dinnerNumber);
        snackTotal = viewToInflate.findViewById(R.id.snackNumber);

        breakfastTotal.setText(foodRecord.getBreakfastTotal().toString());
        lunchTotal.setText(foodRecord.getLunchTotal().toString());
        dinnerTotal.setText(foodRecord.getDinnerTotal().toString());
        snackTotal.setText(foodRecord.getSnackTotal().toString());
        breakfastsLogged.setText(getResources().getString(R.string.home_breakfasts));
        lunchesLogged.setText(getResources().getString(R.string.home_lunches));
        dinnersLogged.setText(getResources().getString(R.string.home_dinners));
        snacksLogged.setText(getResources().getString(R.string.home_snacks));

        return viewToInflate;
    }
}
