package com.softwareoverflow.mealtimer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageButton;

import com.softwareoverflow.mealtimer.MealWizardNavigator;
import com.softwareoverflow.mealtimer.R;

public abstract class MealWizardFragment extends Fragment {

    public MealWizardNavigator mealWizardActivity;

    FloatingActionButton fab;
    ImageButton nextButton, backButton;
    int nextButtonImage = R.drawable.icon_tick, backButtonImage = R.drawable.icon_undo;

    public MealWizardFragment() {
        super();
    }

    /**
     * @param nextButtonImage The ID of the background drawable. 0 for not visible.
     * @param backButtonImage The ID of the background drawable. 0 for not visible.
     */
    public MealWizardFragment(int nextButtonImage, int backButtonImage) {
        super();
        this.nextButtonImage = nextButtonImage;
        this.backButtonImage = backButtonImage;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.mealWizardActivity = (MealWizardNavigator) context;
        fab = mealWizardActivity.getFAB();
        nextButton = mealWizardActivity.getNextIcon();
        backButton = mealWizardActivity.getBackIcon();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUserVisibleHint(false);
    }

    /**
     * By default the next button will cause the activity to go to the next stage in the wizard.
     * Any special cases are handled in the individual fragment.
     */
    public void setNextButtonImage(int nextButtonImage) {
        this.nextButtonImage = nextButtonImage;

        if (nextButtonImage == 0)
            nextButton.setVisibility(View.GONE);
        else{
            nextButton.setVisibility(View.VISIBLE);
            nextButton.setBackground(getResources().getDrawable(nextButtonImage,
                    ((Context) mealWizardActivity).getTheme()));
        }
    }

    public void setBackButtonImage(int backButtonImage) {
        this.backButtonImage = backButtonImage;

        if (backButtonImage == 0)
            backButton.setVisibility(View.GONE);
        else {
            backButton.setVisibility(View.VISIBLE);
            backButton.setBackground(getResources().getDrawable(backButtonImage,
                    ((Context) mealWizardActivity).getTheme()));
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser && isAdded()) {
            setBackButtonImage(backButtonImage);
            setNextButtonImage(nextButtonImage);
        }
    }
}
