package com.weship.mover.Carrier.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.weship.mover.Brocker.fragment.Brocker_index;
import com.weship.mover.R;

import java.util.Objects;

public class Carrier_index extends Fragment implements View.OnClickListener {
    public Carrier_index(){}
    View  view;
    LinearLayout ll_search_veh,ll_manage_ship,ll_post_truck;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.carrier_index, container, false);
        inti(view);
        //clicks lis
        clicks();
        return view;
    }


    //find view  id
    private void inti(View view) {
        ll_search_veh=(LinearLayout)view.findViewById(R.id.ll_search_veh);
        ll_manage_ship=(LinearLayout)view.findViewById(R.id.ll_manage_ship);
        ll_post_truck=(LinearLayout)view.findViewById(R.id.ll_post_truck);
    }
    private void clicks() {
        ll_search_veh.setOnClickListener(this);
        ll_manage_ship.setOnClickListener(this);
        ll_post_truck.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ll_search_veh:
                ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Carrier_search_for_vehicals());
                ft.addToBackStack("kamal");
                ft.commit();
                break;
                case R.id.ll_manage_ship:
                ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Carrier_dispatch_center());
                ft.addToBackStack("kamal");
                ft.commit();
                break;
                case R.id.ll_post_truck:
                ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Carrier_dispatch_center());
                ft.addToBackStack("kamal");
                ft.commit();
                break;
        }
    }
}
