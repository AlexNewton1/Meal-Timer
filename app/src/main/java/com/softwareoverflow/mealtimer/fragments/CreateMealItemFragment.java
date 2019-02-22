package com.softwareoverflow.mealtimer.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwareoverflow.mealtimer.R;

public class CreateMealItemFragment extends MealWizardFragment {

    public CreateMealItemFragment() {
        // TODO - change to a "go back" icon and a "tick" icon
        super(R.drawable.arrow_right_faded, R.drawable.arrow_left);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
