package com.weship.mover.Brocker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.weship.mover.Carrier.fragment.Carrier_dispatch_center;
import com.weship.mover.Customer.fragment.New_vehicles_ship;
import com.weship.mover.R;
import com.weship.mover.helper.Navigation;

import java.util.Objects;


public class Brocker_index extends Fragment implements View.OnClickListener {
    public Brocker_index() {
    }

    View view;
    FragmentTransaction ft;
    LinearLayout ll_search_truck,ll_post,ll_mange;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.brocker_index, container, false);
        inti(view);
        //click listner
        clicks();
        return view;
    }

    //find view  id
    private void inti(View view) {
        ll_search_truck = (LinearLayout) view.findViewById(R.id.ll_search_truck);
        ll_post = (LinearLayout) view.findViewById(R.id.ll_post);
        ll_mange = (LinearLayout) view.findViewById(R.id.ll_mange);
    }

    private void clicks() {
        ll_search_truck.setOnClickListener(this);
        ll_post.setOnClickListener(this);
        ll_mange.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_search_truck:
                open_fragment(new Search_truck_space());
                break;
                case R.id.ll_post:
                open_fragment(new Broker_view_vehicle());
                break;
                case R.id.ll_mange:
                open_fragment(new Carrier_dispatch_center());
                break;
        }
    }


    public void open_fragment(Fragment fragment) {
        ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack("kamal");
        ft.commit();
    }

}
