package com.example.prabaths.inner.frgments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.prabaths.slidingmenu3.R;

/**
 * Created by prabath s on 4/30/2016.
 */
public class Vehicle_Details_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.vehicle_details_fragment,container,false);
        Button btn1=(Button)v.findViewById(R.id.changeVehicleBtn);
        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        Toast.makeText(getActivity(), getActivity().toString(), Toast.LENGTH_LONG).show();
                        startActivityForResult(Intent.createChooser(intent,"Select Image"), 30);
                    }
                }
        );
        return v;
    }
}
