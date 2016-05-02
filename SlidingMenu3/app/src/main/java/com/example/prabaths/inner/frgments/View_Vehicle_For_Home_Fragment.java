package com.example.prabaths.inner.frgments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prabaths.slidingmenu3.R;


/**
 * Created by prabath s on 3/31/2016.
 */
public class View_Vehicle_For_Home_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.view_vehicle_for_home,container,false);
        return v;
    }
}
