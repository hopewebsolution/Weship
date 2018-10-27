package com.weship.mover.Brocker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weship.mover.R;

import java.util.Objects;


public class Broker_view_vehicle extends Fragment {
    public Broker_view_vehicle(){}
    View  view;
    FragmentTransaction ft;
    Button btn_submit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.carrier_addbid, container, false);
        return view;
    }
    public void open_fragment(Fragment fragment) {
        ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack("kamal");
        ft.commit();
    }

}
