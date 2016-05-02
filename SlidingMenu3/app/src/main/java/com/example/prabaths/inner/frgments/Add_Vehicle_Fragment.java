package com.example.prabaths.inner.frgments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabaths.Data.DAO.VehicleDAO;
import com.example.prabaths.VO.Vehicle;
import com.example.prabaths.slidingmenu3.R;

/**
 * Created by prabath s on 5/1/2016.
 */
public class Add_Vehicle_Fragment extends Fragment{

    EditText regNoTxt;
    EditText modelTxt;
    EditText brandTxt;
    EditText yearTxt;
    VehicleDAO vehicleDAO;

    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.add_vehicle_details,container,false);
        vehicleDAO=new VehicleDAO(this.getContext());
        Button btn1=(Button) v.findViewById(R.id.addVehicleBtn);
        regNoTxt=(EditText) v.findViewById(R.id.regNoTxt);
        modelTxt=(EditText) v.findViewById(R.id.modelTxt);
        brandTxt=(EditText) v.findViewById(R.id.brandTxt);
        yearTxt=(EditText) v.findViewById(R.id.yearTxt);
        btn1.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        addButtonClicked();
                    }
                }
        );
        return v;
    }


    private void addButtonClicked(){
        Vehicle v=new Vehicle(brandTxt.getText().toString(),2,null,99.0,modelTxt.getText().toString(),regNoTxt.getText().toString(),"prabath",Integer.parseInt(yearTxt.getText().toString()));
        vehicleDAO.addVehicle(v);
        Toast.makeText(getContext(),"Vehicle Successfully added",Toast.LENGTH_LONG).show();
        regNoTxt.setText("");
        modelTxt.setText("");
        brandTxt.setText("");
        yearTxt.setText("");
    }
}
