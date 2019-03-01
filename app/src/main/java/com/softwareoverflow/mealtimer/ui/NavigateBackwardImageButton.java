package com.softwareoverflow.mealtimer.ui;

import android.content.Context;
import android.util.AttributeSet;

import com.softwareoverflow.mealtimer.R;

public class NavigateBackwardImageButton extends NavigationImageButton {

    public NavigateBackwardImageButton(Context context) {
        super(context);
    }

    public NavigateBackwardImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavigateBackwardImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    int getBackgroundId(boolean enabled) {
        return enabled ? R.drawable.icon_arrow_left : R.drawable.icon_arrow_left_faded;
    }
}
