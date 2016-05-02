package com.example.prabaths.inner.frgments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabaths.Dialogs.PickerDialog;
import com.example.prabaths.slidingmenu3.R;

import java.util.Calendar;

/**
 * Created by prabath s on 5/1/2016.
 */
public class Edit_Profile_Fragment extends Fragment{

    private static TextView textView;
    private static ImageView iv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.edit_profile_fragment, container, false);

        Toast.makeText(getActivity(), String.valueOf(v.getId()), Toast.LENGTH_SHORT).show();
        Calendar calendar=Calendar.getInstance();
        int year= calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day= calendar.get(Calendar.DAY_OF_MONTH);
        Button btn=(Button)v.findViewById(R.id.dateSelectBtn3);
        iv=(ImageView)v.findViewById(R.id.profPicImView);

        textView= (TextView)v.findViewById(R.id.da3);
        textView.setText(year + " - " + month + " - " + day);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        buttonClicked(v);
                    }
                }
        );
        Button btn2=(Button)v.findViewById(R.id.changeEmailBtn);
        btn2.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Dialog dialog=new Dialog(getActivity());
                        dialog.setTitle("Change Email Dialog");
                        dialog.setContentView(R.layout.change_email_dialog);
                        dialog.show();
                    }
                });
        Button btn3=(Button)v.findViewById(R.id.changeProfileBtn);
        btn3.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        Toast.makeText(getActivity(), getActivity().toString(), Toast.LENGTH_LONG).show();
                        startActivityForResult(Intent.createChooser(intent,"Select Image"), 1);

                        //iv.setImageURI(intent.getData());
                        Toast.makeText(getActivity(), iv.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        return v;
    }

   /* public void onActivityResult(int req,int res,Intent data){
        Toast.makeText(getActivity(),"inside",Toast.LENGTH_LONG).show();

    }*/

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
       // super.onActivityResult(requestCode,resultCode,data);
        Toast.makeText(getActivity(),"success",Toast.LENGTH_LONG).show();

        if(resultCode== Activity.RESULT_OK){
            if(requestCode==1){
                iv.setImageResource(0);
                iv.setImageURI(data.getData());
                Toast.makeText(getActivity(),"success",Toast.LENGTH_LONG).show();
            }
        }

    }

    private void buttonClicked(View view){
        PickerDialog pickerDialog= new PickerDialog();

        pickerDialog.setTextView(textView);
        pickerDialog.show(getFragmentManager(), "Pick A Date");
        //DateSetting dateSetting=pickerDialog.getDateSetting();
        //dateSetting.setTextView(textView);

    }

}
