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

public class Signup extends AppCompatActivity implements View.OnClickListener {

    EditText edt_password,edt_confirm_password,edt_name,edt_mobile,edt_email;
    String str_name,str_email,str_mobile,str_password,str_confirm_password;
    LinearLayout ll_sign_in,ll_signup;
    LinkedHashMap<String,String> values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //to find id
        inti();
        //clicks  listener
        clicks();
    }

    private void inti() {
        edt_name=(EditText)findViewById(R.id.edt_name);
        edt_email=(EditText)findViewById(R.id.edt_email);
        edt_password=(EditText)findViewById(R.id.edt_password);
        edt_confirm_password=(EditText)findViewById(R.id.edt_confirm_password);
        edt_mobile=(EditText)findViewById(R.id.edt_mobile);
        ll_sign_in=(LinearLayout)findViewById(R.id.ll_sign_in);
        ll_signup=(LinearLayout)findViewById(R.id.ll_sign_up);
    }



    private void clicks() {
        ll_sign_in.setOnClickListener(this);
        ll_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.ll_sign_up:

                //get  user passed values
                str_name=edt_name.getText().toString();
                str_email=edt_email.getText().toString();
                str_mobile=edt_mobile.getText().toString();
                str_password=edt_password.getText().toString();
                str_confirm_password=edt_confirm_password.getText().toString();

                values=new LinkedHashMap<>();
                values.put(Utlity.type_name,str_name);
                values.put(Utlity.type_email,str_email);
                values.put(Utlity.type_mobile,str_mobile);
                values.put(Utlity.type_password,str_password);
                values.put(Utlity.type_confirm_password,str_confirm_password);
                values.put(Utlity.type_match,str_password+"match"+str_confirm_password);

                if(Utlity.is_valid(this,values) && Utlity.is_online(this))
                {
                    startActivity(new Intent(Signup.this,Navigation.class));
                }


                break;
            case R.id.ll_sign_in:
                startActivity(new Intent(Signup.this,Signin.class));
                finish();
                break;
        }
    }

}
