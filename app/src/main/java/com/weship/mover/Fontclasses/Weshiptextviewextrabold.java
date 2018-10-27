package com.weship.mover.Fontclasses;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class Weshiptextviewextrabold extends TextView {

    public Weshiptextviewextrabold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Weshiptextviewextrabold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Weshiptextviewextrabold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/dosis_extrabold.ttf");
            setTypeface(tf);
        }
    }}

