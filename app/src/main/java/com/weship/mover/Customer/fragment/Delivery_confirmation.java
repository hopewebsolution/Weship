package com.weship.mover.Customer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.weship.mover.R;
import com.weship.mover.helper.Map_activity;

import java.util.ArrayList;


public class Delivery_confirmation extends Fragment implements  View.OnClickListener {
    public Delivery_confirmation() {
    }

    View view;
    Button btn_yes, btn_no;
    FragmentTransaction ft;
    Button map;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.delivery_confirm_fragment, container, false);
        inti(view);
        //clicks listner
        clicks();
        return view;
    }


    //find view  id
    private void inti(View view) {
        btn_no = (Button) view.findViewById(R.id.btn_no);
        btn_yes = (Button) view.findViewById(R.id.btn_yes);
        map=(Button) view.findViewById(R.id.map);
    }

    private void clicks() {
        btn_yes.setOnClickListener(this);
        btn_no.setOnClickListener(this);
        map.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_yes:
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Good_to_go());
                ft.commit();
                break;
            case R.id.btn_no:
                getActivity().onBackPressed();
                break;
            case R.id.map:
                startActivity(new Intent(getContext(), Map_activity.class));
                break;


        }
    }
}
