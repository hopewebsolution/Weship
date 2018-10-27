package com.weship.mover.Carrier.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.weship.mover.R;
import java.util.Objects;

public class Carrier_company extends Fragment implements View.OnClickListener {
    public Carrier_company() {
    }
    View view;
    TextView track_order;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.carrier_company, container, false);
        inti(view);
        //clicks lis
        clicks();
        return view;
    }

    //find view  id
    private void inti(View view) {
        track_order=(TextView) view.findViewById(R.id.track_order);
    }
    private void clicks() {
        track_order.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.track_order:
                ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Carrier_Trucktracker());
                ft.addToBackStack("kamal");
                ft.commit();
                break;
        }
    }
}
