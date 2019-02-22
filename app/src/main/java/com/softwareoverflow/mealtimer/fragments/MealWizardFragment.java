package com.softwareoverflow.mealtimer.fragments;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.softwareoverflow.mealtimer.activities.MealFragmentNavigator;

public abstract class MealWizardFragment extends Fragment {

    public MealFragmentNavigator mealFragmentNavigatorActivity;

    FloatingActionButton fab;
    ImageButton nextButton, backButton;
    int nextButtonImage, backButtonImage;

    /**
     * @param nextButtonImage The ID of the background drawable. 0 for not visible.
     * @param backButtonImage The ID of the background drawable. 0 for not visible.
     */
    public MealWizardFragment(int nextButtonImage, int backButtonImage){
        this.nextButtonImage = nextButtonImage;
        this.backButtonImage = backButtonImage;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("fragDebug", "onAttach");

        this.mealFragmentNavigatorActivity = (MealFragmentNavigator) context;
        fab = mealFragmentNavigatorActivity.getFAB();
        nextButton = mealFragmentNavigatorActivity.getNextIcon();
        backButton = mealFragmentNavigatorActivity.getBackIcon();

        setNextButtonImage(nextButtonImage);
        setBackButtonImage(backButtonImage);
    }

    /**
     * By default the next button will cause the activity to step through the wizard.
     * Any special cases are handled in the individual fragment.
     */
    public void onNextButtonClicked(){
        mealFragmentNavigatorActivity.nextWizardStep();
    }

    /**
     * By default the back button will cause the activity to go to the previous stage in the wizard.
     * Any special cases are handled in the individual fragment.
     */
    public void onBackButtonClicked(){
        mealFragmentNavigatorActivity.previousWizardStep();
    }

    public void setNextButtonImage(int nextButtonImage){
        this.nextButtonImage = nextButtonImage;

        if(nextButtonImage == 0)
            nextButton.setVisibility(View.GONE);
        else
            nextButton.setBackground(getResources().getDrawable(nextButtonImage,
                    ((Context) mealFragmentNavigatorActivity).getTheme()));
    }

    public void setBackButtonImage(int backButtonImage){
        this.backButtonImage = backButtonImage;

        if(backButtonImage == 0)
            backButton.setVisibility(View.GONE);
        else
            backButton.setBackground(getResources().getDrawable(backButtonImage,
                    ((Context) mealFragmentNavigatorActivity).getTheme()));
    }
}
