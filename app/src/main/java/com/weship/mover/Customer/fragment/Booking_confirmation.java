package com.weship.mover.Customer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weship.mover.R;

public class Booking_confirmation extends Fragment implements View.OnClickListener {
    public Booking_confirmation(){}

    View  view;
    Button btn_yes,btn_no;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.customer_book_fragment, container, false);
        inti(view);
        //clicks
        clicks();
        return view;
    }

    //find view  id
    private void inti(View view) {
        btn_yes=(Button)view.findViewById(R.id.btn_yes);
        btn_no=(Button)view.findViewById(R.id.btn_no);
    }

    private void clicks() {
        btn_yes.setOnClickListener(this);
        btn_no.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_yes:
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Delivery_confirmation());
                ft.addToBackStack("kamal");
                ft.commit();
                break;
            case R.id.btn_no:
                getActivity().onBackPressed();
                break;
        }
    }
}
