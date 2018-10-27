package com.weship.mover.Customer.adpater;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.weship.mover.Customer.fragment.Customer_bid;
import com.weship.mover.Customer.model.Customer_shipment_Parent_model;
import com.weship.mover.Customer.model.Customer_shipment_model;
import com.weship.mover.Customer.model.Parent_model;
import com.weship.mover.R;

import java.util.ArrayList;
import java.util.Objects;

public class Customer_shipment_adapter extends BaseExpandableListAdapter {
   private Context context;
   FragmentTransaction ft;
   private ArrayList<Customer_shipment_Parent_model> list;
    public Customer_shipment_adapter(Context context, ArrayList<Customer_shipment_Parent_model> parent_models) {
        this.context = context;
        this.list=parent_models;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return list.get(listPosition).getBid();
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        ArrayList<Customer_shipment_model> bids=list.get(listPosition).getBid();
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.customer_shipment_list_item, null);
        }
        TextView mkmdl = (TextView) convertView.findViewById(R.id.mk_mdl);
        TextView origin_des = (TextView) convertView.findViewById(R.id.origin_des);
        TextView del_window = (TextView) convertView.findViewById(R.id.del_window);
        Button view_btn = (Button) convertView.findViewById(R.id.view);
        String org = bids.get(expandedListPosition).getOrigin();
        String des = bids.get(expandedListPosition).getDestination();
        String org_des = org+"\n \n"+des;
        mkmdl.setText(bids.get(expandedListPosition).getModel());
        origin_des.setText(org_des);
        del_window.setText(bids.get(expandedListPosition).getDel_window());
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ohk ","CLick");
                /*//openfragment(new Customer_bid());
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Customer_bid myfragemnt = new Customer_bid();
                Fragment fragment = new Fragment();
                FragmentManager fragmentManager = activity.getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.commentedtext,new Customer_bid());
                fragmentTransaction.commit();*/

            }
        });
    //    bid.setText(bids.get(expandedListPosition).getBids());

        return convertView;
    }

    private void openfragment(Fragment fragment) {

    }

    @Override
    public int getChildrenCount(int listPosition) {
        return list.get(listPosition).getBid().size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return list.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.customer_shipment_list_group, null);
        }
        LinearLayout lables=(LinearLayout)convertView.findViewById(R.id.lables);

        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listname);
        ImageView listicon = (ImageView) convertView.findViewById(R.id.listicon);

        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(list.get(listPosition).getTitle());
        if (isExpanded) {
            lables.setVisibility(View.VISIBLE);
            listicon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_arrow_drop_down));
        } else {
            lables.setVisibility(View.GONE);
            listicon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_play));

        }
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
