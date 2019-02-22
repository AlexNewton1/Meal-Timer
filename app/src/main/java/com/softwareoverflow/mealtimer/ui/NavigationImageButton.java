package com.softwareoverflow.mealtimer.ui;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

public abstract class NavigationImageButton extends android.support.v7.widget.AppCompatImageButton {

    public NavigationImageButton(Context context) {
        super(context);
    }

    public NavigationImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavigationImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    abstract int getBackgroundId(boolean enabled);

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setBackground(ContextCompat.getDrawable(getContext(), getBackgroundId(enabled)));
    }
}
