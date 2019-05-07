package com.softwareoverflow.mealtimer.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.softwareoverflow.mealtimer.R;

/**
 * This fragment is responsible for allowing the user to enter the time they want their
 * {@link com.softwareoverflow.mealtimer.meal.Meal} to be ready for
 */
public class MealReadyTimeFragment extends MealWizardFragment implements View.OnClickListener{

    private TimePicker timePicker;
    private TextView day, month, year, hour, minute;
    private RadioButton amPmRadioButton;


    public MealReadyTimeFragment() {
        super(R.drawable.icon_arrow_right, R.drawable.icon_arrow_left);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_ready_time, container, false);

        View timePickerHeader = view.findViewById(R.id.time_picker_header);
        timePickerHeader.setOnClickListener(this);


        timePicker = view.findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int h, int m) {
                hour.setText(h);
                minute.setText(m);
            }
        });

        return view;

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
