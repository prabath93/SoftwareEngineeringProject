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
public class Edit_Vehicle_Details extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.edit_vehicle_details_fragment,container,false);
        return v;
    }
}
