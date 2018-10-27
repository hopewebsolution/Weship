package com.weship.mover.Customer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.weship.mover.R;
import com.weship.mover.helper.Navigation;

import java.util.Objects;


public class Customer_dashboard extends Fragment implements View.OnClickListener {
    public Customer_dashboard(){}
    View  view;
    LinearLayout ll_customer,ll_mange;
    Navigation navigation;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.customer_index, container, false);
        inti(view);
        //click listner
        clicks();
        return view;
    }

    //find view  id
    private void inti(View view) {
        ll_customer=(LinearLayout)view.findViewById(R.id.ll_customer);
        ll_mange=(LinearLayout)view.findViewById(R.id.ll_mange);

    }
    private void clicks() {
        ll_customer.setOnClickListener(this);
        ll_mange.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.ll_customer:
                open_fragment(new New_vehicles_ship());
                break;
            case R.id.ll_mange:
                open_fragment(new Customer_shipment());
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
