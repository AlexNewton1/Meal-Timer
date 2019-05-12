package com.softwareoverflow.mealtimer.fragments.mealReadyTime;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import com.softwareoverflow.mealtimer.R;

public class MealReadyTimePickerFragment extends Fragment {

    private TimePicker timePicker;
    private TimePicker.OnTimeChangedListener timeChangedListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_ready_time_picker, container, false);

        timePicker = view.findViewById(R.id.meal_ready_time_picker);
        return view;
    }

    public void setOnTimeChangedListener(TimePicker.OnTimeChangedListener listener){
        timeChangedListener = listener;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        timeChangedListener = null;
    }
}
