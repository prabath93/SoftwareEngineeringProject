package com.example.prabaths.inner.frgments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.prabaths.Dialogs.DateSetting;
import com.example.prabaths.Dialogs.PickerDialog;
import com.example.prabaths.slidingmenu3.R;

import java.util.Calendar;

/**
 * Created by prabath s on 5/1/2016.
 */
public class Add_Fuel_Refill_Fragment extends Fragment {

    private static TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.add_fuel_refill, container, false);
        Calendar calendar=Calendar.getInstance();
        int year= calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day= calendar.get(Calendar.DAY_OF_MONTH);
        Button btn=(Button)v.findViewById(R.id.dateSelectBtn);

        textView= (TextView)v.findViewById(R.id.da);
        textView.setText(year + " - " + month + " - " + day);
        btn.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        buttonClicked(v);
                    }
                }
        );
        return v;
    }

    private void buttonClicked(View view){
        PickerDialog pickerDialog= new PickerDialog();

        pickerDialog.setTextView(textView);
        pickerDialog.show(getFragmentManager(), "Pick A Date");
        //DateSetting dateSetting=pickerDialog.getDateSetting();
        //dateSetting.setTextView(textView);

    }
}


