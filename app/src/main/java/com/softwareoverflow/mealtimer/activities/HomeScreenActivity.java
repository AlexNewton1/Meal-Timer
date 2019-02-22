package com.softwareoverflow.mealtimer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.softwareoverflow.mealtimer.R;

public class HomeScreenActivity extends AppCompatActivity {

    private String LOG_TAG = "HomeScreenActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void createNewMeal(View v){
        startActivity(new Intent(this, CreateMealActivity.class));
    }

    public void loadSavedMeal(View v){
        Log.e(LOG_TAG, "Not Yet Implemented");
    }

    public void showPlannedMeals(View v){
        Log.e(LOG_TAG, "Not Yet Implemented");
    }
}
