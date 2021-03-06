package com.example.prabaths.Server;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.prabaths.Data.SQLiteHelper;
import com.example.prabaths.Fragments.Home_Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prabath s on 6/8/2016.
 */
public class GetFromDB {

    RequestQueue requestQueue;
    Context context;
    String getAverageEconomyOfAModelURL = "http://travelbuddy.netai.net/get_average_economy_of_a_model.php";
    String getAverageEconomyOfATypeURL = "http://travelbuddy.netai.net/get_average_economy_of_a_type.php";
    String getAverageCostOfAModelURL="http://travelbuddy.netai.net/get_total_average_cost_of_a_model.php";
    String getAverageCostOfATypeURL="http://travelbuddy.netai.net/get_total_average_cost_of_a_type.php";
    String getAverageFuelCostOfAModelURL="http://travelbuddy.netai.net/get_average_fuel_cost_of_a_model.php";
    String getAverageFuelCostOfATypeURL="http://travelbuddy.netai.net/get_average_fuel_cost_of_a_type.php";
    String getAverageOtherCostOfAModelURL="http://travelbuddy.netai.net/get_average_other_cost_of_a_model.php";
    String getAverageOtherCostOfATypeURL="http://travelbuddy.netai.net/get_average_other_cost_of_a_type.php";
    SQLiteHelper helper;
    String averageEconomyOfAModel;
    String averageEconomyOfAType;
    String averageTotalCostOfAModel;
    String averageTotalCostOfAType;
    String averageFuelCostOfAModel;
    String averageFuelCostOfAType;
    String averageOtherCostOfAModel;
    String averageOtherCostOfAType;


    public GetFromDB(Context context){
        this.context=context;
        this.requestQueue = Volley.newRequestQueue(context);
        this.helper=SQLiteHelper.getInstance(context);
    }

    /**
     * This method get average economy of the given vehicle model
     * @param model model
     * @param a TextView which needs to be updated according to the received value
     */
    public void getAverageEconomyOfAModel(final String model, final TextView a){

        StringRequest request = new StringRequest(Request.Method.POST, getAverageEconomyOfAModelURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                String result1=convertResult(response);
                if(response!=null){
                    try{double b=Double.parseDouble(result1);
                        b=Math.round(b*100.0)/100.0;
                        if(b!=0){a.setText(String.valueOf(b));}
                    }catch (NumberFormatException e){
                        a.setText("Not available");
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();

                parameters.put("model",model);

                return parameters;
            }
        };
        requestQueue.add(request);


        //return averageEconomyOfAModel;
    }

    /**
     * Get average economy of the given type of vehicle
     * @param type type of vehicle
     * @param a TextView which needs to be updated according to the received value
     */
    public void getAverageEconomyOfAType(final String type,final TextView a){
        StringRequest request = new StringRequest(Request.Method.POST, getAverageEconomyOfATypeURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response!=null){
                    String result1=convertResult(response);
                    try{double b=Double.parseDouble(result1);
                        b=Math.round(b*100.0)/100.0;
                        if(b!=0){a.setText(String.valueOf(b));}
                    }catch (NumberFormatException e){
                        a.setText("Not available");
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();

                parameters.put("type",type);

                return parameters;
            }
        };
        requestQueue.add(request);
    }

    /**
     * This method gets the average cost of the given model of vehicle
     * @param model model of vehicle
     * @param a TextView which needs to be updated according to the received value
     */
    public void getAverageCostOfAModel(final String model,final TextView a){
        StringRequest request = new StringRequest(Request.Method.POST, getAverageCostOfAModelURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                String result1=convertResult(response);
                if(response!=null){
                    try{double b=Double.parseDouble(result1);
                        if(b!=0){a.setText(result1);}
                    }catch (NumberFormatException e){
                        a.setText("Not available");
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();


                parameters.put("model",model);

                return parameters;
            }
        };
        requestQueue.add(request);
    }

    /**
     * This method gets the average cost of the given type of vehicle
     * @param type type of vehicle
     * @param a TextView which needs to be updated according to the received value
     */
    public void getAverageCostOfAType(final String type,final TextView a){
        StringRequest request = new StringRequest(Request.Method.POST, getAverageCostOfATypeURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response!=null){

                    String result1=convertResult(response);
                    try{double b=Double.parseDouble(result1);
                        if(b!=0){a.setText(result1);}
                    }catch (NumberFormatException e){
                        a.setText("Not available");
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();


                parameters.put("type",type);

                return parameters;
            }
        };

        requestQueue.add(request);
    }

    /**
     * This method gets the average fuel cost of the given type of vehicle
     * @param type type of vehicle
     * @param a TextView which needs to be updated according to the received value
     */
    public void getAverageFuelCostOfAType(final String type,final TextView a){
        StringRequest request = new StringRequest(Request.Method.POST, getAverageFuelCostOfATypeURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response!=null){
                    String result1=convertResult(response);
                    try{double b=Double.parseDouble(result1);
                        if(b!=0){a.setText(result1);}
                    }catch (NumberFormatException e){
                        a.setText("Not available");
                    }
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();

                parameters.put("type",type);

                return parameters;
            }
        };
        requestQueue.add(request);
    }


    /**
     * This method gets the average fuel cost of the given model of vehicle
     * @param model model of vehicle
     * @param a TextView which needs to be updated according to the received value
     */
    public void getAverageFuelCostOfAModel(final String model,final TextView a){
        StringRequest request = new StringRequest(Request.Method.POST, getAverageFuelCostOfAModelURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response!=null){
                    String result1=convertResult(response);
                    try{double b=Double.parseDouble(result1);
                        if(b!=0){a.setText(result1);}
                    }catch (NumberFormatException e){
                        a.setText("Not available");
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();


                parameters.put("model",model);

                return parameters;
            }
        };
        requestQueue.add(request);
    }


    /**
     * This method gets the average other cost of the given model of vehicle
     * @param model model of vehicle
     * @param a TextView which needs to be updated according to the received value
     */
    public void getAverageOtherCostOfAModel(final String model,final TextView a){
        StringRequest request = new StringRequest(Request.Method.POST, getAverageOtherCostOfAModelURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response!=null){
                    String response1=convertResult(response);
                    try{double b=Double.parseDouble(response1);
                        if(b!=0){a.setText(response1);}
                    }catch (NumberFormatException e){
                        a.setText("Not available");
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();


                parameters.put("model",model);

                return parameters;
            }
        };
        requestQueue.add(request);
    }


    /**
     * This method gets the average cost of the given type of
     * @param type type of vehicle
     * @param a TextView which needs to be updated according to the received value
     */
    public void getAverageOtherCostOfAType(final String type,final TextView a){
        StringRequest request = new StringRequest(Request.Method.POST, getAverageOtherCostOfATypeURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response!=null){
                    String result1=convertResult(response);
                    try{double b=Double.parseDouble(result1);

                        if(b!=0){a.setText(result1);}
                    }catch (NumberFormatException e){
                        a.setText("Not available");
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();

                parameters.put("type",type);

                return parameters;
            }
        };
        requestQueue.add(request);
    }

    public String convertResult(String response){
        String[] arr=response.split("");
        String result="";
        for(int i=0;i<arr.length;i++){


            try{
                if(arr[0].equals("")){
                    if(i!=0){
                        if(!arr[i].equals(".")) {
                            int a = Integer.parseInt(arr[i]);
                            result = result + String.valueOf(a);
                        }
                        else{result=result+arr[i];}
                    }
                }
                else{
                    double a=Double.parseDouble(arr[i]);
                    result=result+String.valueOf(a);
                }


            }
            catch (NumberFormatException e){
                return result;
            }
        }
        return result;
    }


}
