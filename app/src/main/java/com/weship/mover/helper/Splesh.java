package com.weship.mover.helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.weship.mover.R;
import com.weship.mover.utlity.Utlity;

public class Splesh extends AppCompatActivity {

    Thread next_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full  screen splesh
        Utlity.full_screen(Splesh.this);
        setContentView(R.layout.activity_splesh);
        next_screen = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(Splesh.this, Signin.class));
                    finishAffinity();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        next_screen.start();

    }
}
