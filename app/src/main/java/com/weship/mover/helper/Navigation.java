package com.weship.mover.helper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.weship.mover.Brocker.fragment.Brocker_index;
import com.weship.mover.Carrier.fragment.Carrier_index;
import com.weship.mover.Customer.fragment.Booking_confirmation;
import com.weship.mover.Customer.fragment.Customer_dashboard;
import com.weship.mover.Customer.fragment.Customer_truck_traker_mapview;
import com.weship.mover.R;

import static com.weship.mover.helper.User_roll.user_type;

public class Navigation extends AppCompatActivity implements View.OnClickListener {

    LinearLayout myaccount,ll_shi;
     FragmentTransaction ft;
     Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //find menu item ids
        menu_items(drawer);
        //clicks listner
        clicks_menu();

        if (user_type == 0) {
            //to open by defult index fragment of customer_index
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, new Customer_dashboard());
            ft.addToBackStack("kamal");
            ft.commit();
        } else if (user_type == 1) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, new Carrier_index());
            ft.addToBackStack("kamal");
            ft.commit();

        } else {
            //to open by defult index fragment of customer_index
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, new Brocker_index());
            ft.addToBackStack("kamal");
            ft.commit();
        }



    }

    // find menu  item ids
    private void menu_items(DrawerLayout drawer) {
        myaccount = (LinearLayout) drawer.findViewById(R.id.ll_myaccount);
        ll_shi = (LinearLayout) drawer.findViewById(R.id.ll_shi);
    }

    private void clicks_menu() {
        myaccount.setOnClickListener(this);
        ll_shi.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            if (getFragmentManager().getBackStackEntryCount() >0) {
                getFragmentManager().popBackStack ();
            } else {
                super.onBackPressed();

            }

        }
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.ll_myaccount:
                fragment = new Booking_confirmation();
                open_fragment(fragment);
                break;
            case R.id.ll_shi:
                fragment = new Customer_truck_traker_mapview();
                open_fragment(fragment);
                break;
        }
    }


    public void open_fragment(Fragment fragment) {
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
        close_navigation();
    }


    public void close_navigation() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }

}
