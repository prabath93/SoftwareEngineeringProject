package com.example.prabaths.inner.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.prabaths.TravelBuddy.Login_Activity;
import com.example.prabaths.TravelBuddy.R;
import com.example.prabaths.inner.activity.Fuel_Expense_Graph_Activity;

/**
 * Created by prabath s on 6/15/2016.
 */
public class LogOut_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.logout_fragment, container, false);

        Intent intent=new Intent(getActivity(),Login_Activity.class);
        startActivity(intent);
        getActivity().finish();

        return v;
    }

}
