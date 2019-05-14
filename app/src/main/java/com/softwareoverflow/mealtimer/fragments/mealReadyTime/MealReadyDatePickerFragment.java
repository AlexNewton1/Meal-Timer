package com.softwareoverflow.mealtimer.fragments.mealReadyTime;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.softwareoverflow.mealtimer.R;

import java.util.Calendar;

public class MealReadyDatePickerFragment extends Fragment {

    private DatePicker datePicker;
    private DatePicker.OnDateChangedListener dateChangedListener;
    private Calendar earliestReadyTime = Calendar.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_ready_date_picker, container, false);

        datePicker = view.findViewById(R.id.meal_ready_date_picker);
        datePicker.setMinDate(earliestReadyTime.getTimeInMillis());
        datePicker.init(
                earliestReadyTime.get(Calendar.YEAR),
                earliestReadyTime.get(Calendar.MONTH),
                earliestReadyTime.get(Calendar.DAY_OF_MONTH),
                dateChangedListener);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        earliestReadyTime = Calendar.getInstance();
        //TODO - update this code to reference local Meal object
        //earliestReadyTime.add(Calendar.MINUTE, ((MealActivity) getActivity()).getMeal().getMealDuration());

        dateChangedListener = (DatePicker.OnDateChangedListener) getParentFragment();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        dateChangedListener = null;
    }
}
