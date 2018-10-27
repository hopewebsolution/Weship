package com.weship.mover.Fontclasses;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class Weshipedittextmedium extends EditText {

    public Weshipedittextmedium(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Weshipedittextmedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Weshipedittextmedium(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/dosis_medium.ttf");
            setTypeface(tf);
        }
    }}

