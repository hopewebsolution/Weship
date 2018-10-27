package com.weship.mover.Customer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weship.mover.R;
import com.weship.mover.helper.Place_picker;

public class New_vehicles_ship extends Fragment implements View.OnClickListener {
    public New_vehicles_ship() {
    }

    View view;
    LinearLayout ll_yes, ll_no, ll_back;
    Button btn_submit;
    FragmentTransaction ft;
    static TextView txt_solurce, destination;
    static int type = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.customer_new_vehicles_ship, container, false);
        inti(view);
        //click listner
        cliks();
        return view;
    }


    //find view  id
    private void inti(View view) {
        ll_no = (LinearLayout) view.findViewById(R.id.ll_no);
        ll_yes = (LinearLayout) view.findViewById(R.id.ll_yes);
        btn_submit = (Button) view.findViewById(R.id.btn_submit);
        ll_back = (LinearLayout) view.findViewById(R.id.ll_back);
        txt_solurce = (TextView) view.findViewById(R.id.txt_solurce);
        destination = (TextView) view.findViewById(R.id.destination);
    }

    private void cliks() {
        ll_yes.setOnClickListener(this);
        ll_no.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
        ll_back.setOnClickListener(this);
        txt_solurce.setOnClickListener(this);
        destination.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ll_yes:
                ll_yes.setBackground(getResources().getDrawable(R.drawable.button_border_tranfranet));
                ll_no.setBackground(getResources().getDrawable(R.drawable.button_border_activie2));
                break;
            case R.id.ll_no:
                ll_no.setBackground(getResources().getDrawable(R.drawable.button_border_tranfranet));
                ll_yes.setBackground(getResources().getDrawable(R.drawable.button_border_activie));
                break;
            case R.id.btn_submit:
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Delivery_confirmation());
                ft.addToBackStack("kamal");
                ft.commit();
                break;
            case R.id.ll_back:
                getActivity().onBackPressed();
                break;
            case R.id.txt_solurce:
                startActivity(new Intent(getActivity(), Place_picker.class));
                type=1;
                break;
            case R.id.destination:
                startActivity(new Intent(getActivity(), Place_picker.class));
                type = 2;
                break;
        }

    }


    public static void set_value(String value) {
        if (type == 1) {
            txt_solurce.setText(value);
        } else {
            destination.setText(value);
        }
    }
}

