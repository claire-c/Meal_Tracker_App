package com.cconnachan.bottomnavpractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DateSortedFoodListFragment extends Fragment{

    static final String ARG_ALLSORTEDFOOD = "sortedFood";

    FoodRecord loggedFood;

    public static DateSortedFoodListFragment newInstance(String sortedFood) {
        DateSortedFoodListFragment fragment = new DateSortedFoodListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ALLSORTEDFOOD, sortedFood);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            loggedFood = (FoodRecord) getArguments().getSerializable(ARG_ALLSORTEDFOOD);

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //To get the persisted data from the shared preferences.
//        FoodRecord foodRecord = Persister.load(getContext());

        //NEED TO SORT THIS - HOW TO GET STRING INPUT FROM OTHER FRAGMENT? OTHER OPTIONS ARE USING THE BUNDLE AND EXTRACTING IT FROM THERE?
//        ArrayList<Food> loggedFood = foodRecord.getFoodBetweenDates("01/01/2017", "01/06/2018");

        //This starts the listView creation using the loggedFood object.
        loggedFood = (FoodRecord) getArguments().getSerializable(ARG_ALLSORTEDFOOD);
        LoggedFoodAdapter foodAdapter = new LoggedFoodAdapter(getContext(), loggedFood.getLoggedFood());

        //This prepares the view to inflate., using the ID of the fragment.
        View viewToInflate = inflater.inflate(R.layout.fragment_date_sorted_food_list, null);

        //This inflates the listView within the fragment.
        ListView listView = viewToInflate.findViewById(R.id.dateSelectedListViewId);

        listView.setAdapter(foodAdapter);

        //This is for when someone clicks on the listView item.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View listItem, int position, long id) {

                //This gets the food object from the listView.
                Food food = (Food) listItem.getTag();

                // Create fragment and give it an argument specifying the article it should show
                FoodItemDetailFragment newFragment = new FoodItemDetailFragment();
                Bundle args = new Bundle();
                //This passes through the food item to the fragment.
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

        //This returns the view that will be inflated, complete with information.
        return viewToInflate;

    }


}
