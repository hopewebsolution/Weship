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


public class Search_truck_space extends Fragment implements View.OnClickListener {
    public Search_truck_space(){}
    View  view;
    FragmentTransaction ft;
    Button btn_submit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.broker_search_speace, container, false);
        inti(view);
        //click listner
        clicks();
        return view;
    }

    //find view  id
    private void inti(View view) {
        btn_submit = (Button)view.findViewById(R.id.btn_submit);

    }
    private void clicks() {
        btn_submit.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
     open_fragment(new broker_avail_truck_space() );

    }
    public void open_fragment(Fragment fragment) {
        ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack("kamal");
        ft.commit();
    }

}
