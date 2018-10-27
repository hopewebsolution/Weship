package com.weship.mover.Customer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.weship.mover.Carrier.adapter.Carrier_searchresult_adapter;
import com.weship.mover.Carrier.model.Carrier_searchresult_model;
import com.weship.mover.Customer.adpater.Customer_trucktracker_listview_adapter;
import com.weship.mover.Customer.model.Customer_trackertracker_listview_model;
import com.weship.mover.R;
import com.weship.mover.helper.Navigation;

import java.util.ArrayList;
import java.util.Objects;


public class Customer_truck_tracker_listview extends Fragment implements View.OnClickListener {
    public Customer_truck_tracker_listview(){}
    View  view;
    ArrayList<Customer_trackertracker_listview_model> carriermodel;
    ListView listView;
    Customer_trucktracker_listview_adapter carrier_searchresult_adapter;
    LinearLayout map_view, go_back;
    Navigation navigation;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.customer_trucktracker, container, false);
        inti(view);
        //click listner
        clicks();
        return view;
    }

    //find view  id
    private void inti(View view) {
        map_view=(LinearLayout) view.findViewById(R.id.map_view);
        go_back=(LinearLayout) view.findViewById(R.id.go_back);
        listView  = (ListView) view.findViewById(R.id.listview_data);
        carriermodel = new ArrayList<>();
        carriermodel.add(new Customer_trackertracker_listview_model("Hws team","Vaishali nagar","11:30","sep 07","off"));carriermodel.add(new Customer_trackertracker_listview_model("Hws team","Vaishali nagar","11:30","sep 07","off"));
        carriermodel.add(new Customer_trackertracker_listview_model("Hws team","Vaishali nagar","11:30","sep 07","off"));carriermodel.add(new Customer_trackertracker_listview_model("Hws team","Vaishali nagar","11:30","sep 07","on"));
        carriermodel.add(new Customer_trackertracker_listview_model("Hws team","Vaishali nagar","11:30","sep 07","off"));carriermodel.add(new Customer_trackertracker_listview_model("Hws team","Vaishali nagar","11:30","sep 07","off"));
        carrier_searchresult_adapter = new Customer_trucktracker_listview_adapter(getContext(),carriermodel);
        listView.setAdapter(carrier_searchresult_adapter);

    }
    private void clicks() {
        map_view.setOnClickListener(this);
        go_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.go_back:
                getActivity().onBackPressed();
                break;
            case R.id.map_view:
                open_fragment(new Customer_truck_traker_mapview());
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
