package com.softwareoverflow.mealtimer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.softwareoverflow.mealtimer.MealWizardNavigator;
import com.softwareoverflow.mealtimer.R;

public abstract class MealWizardFragment extends Fragment {

    public MealWizardNavigator mealWizardNavigatorActivity;

    FloatingActionButton fab;
    ImageButton nextButton, backButton;
    int nextButtonImage = R.drawable.icon_arrow_right, backButtonImage = R.drawable.icon_arrow_left;

    public MealWizardFragment(){
        super();
    }

    /**
     * @param nextButtonImage The ID of the background drawable. 0 for not visible.
     * @param backButtonImage The ID of the background drawable. 0 for not visible.
     */
    public MealWizardFragment(int nextButtonImage, int backButtonImage){
        super();
        this.nextButtonImage = nextButtonImage;
        this.backButtonImage = backButtonImage;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("fragDebug", "onAttach");

        this.mealWizardNavigatorActivity = (MealWizardNavigator) context;
        fab = mealWizardNavigatorActivity.getFAB();
        nextButton = mealWizardNavigatorActivity.getNextIcon();
        backButton = mealWizardNavigatorActivity.getBackIcon();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUserVisibleHint(false);
    }

    /**
     * By default the next button will cause the activity to step through the wizard.
     * Any special cases are handled in the individual fragment.
     */
    public void onNextButtonClicked(){
        mealWizardNavigatorActivity.nextWizardStep();
    }

    /**
     * By default the back button will cause the activity to go to the previous stage in the wizard.
     * Any special cases are handled in the individual fragment.
     */
    public void onBackButtonClicked(){
        mealWizardNavigatorActivity.previousWizardStep();
    }

    public void setNextButtonImage(int nextButtonImage){
        this.nextButtonImage = nextButtonImage;

        if(nextButtonImage == 0)
            nextButton.setVisibility(View.GONE);
        else
            nextButton.setBackground(getResources().getDrawable(nextButtonImage,
                    ((Context) mealWizardNavigatorActivity).getTheme()));
    }

    public void setBackButtonImage(int backButtonImage){
        this.backButtonImage = backButtonImage;

        if(backButtonImage == 0)
            backButton.setVisibility(View.GONE);
        else
            backButton.setBackground(getResources().getDrawable(backButtonImage,
                    ((Context) mealWizardNavigatorActivity).getTheme()));
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser && isAdded()){
            setBackButtonImage(backButtonImage);
            setNextButtonImage(nextButtonImage);
        }
    }
}
