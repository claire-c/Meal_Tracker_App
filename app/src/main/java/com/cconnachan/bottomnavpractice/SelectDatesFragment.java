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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SelectDatesFragment extends Fragment implements View.OnClickListener {

    View viewToInflate;
    Bundle savedInstanceState;
//    String userDateFrom;
//    String userDateTo;
    EditText firstDateTextView;
    EditText secondDateTextView;
    DatePickerDialog.OnDateSetListener dateListener;


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
        firstDateTextView = viewToInflate.findViewById(R.id.dateFromEditTextId);
        secondDateTextView = viewToInflate.findViewById(R.id.dateToEditTextId);

        dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                String dateAsString = FoodDateComparator.turnIntToStringDate(year, monthOfYear, dayOfMonth);

                String datePickerId = (String) view.getTag();

                dateWasPicked(datePickerId, dateAsString);
            }

        };


        return viewToInflate;
    }

    //Date from user is now put into the edit text view.
    public void dateWasPicked(String datePickedId, String datePicked){

        if (datePickedId == getString(R.string.dateFromPickerReferenceId)){
            firstDateTextView.setText(datePicked);

        }else if (datePickedId == getString(R.string.dateToPickerReferenceId)){
            secondDateTextView.setText(datePicked);
        }

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
                newUpDatePicker(getString(R.string.dateFromPickerReferenceId));
                //setDateOnTextView();
               // onDateSet(viewToInflate.findViewById(R.id.dateFromButtonId), year, month, dayOfMonth);
                break;

            case R.id.dateToButtonId:
                newUpDatePicker(getString(R.string.dateToPickerReferenceId));
              //  onDateSet(viewToInflate.findViewById(R.id.dateToButtonId), year, month, dayOfMonth);
                break;
        }
    }


    //To create a new date picker
    public void newUpDatePicker(String datePickerId){

        Calendar myCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog( getContext(), dateListener, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setTag(datePickerId);
        datePicker.show();


    }













//-------- Methods relating to text views ----------




    //To get back first date selected by the user.
    public String getDateFrom() {
//        firstDate = viewToInflate.findViewById(R.id.dateFromEditTextId);
        String dateFrom = firstDateTextView.getText().toString();
        return dateFrom;


    }

    //To get back second date selected by the user.
    public String getDateTo() {
//        secondDate = viewToInflate.findViewById(R.id.dateToEditTextId);
        String dateTo = secondDateTextView.getText().toString();
        return dateTo;

    }



}
