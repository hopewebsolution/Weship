package com.weship.mover.helper;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.weship.mover.Brocker.fragment.Brocker_index;
import com.weship.mover.R;


public class User_roll extends AppCompatActivity implements View.OnClickListener {

    LinearLayout ll_broker,carrier,ll_customer;
   static int user_type=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_roll);
        //find ids
        find();
        //clicks
        clicks();
    }



    private void find() {
        ll_broker=(LinearLayout)findViewById(R.id.ll_broker);
        carrier=(LinearLayout)findViewById(R.id.carrier);
        ll_customer=(LinearLayout)findViewById(R.id.ll_customer);
    }

    private void clicks() {
        ll_broker.setOnClickListener(this);
        carrier.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.ll_broker:
                user_type=2;
                startActivity(new Intent(User_roll.this,Signup.class));
                break;
                case R.id.carrier:
                user_type=1;
                startActivity(new Intent(User_roll.this,Signup.class));
                break;
            case R.id.ll_customer:
                user_type=0;
                startActivity(new Intent(User_roll.this,Signup.class));
                break;

        }
    }

}
