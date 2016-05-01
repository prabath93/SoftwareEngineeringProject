package com.example.prabaths.Dialogs;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

/**
 * Created by prabath s on 5/1/2016.
 */
public class DateSetting implements DatePickerDialog.OnDateSetListener {

    Context context;
    TextView textView;
    public DateSetting(Context context,TextView textView){
        this.context=context;
        this.textView=textView;

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String s=year+" - "+(monthOfYear+1)+" - "+dayOfMonth;
        textView.setText(s);
        //TextView tv=(TextView) findViewById();
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();

    }

    public void setTextView(TextView textView){
        this.textView=textView;
    }
}
