package com.weship.mover.helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.weship.mover.R;
import com.weship.mover.utlity.Utlity;

import java.util.LinkedHashMap;

public class Signin extends AppCompatActivity implements View.OnClickListener {

    EditText user_name, password;
    String str_user, str_password;
    LinearLayout ll_sign_in, ll_signup;
    LinkedHashMap<String, String> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utlity.full_screen(this);
        setContentView(R.layout.activity_signin);
        //to find id
        inti();
        //clicks  listener
        clicks();
    }


    private void inti() {
        user_name = (EditText) findViewById(R.id.edt_user);
        password = (EditText) findViewById(R.id.edt_password);
        ll_sign_in = (LinearLayout) findViewById(R.id.ll_sign_in);
        ll_signup = (LinearLayout) findViewById(R.id.ll_signup);
    }

    private void clicks() {
        ll_sign_in.setOnClickListener(this);
        ll_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ll_sign_in:

                //get  user passed values
                str_user = user_name.getText().toString();
                str_password = password.getText().toString();
                values = new LinkedHashMap<>();
                values.put(Utlity.type_email, str_user);
                values.put(Utlity.type_password, str_password);

                if (Utlity.is_valid(this, values)) {
                    startActivity(new Intent(Signin.this, Navigation.class));
                }

                break;
            case R.id.ll_signup:
                startActivity(new Intent(Signin.this, User_roll.class));
                break;
        }
    }
}
