package com.weship.mover.Carrier.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weship.mover.R;
import com.weship.mover.utlity.Utlity;

import java.util.Objects;

public class Carrier_search_for_vehicals extends Fragment implements View.OnClickListener {
    public Carrier_search_for_vehicals() {
    }
    View view;
    TextView track_order,min_veh_val,max_veh_val;
    Button btn_search;
    FragmentTransaction ft;
    LinearLayout ll_yes,ll_no,ll_saveyes,ll_saveno;
    ImageView decr_min_veh,incr_min_veh,min_dec_veh,max_dec_veh;
    String value,value1,Is_it_drivable,Save_search;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.carrier_search_for_vehicle, container, false);
        inti(view);
        //clicks lis
        clicks();
        return view;
    }
    //find view  id
    private void inti(View view) {
     //   track_order=(TextView) view.findViewById(R.id.track_order);
        btn_search=(Button) view.findViewById(R.id.btn_search);
        ll_yes=(LinearLayout) view.findViewById(R.id.ll_yes);
        ll_no=(LinearLayout) view.findViewById(R.id.ll_no);
        ll_saveyes=(LinearLayout) view.findViewById(R.id.ll_saveyes);
        ll_saveno=(LinearLayout) view.findViewById(R.id.ll_saveno);
        incr_min_veh=(ImageView) view.findViewById(R.id.incr_min_veh);
        decr_min_veh=(ImageView) view.findViewById(R.id.decr_min_veh);
        min_dec_veh=(ImageView) view.findViewById(R.id.min_dec_veh);
        max_dec_veh=(ImageView) view.findViewById(R.id.max_dec_veh);
        min_veh_val=(TextView) view.findViewById(R.id.min_veh_val);
        max_veh_val=(TextView) view.findViewById(R.id.max_veh_val);
        value = min_veh_val.getText().toString();
        value1 = max_veh_val.getText().toString();
    }
    private void clicks() {
       // track_order.setOnClickListener(this);
        btn_search.setOnClickListener(this);
        ll_yes.setOnClickListener(this);
        ll_no.setOnClickListener(this);
        ll_saveyes.setOnClickListener(this);
        ll_saveno.setOnClickListener(this);
        incr_min_veh.setOnClickListener(this);
        decr_min_veh.setOnClickListener(this);
        min_dec_veh.setOnClickListener(this);
        max_dec_veh.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_search:
                ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Carrier_serachresult());
                ft.addToBackStack("kamal");
                ft.commit();
                break;
            case R.id.ll_yes:
                ll_yes.setBackground(getResources().getDrawable(R.drawable.button_border_tranfranet));
                ll_no.setBackground(getResources().getDrawable(R.drawable.button_border_activie2));
                Is_it_drivable = "Yes";
                break;
            case R.id.ll_no:
                ll_no.setBackground(getResources().getDrawable(R.drawable.button_border_tranfranet));
                ll_yes.setBackground(getResources().getDrawable(R.drawable.button_border_activie2));
                Is_it_drivable ="No";
                break;
            case R.id.ll_saveyes:
                ll_saveyes.setBackground(getResources().getDrawable(R.drawable.button_border_tranfranet));
                ll_saveno.setBackground(getResources().getDrawable(R.drawable.button_border_activie2));
                Save_search = "Yes";
                break;
            case R.id.ll_saveno:
                ll_saveno.setBackground(getResources().getDrawable(R.drawable.button_border_tranfranet));
                ll_saveyes.setBackground(getResources().getDrawable(R.drawable.button_border_activie2));
                Save_search ="No";
                break;
            case R.id.incr_min_veh:
                Log.d("increas",value);
                int  a = Utlity.increase(value);
                value = String.valueOf(a);
                min_veh_val.setText(value);
                Log.d("noe incremnt val",String.valueOf(a));
                break;
            case R.id.decr_min_veh:
                Log.d("Decres",value);
                int b = Utlity.decrease(value);
                value = String.valueOf(b);
                min_veh_val.setText(value);
                Log.d("noe DECREMENT val",String.valueOf(b));
                break;
            case R.id.min_dec_veh:
                int  a1 = Utlity.decrease(value1);
                value1 = String.valueOf(a1);
                max_veh_val.setText(value1);
                break;
            case R.id.max_dec_veh:
                int b1 = Utlity.increase(value1);
                value1 = String.valueOf(b1);
                max_veh_val.setText(value1);
                break;
        }
    }
}
