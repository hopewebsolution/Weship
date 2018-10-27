package com.weship.mover.Fontclasses;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

public class Weshiptextviewbold extends TextView {

    public Weshiptextviewbold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Weshiptextviewbold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Weshiptextviewbold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/dosis_bold.ttf");
            setTypeface(tf);
        }
    }}

