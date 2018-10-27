package com.weship.mover.Carrier.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weship.mover.R;

import java.util.Objects;

public class Carrier_maptrucktraking extends Fragment implements View.OnClickListener {
    TextView listview;
    View view;
    FragmentTransaction ft;
    public Carrier_maptrucktraking() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.customer_truck_traking_mapview, container, false);
        inti(view);
        //clicks lis
        clicks();
        return view;
    }
    //find view  id
    private void inti(View view) {
        listview=(TextView) view.findViewById(R.id.listview);
    }
    private void clicks() {
        listview.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.listview:
                ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Carrier_Trucktracker());
                ft.addToBackStack("kamal");
                ft.commit();
                break;
        }
    }
}
