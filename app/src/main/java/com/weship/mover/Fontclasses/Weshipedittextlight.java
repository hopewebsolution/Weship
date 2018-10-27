package com.weship.mover.Fontclasses;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class Weshipedittextlight extends EditText {

    public Weshipedittextlight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Weshipedittextlight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Weshipedittextlight(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/dosis_light.ttf");
            setTypeface(tf);
        }
    }}

