package com.weship.mover.Fontclasses;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class Weshipedittextextrabold extends EditText {

    public Weshipedittextextrabold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Weshipedittextextrabold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Weshipedittextextrabold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/dosis_extrabold.ttf");
            setTypeface(tf);
        }
    }}

