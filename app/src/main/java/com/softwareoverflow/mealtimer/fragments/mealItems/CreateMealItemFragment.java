package com.softwareoverflow.mealtimer.fragments.mealItems;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.fragments.MealWizardFragment;

public class CreateMealItemFragment extends MealWizardFragment {

    public CreateMealItemFragment() {
        super(R.drawable.icon_tick, R.drawable.icon_undo);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
