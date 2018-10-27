package com.weship.mover.Carrier.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.weship.mover.Carrier.adapter.Carrier_dispatcher_adapter;
import com.weship.mover.Customer.adpater.Customer_bid_Adapter;
import com.weship.mover.Customer.model.Customer_bids;
import com.weship.mover.Customer.model.Parent_model;
import com.weship.mover.R;

import java.util.ArrayList;

public class Carrier_dispatch_center extends Fragment {
    View view;
    ExpandableListView expandableListView;
    Carrier_dispatcher_adapter expandableListAdapter;
    ArrayList<Customer_bids> expandableListTitle = new ArrayList<>();
    ArrayList<Customer_bids> expandableListTitle1 = new ArrayList<>();
    ArrayList<Customer_bids> expandableListTitle2 = new ArrayList<>();
    ArrayList<Parent_model> expandableListDetail = new ArrayList<>();
    public Carrier_dispatch_center() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.carrier_dispatch_center, container, false);
        Customer_bids bid = new Customer_bids();
        bid.setModel("2013 TOyota\nblack");
        bid.setOrigin("subhas nagar, jaipur");
        bid.setDestination("Suncity nagar,Udaipur");
        bid.setBids("8");
        Customer_bids bid2 = new Customer_bids();
        bid2.setModel("2014 Maruti\n black");
        bid2.setOrigin("subhas nagar, jaipur");
        bid2.setDestination("Suncity nagar,Udaipur");
        bid2.setBids("6");

        Customer_bids bid3 = new Customer_bids();
        bid3.setModel("2013 BMW \nblack");
        bid3.setOrigin("subhas nagar, jaipur");
        bid3.setDestination("Suncity nagar,Udaipur");
        bid3.setBids("2");

        expandableListTitle1.add(bid);
        expandableListTitle.add(bid2);
        expandableListTitle2.add(bid3);

        Parent_model parent_model = new Parent_model();
        parent_model.setTitle("Active Bids");
        parent_model.setBid(expandableListTitle);

        Parent_model parent_model2 = new Parent_model();
        parent_model2.setTitle("Cancel Bids");
        parent_model2.setBid(expandableListTitle1);

        Parent_model parent_model3 = new Parent_model();
        parent_model3.setTitle("Complete Bids");
        parent_model3.setBid(expandableListTitle2);

        expandableListDetail.add(parent_model);
        expandableListDetail.add(parent_model2);
        expandableListDetail.add(parent_model3);

        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);

        expandableListAdapter = new Carrier_dispatcher_adapter(getContext(), expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        return view;
    }
}
