package com.weship.mover.Customer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weship.mover.R;

public class Good_to_go extends Fragment implements View.OnClickListener {
    public Good_to_go() {
    }

    View view;
    Button btn_tack_back;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.customer_good_to_fragment, container, false);
        inti(view);
        //clicks
        clicks();
        return view;
    }

    //find view  id
    private void inti(View view) {
        btn_tack_back=(Button)view.findViewById(R.id.btn_tack_back);
    }


    private void clicks() {
        btn_tack_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_tack_back:
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Customer_dashboard());
                ft.commit();
                break;
        }
    }
}
