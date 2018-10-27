package com.weship.mover.Customer.adpater;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weship.mover.Customer.model.Customer_bids;
import com.weship.mover.Customer.model.Parent_model;
import com.weship.mover.R;

import java.util.ArrayList;

public class Customer_bid_Adapter extends BaseExpandableListAdapter {

    private Context context;
   private ArrayList<Parent_model> list;
    public Customer_bid_Adapter(Context context, ArrayList<Parent_model> parent_models) {
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
        ArrayList<Customer_bids> bids=list.get(listPosition).getBid();
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.customer_bid_list_item, null);
        }
        TextView mkmdl = (TextView) convertView.findViewById(R.id.mk_mdl);
        TextView origin = (TextView) convertView.findViewById(R.id.origin);
        TextView destination = (TextView) convertView.findViewById(R.id.destnation);
        TextView bid = (TextView) convertView.findViewById(R.id.bids);
        mkmdl.setText(bids.get(expandedListPosition).getModel());
        origin.setText(bids.get(expandedListPosition).getOrigin());
        destination.setText(bids.get(expandedListPosition).getDestination());
        bid.setText(bids.get(expandedListPosition).getBids());
        return convertView;
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
            convertView = layoutInflater.inflate(R.layout.customer_bid_list_group, null);
        }
        LinearLayout lables=(LinearLayout)convertView.findViewById(R.id.lables);

        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listname);
        ImageView listicon = (ImageView) convertView.findViewById(R.id.listicon);
        TextView conter = (TextView) convertView.findViewById(R.id.listnumber);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(list.get(listPosition).getTitle());
        conter.setText(String.valueOf(list.get(listPosition).getBid().size()));
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
