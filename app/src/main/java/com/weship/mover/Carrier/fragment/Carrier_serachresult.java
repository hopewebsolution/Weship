package com.weship.mover.Carrier.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.weship.mover.Carrier.adapter.Carrier_searchresult_adapter;
import com.weship.mover.Carrier.model.Carrier_searchresult_model;
import com.weship.mover.R;
import java.util.ArrayList;

public class Carrier_serachresult extends Fragment{
    View view;
    ArrayList<Carrier_searchresult_model> carriermodel;
    ListView listView;
    Carrier_searchresult_adapter carrier_searchresult_adapter;
    public Carrier_serachresult() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.carrier_searchresult, container, false);
        inti(view);
        return view;
    }
    //find view  id
    private void inti(View view) {
        listView  = (ListView) view.findViewById(R.id.listview_data);
        carriermodel = new ArrayList<>();
        carriermodel.add(new Carrier_searchresult_model("Hws pvt ltd,Shastri nagar","Google pvt ltd,Vaishali nagar","yes","07/09/2018"));
        carriermodel.add(new Carrier_searchresult_model("Hws pvt ltd,Shastri nagar","Google pvt ltd,Vaishali nagar","yes","07/09/2018"));
        carriermodel.add(new Carrier_searchresult_model("Hws pvt ltd,Shastri nagar","Google pvt ltd,Vaishali nagar","yes","07/09/2018"));
        carrier_searchresult_adapter = new Carrier_searchresult_adapter(getContext(),carriermodel);
        listView.setAdapter(carrier_searchresult_adapter);
    }
}
