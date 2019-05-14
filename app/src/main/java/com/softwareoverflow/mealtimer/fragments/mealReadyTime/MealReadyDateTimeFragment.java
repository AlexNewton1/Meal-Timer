package com.softwareoverflow.mealtimer.fragments.mealReadyTime;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.softwareoverflow.mealtimer.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * This fragment is responsible for allowing the user to enter the time they want their
 * {@link com.softwareoverflow.mealtimer.meal.Meal} to be ready for
 */
// TODO - this most likely will become it's own activity
public class MealReadyDateTimeFragment extends Fragment implements DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener {

    private TextView summaryTextView;
    private Calendar chosenReadyTime = Calendar.getInstance();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //TODO - fix all this!
/*
        chosenReadyTime = Calendar.getInstance();

        int mealTime = mealWizardActivity.getMeal().getMealDuration();
        chosenReadyTime.add(Calendar.MINUTE, mealTime);
*/
        View view = inflater.inflate(R.layout.fragment_meal_ready_time, container, false);
//        ViewPager pager = view.findViewById(R.id.meal_ready_date_time_view_pager);
//       setupViewPager(pager);

//        TabLayout tabLayout = view.findViewById(R.id.meal_ready_date_time_tabs);
//        tabLayout.setupWithViewPager(pager);

//        summaryTextView = view.findViewById(R.id.meal_ready_time_summary);

        return view;
    }

    /*private void setupViewPager(ViewPager viewPager) {
        FragmentManager fm = ((FragmentActivity) mealWizardActivity).getSupportFragmentManager();
        MealReadyDateTimePagerAdapter adapter = new MealReadyDateTimePagerAdapter(fm);
        adapter.setDateChangedListener(this);
        adapter.setTimeChangedListener(this);
        viewPager.setAdapter(adapter);
    }*/

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        chosenReadyTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        chosenReadyTime.set(Calendar.MINUTE, minute);

        setSummaryText();
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        chosenReadyTime.set(Calendar.YEAR, year);
        chosenReadyTime.set(Calendar.MONTH, monthOfYear);
        chosenReadyTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        setSummaryText();
    }

    private void setSummaryText() {
        int  hour = chosenReadyTime.get(Calendar.HOUR_OF_DAY);
        int minute = chosenReadyTime.get(Calendar.MINUTE);

        Locale locale = Locale.getDefault();
        String date = DateFormat.getDateInstance(DateFormat.SHORT, locale).format(chosenReadyTime);
        summaryTextView.setText(String.format(locale,
                "Meal will be ready at %2d:%2d on %s", hour, minute, date));
    }
}
