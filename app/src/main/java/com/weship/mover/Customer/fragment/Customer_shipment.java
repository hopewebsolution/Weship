package com.weship.mover.Customer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weship.mover.Carrier.adapter.Carrier_dispatcher_adapter;
import com.weship.mover.Customer.adpater.Customer_shipment_adapter;
import com.weship.mover.Customer.model.Customer_bids;
import com.weship.mover.Customer.model.Customer_shipment_Parent_model;
import com.weship.mover.Customer.model.Customer_shipment_model;
import com.weship.mover.Customer.model.Parent_model;
import com.weship.mover.R;
import com.weship.mover.helper.Navigation;

import java.util.ArrayList;
import java.util.Objects;


public class Customer_shipment extends Fragment implements View.OnClickListener {
    public Customer_shipment(){}
    ExpandableListView expandableListView;
    Customer_shipment_adapter expandableListAdapter;
    ArrayList<Customer_shipment_model> expandableListTitle = new ArrayList<>();
    ArrayList<Customer_shipment_model> expandableListTitle1 = new ArrayList<>();
    ArrayList<Customer_shipment_model> expandableListTitle2 = new ArrayList<>();
    ArrayList<Customer_shipment_Parent_model> expandableListDetail = new ArrayList<>();
    View view;
    LinearLayout go_truck_tracker, go_back;
    Navigation navigation;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.customer_shipment, container, false);
        inti(view);
        //click listner
        clicks();
        Customer_shipment_model bid = new Customer_shipment_model();
        bid.setModel("2013 TOyota\nblack");
        bid.setOrigin("subhas nagar, jaipur");
        bid.setDestination("Suncity nagar,Udaipur");
        bid.setDel_window("9/04/2018 4:30-6:30");
        Customer_shipment_model bid2 = new Customer_shipment_model();
        bid2.setModel("2014 Maruti\n black");
        bid2.setOrigin("subhas nagar, jaipur");
        bid2.setDestination("Suncity nagar,Udaipur");
        bid2.setDel_window("9/04/2018 4:30-6:30");

        Customer_shipment_model bid3 = new Customer_shipment_model();
        bid3.setModel("2013 BMW \nblack");
        bid3.setOrigin("subhas nagar, jaipur");
        bid3.setDestination("Suncity nagar,Udaipur");
        bid3.setDel_window("9/04/2018 4:30-6:30");

        expandableListTitle1.add(bid);
        expandableListTitle.add(bid2);
        expandableListTitle2.add(bid3);

        Customer_shipment_Parent_model parent_model = new Customer_shipment_Parent_model();
        parent_model.setTitle("Waiting for pickup");
        parent_model.setBid(expandableListTitle);

        Customer_shipment_Parent_model parent_model2 = new Customer_shipment_Parent_model();
        parent_model2.setTitle("IN TRANSIT");
        parent_model2.setBid(expandableListTitle1);

        Customer_shipment_Parent_model parent_model3 = new Customer_shipment_Parent_model();
        parent_model3.setTitle("COMPLETED");
        parent_model3.setBid(expandableListTitle2);

        expandableListDetail.add(parent_model);
        expandableListDetail.add(parent_model2);
        expandableListDetail.add(parent_model3);

        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);

        expandableListAdapter = new Customer_shipment_adapter(getContext(), expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        return view;
    }

    //find view  id
    private void inti(View view) {
        go_truck_tracker=(LinearLayout) view.findViewById(R.id.go_truck_tracker);
        go_back=(LinearLayout) view.findViewById(R.id.go_back);

    }
    private void clicks() {
        go_truck_tracker.setOnClickListener(this);
        go_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.go_back:
                getActivity().onBackPressed();
                break;
            case R.id.go_truck_tracker:
                open_fragment(new Customer_truck_tracker_listview());
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
