package com.weship.mover.Brocker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.weship.mover.R;

import java.util.Objects;


public class Brocker_dispatcher extends Fragment implements View.OnClickListener {
    public Brocker_dispatcher() {
    }

    View view;
    FragmentTransaction ft;
    LinearLayout ll_search_truck,ll_post;


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
    }

    private void clicks() {
        ll_search_truck.setOnClickListener(this);
        ll_post.setOnClickListener(this);
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
        }
    }


    public void open_fragment(Fragment fragment) {
        ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack("kamal");
        ft.commit();
    }

}
