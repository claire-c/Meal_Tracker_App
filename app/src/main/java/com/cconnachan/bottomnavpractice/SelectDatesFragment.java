package com.cconnachan.bottomnavpractice;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class SelectDatesFragment extends DialogFragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    View viewToInflate;
    Bundle savedInstanceState;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate fragment.
        viewToInflate = inflater.inflate(R.layout.fragment_select_dates, null);

        //BUTTON

        Button button = viewToInflate.findViewById(R.id.selectDatesButtonId);
        button.setOnClickListener(this);

        //END BUTTON

        //FIRST DATE SELECTOR

        Button firstDateSelected = viewToInflate.findViewById(R.id.dateFromButtonId);
        firstDateSelected.setOnClickListener(this);

        //END FIRST DATE SELECTOR

        //SECOND DATE SELECTOR

        Button secondDateSelected = viewToInflate.findViewById(R.id.dateToButtonId);
        secondDateSelected.setOnClickListener(this);

        //END FIRST DATE SELECTOR


        return viewToInflate;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.selectDatesButtonId:

                FoodRecord foodRecord = Persister.load(getContext());
                ArrayList<Food> foodBetweenDates = foodRecord.getFoodBetweenDates(getDateFrom(), getDateTo());
                FoodRecord disposableFoodRecord = new FoodRecord(foodBetweenDates);


                // Create new fragment and transaction
                DateSortedFoodListFragment newFragment = new DateSortedFoodListFragment();
                Bundle args = new Bundle();
                //This passes through the food item to the fragment.
                args.putSerializable(DateSortedFoodListFragment.ARG_ALLSORTEDFOOD, disposableFoodRecord);
                newFragment.setArguments(args);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();


                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.fragment_container, newFragment);

                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();

                break;

            case R.id.dateFromButtonId:
                DialogFragment dateFromFragment = new SelectDatesFragment();
                dateFromFragment.show(getFragmentManager(), "dateFromPicker");
                break;

            case R.id.dateToButtonId:
                DialogFragment dateToFragment = new SelectDatesFragment();
                dateToFragment.show(getFragmentManager(), "dateToPicker");
                break;
        }
    }


    //To get back first date selected by the user.
    public String getDateFrom() {
        TextView firstDate = viewToInflate.findViewById(R.id.dateFromEditTextId);
        String dateFrom = firstDate.getText().toString();
        return dateFrom;
    }

    //To get back second date selected by the user.
    public String getDateTo() {
        TextView secondDate = viewToInflate.findViewById(R.id.dateToEditTextId);
        String dateTo = secondDate.getText().toString();
        return dateTo;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);

    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Integer integerYear = (Integer) year;
        String stringYear = integerYear.toString();


    }
}
