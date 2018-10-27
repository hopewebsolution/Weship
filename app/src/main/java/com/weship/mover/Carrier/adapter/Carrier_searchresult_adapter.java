package com.weship.mover.Carrier.adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.weship.mover.Carrier.model.Carrier_searchresult_model;
import com.weship.mover.R;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;


public class Carrier_searchresult_adapter extends BaseAdapter{
    private Context context;
    private ArrayList<Carrier_searchresult_model> searchlist;
    public Carrier_searchresult_adapter(Context ctx ,ArrayList<Carrier_searchresult_model> searchedlist) {
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
            listview = layoutInflater.inflate(R.layout.carrier_searchresult_listview,viewGroup,false);
            holder = new Holder();
            listview.setTag(holder);
        }else {
            holder = (Holder) listview.getTag();
        }
        holder.org_des = (TextView)listview.findViewById(R.id.org_des);
        holder.can_drive = (TextView)listview.findViewById(R.id.can_drive);
        holder.shipby = (TextView)listview.findViewById(R.id.shipby);
        holder.add_bid = (Button) listview.findViewById(R.id.add_bid);
        String org = searchlist.get(positon).getOrigin();
        String des = searchlist.get(positon).getDestination();
        String org_des1 = org+"\n \n"+des;
        searchlist.get(positon).setOrg_des(org_des1);
        holder.org_des.setText(searchlist.get(positon).getOrg_des());
        holder.can_drive.setText(searchlist.get(positon).getCandrive());
        holder.shipby.setText(searchlist.get(positon).getShipby());
        holder.add_bid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = ((Activity)context).getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
  //              fragmentTransaction.replace(R.id.fragment1, fragment2);
  //              fragmentTransaction.commit();
                //Log.d("ohk","clicked succesfully");
            }
        });
        return listview;
    }

    private static class Holder{
         TextView  org_des;
         TextView can_drive;
         TextView shipby;
         Button add_bid;
    }
}
