package com.weship.mover.Fontclasses;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class Weshiptextviewregular extends TextView {

    public Weshiptextviewregular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Weshiptextviewregular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Weshiptextviewregular(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/dosis_regular.ttf");
            setTypeface(tf);
        }
    }}

