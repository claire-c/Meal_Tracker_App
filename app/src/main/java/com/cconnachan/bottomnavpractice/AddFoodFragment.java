package com.cconnachan.bottomnavpractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddFoodFragment extends Fragment {

    Spinner spinner;
    ArrayAdapter<CharSequence> spinnerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View viewToInflate = inflater.inflate(R.layout.fragment_add_food, null);
        //This is initializing my spinner.
        spinner = viewToInflate.findViewById(R.id.spinner);
        //This is getting the stuff I need to put in the spinner and give it a look.
        spinnerAdapter = ArrayAdapter.createFromResource(getContext(), R.array.meal_types, android.R.layout.simple_spinner_item);
        //This is to give the spinner dropdown items a look.
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //This is to set the adapter
        spinner.setAdapter(spinnerAdapter);

        //This is what happens when there is a click on the dropdown. It's an override method.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //This is a toast that will pop up when the dropdown item is selected.
                Toast.makeText(getContext(), parent.getItemAtPosition(position) + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return viewToInflate;
    }
}
