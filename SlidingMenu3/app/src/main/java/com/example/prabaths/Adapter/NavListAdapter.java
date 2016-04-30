package com.example.prabaths.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prabaths.models.NavItem;
import com.example.prabaths.slidingmenu3.R;

import java.util.List;

/**
 * Created by prabath s on 3/31/2016.
 */
public class NavListAdapter extends ArrayAdapter<NavItem> {

    Context context;
    int resLayout;
    List<NavItem> listNavItems;

    public NavListAdapter(Context context, int resLayout, List<NavItem> listNavItems) {
        super(context, resLayout, listNavItems);
        this.context=context;
        this.resLayout=resLayout;
        this.listNavItems=listNavItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context,resLayout,null);
        TextView tvTitle=(TextView)v.findViewById(R.id.title);
        TextView tvSubTitle=(TextView)v.findViewById(R.id.subtitle);
        ImageView navIcon=(ImageView)v.findViewById(R.id.nav_icon);

        NavItem navItem=listNavItems.get(position);
        tvTitle.setText(navItem.getTitle());
        tvSubTitle.setText(navItem.getSubTitle());
        navIcon.setImageResource(navItem.getResIcon());
        return v;
    }
}
