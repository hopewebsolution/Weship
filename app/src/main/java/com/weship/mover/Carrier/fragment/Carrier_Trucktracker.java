package com.weship.mover.Carrier.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weship.mover.R;

import java.util.Objects;

public class Carrier_Trucktracker extends Fragment implements View.OnClickListener{
    public Carrier_Trucktracker() {
    }
    TextView mapview;
    FragmentTransaction ft;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.carrier_trucktracker, container, false);
        inti(view);
        //clicks lis
        clicks();
        return view;
    }

    //find view  id
    private void inti(View view) {
        mapview=(TextView) view.findViewById(R.id.mapview);
    }
    private void clicks() {
        mapview.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.mapview:
                ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Carrier_maptrucktraking());
                ft.addToBackStack("kamal");
                ft.commit();
                break;
        }
    }
}
