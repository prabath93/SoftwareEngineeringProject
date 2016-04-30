package com.example.prabaths.inner.frgments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prabaths.slidingmenu3.R;

/**
 * Created by prabath s on 5/1/2016.
 */
public class Add_Vehicle_Fragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.add_vehicle_details,container,false);
        return v;
    }
}
