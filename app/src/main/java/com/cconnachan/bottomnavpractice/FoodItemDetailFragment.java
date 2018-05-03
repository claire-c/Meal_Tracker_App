package com.cconnachan.bottomnavpractice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FoodItemDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FoodItemDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodItemDetailFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    static final String ARG_ALLTHEFOOD = "food";

    private Food food;
    TextView foodNameTextView;
    TextView dateLoggedTextView;
    TextView mealTypeTextView;

    private OnFragmentInteractionListener mListener;

    public FoodItemDetailFragment() {
        // Required empty public constructor
    }


    public static FoodItemDetailFragment newInstance(String food) {
        FoodItemDetailFragment fragment = new FoodItemDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ALLTHEFOOD, food);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            food = (Food) getArguments().getSerializable(ARG_ALLTHEFOOD);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewToInflate = inflater.inflate(R.layout.fragment_food_item_detail, container, false);

        //Assign the textViews and their corresponding text.
        foodNameTextView = viewToInflate.findViewById(R.id.mealNameFoodItemDetailFragmentTextViewId);
        foodNameTextView.setText(food.getName());

        dateLoggedTextView = viewToInflate.findViewById(R.id.dateLoggedFoodItemDetailTextViewId);
        dateLoggedTextView.setText(food.getDate().toString());

        mealTypeTextView = viewToInflate.findViewById(R.id.mealTypeFoodItemDetailTextViewId);
        mealTypeTextView.setText(food.getMealType().toString());

        //Set onClickListener for the button click.
        Button button = viewToInflate.findViewById(R.id.deleteFoodLogButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                FoodRecord foodRecord = Persister.load(getContext());
                foodRecord.removeFood(food);
                Persister.save(getContext(), foodRecord);

                Toast.makeText(getContext(), R.string.fooddetail_remove_toast_confirmation,
                        Toast.LENGTH_SHORT).show();

            }
        });

        return viewToInflate;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
