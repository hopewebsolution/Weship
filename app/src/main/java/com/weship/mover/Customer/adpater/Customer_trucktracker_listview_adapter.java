package com.weship.mover.Customer.adpater;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.weship.mover.Carrier.model.Carrier_searchresult_model;
import com.weship.mover.Customer.model.Customer_trackertracker_listview_model;
import com.weship.mover.R;

import java.util.ArrayList;


public class Customer_trucktracker_listview_adapter extends BaseAdapter{
    private Context context;
    private ArrayList<Customer_trackertracker_listview_model> searchlist;
    public Customer_trucktracker_listview_adapter(Context ctx , ArrayList<Customer_trackertracker_listview_model> searchedlist) {
      //  super(ctx,searchedlist);
        this.context = ctx;
        this.searchlist = searchedlist;
    }
    @Override
    public int getCount() {
        return searchlist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int positon, View listview, ViewGroup viewGroup) {
        Holder holder;
        if (listview==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listview = layoutInflater.inflate(R.layout.customer_truckertracker_listview,viewGroup,false);
            holder = new Holder();
            listview.setTag(holder);
        }else {
            holder = (Holder) listview.getTag();
        }
        holder.status = (TextView)listview.findViewById(R.id.status);
        holder.name = (TextView)listview.findViewById(R.id.name);
        holder.location = (TextView)listview.findViewById(R.id.location);
        holder.drive_time = (TextView) listview.findViewById(R.id.drive_time);
        holder.last_activity = (TextView) listview.findViewById(R.id.last_activity);
        holder.status.setText(searchlist.get(positon).getStatus());
        holder.name.setText(searchlist.get(positon).getName());
        holder.location.setText(searchlist.get(positon).getLocation());
        holder.drive_time.setText(searchlist.get(positon).getDrivetime());
        holder.last_activity.setText(searchlist.get(positon).getLast_activity());
        return listview;
    }

    private static class Holder{
         TextView status;
         TextView name;
         TextView location;
         TextView drive_time;
         TextView last_activity;
    }
}
