package com.weship.mover.Fontclasses;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class Weshipedittextsemibold extends EditText {

    public Weshipedittextsemibold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Weshipedittextsemibold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Weshipedittextsemibold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/dosis_semibold.ttf");
            setTypeface(tf);
        }
    }}

