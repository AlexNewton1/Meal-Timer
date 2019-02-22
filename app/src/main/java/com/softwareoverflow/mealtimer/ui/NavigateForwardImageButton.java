package com.softwareoverflow.mealtimer.ui;

import android.content.Context;
import android.util.AttributeSet;

import com.softwareoverflow.mealtimer.R;

public class NavigateForwardImageButton extends NavigationImageButton {

    public NavigateForwardImageButton(Context context) {
        super(context);
    }

    public NavigateForwardImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavigateForwardImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    int getBackgroundId(boolean enabled) {
        return enabled ? R.drawable.arrow_right : R.drawable.arrow_right_faded;
    }
}
