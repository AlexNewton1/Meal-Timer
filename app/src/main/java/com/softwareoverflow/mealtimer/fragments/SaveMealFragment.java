package com.softwareoverflow.mealtimer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.softwareoverflow.mealtimer.R;

public class SaveMealFragment extends MealWizardFragment {

    private EditText mealName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_save_meal, container, false);
        mealName = view.findViewById(R.id.meal_name_to_save);

        //mealWizardNavigatorActivity.getFAB().hide();
        //mealWizardNavigatorActivity.getNextIcon().setVisibility(View.GONE);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void saveOrUpdateMeal(View v){

    }

    public void goHome(View v){

    }
}
