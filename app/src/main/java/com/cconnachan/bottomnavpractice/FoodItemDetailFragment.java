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
    // TODO: Rename parameter arguments, choose names that match
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

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodItemDetailFragment.
     */
    // TODO: Rename and change types and number of parameters

//    FoodItemDetailFragment fif = FoodItemDetailFragment.newInstance(jsonString);

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
