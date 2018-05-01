package com.cconnachan.bottomnavpractice;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, FoodItemDetailFragment.OnFragmentInteractionListener, IFoodRecordable {

    private FoodRecord foodRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        String foodRecordAsJSON = sharedPref.getString("FoodRecord", "{}");

        //New Gson thing
        Gson gson = new Gson();
        //This is deserializing the JSON format into a FoodRecord object.
        foodRecord = gson.fromJson(foodRecordAsJSON, FoodRecord.class);
        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;

            case R.id.nav_add_food:
                fragment = new AddFoodFragment();
                break;

            case R.id.nav_food_list:
                fragment = new FoodListFragment();
                break;

            case R.id.nav_select_dates:
                fragment = new SelectDatesFragment();
                break;
        }

        return loadFragment(fragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //empty
    }

    @Override
    public FoodRecord getFoodRecord(){
        return foodRecord;
    }

    @Override
    public void persistFoodRecord(){

    }
}
