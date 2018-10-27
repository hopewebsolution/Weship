package com.weship.mover.Customer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.weship.mover.R;

import java.util.Objects;

public class Customer_truck_traker_mapview extends Fragment implements View.OnClickListener,OnMapReadyCallback{
    public Customer_truck_traker_mapview() {
    }
    View view;
    private GoogleMap mMap;
    LinearLayout go_back,list_view;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.customer_truck_traking_mapview, container, false);
        inti(view);
        //click listner
        clicks();
        return view;
    }

    //find view  id
    private void inti(View view) {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        list_view=(LinearLayout) view.findViewById(R.id.list_view);
        go_back=(LinearLayout) view.findViewById(R.id.go_back);
    }
    // on click
    private void clicks() {
        list_view.setOnClickListener(this);
        go_back.setOnClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.isMyLocationEnabled();

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.go_back:
                getActivity().onBackPressed();
                break;
            case R.id.list_view:
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
