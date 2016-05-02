package com.example.prabaths.Data.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.prabaths.Data.InstantDataContract;
import com.example.prabaths.Data.SQLiteHelper;
import com.example.prabaths.Data.VehicleContract;
import com.example.prabaths.VO.InstantData;
import com.example.prabaths.VO.Vehicle;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by prabath s on 5/2/2016.
 */
public class VehicleDAO {
    Context context;
    public VehicleDAO(Context context){
        this.context=context;
    }
    public void addVehicle(Vehicle vehicle){
        SQLiteHelper helper = SQLiteHelper.getInstance(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VehicleContract.VehicleEntry.COLUMN_NAME_USER_ID,vehicle.getUserID());
        values.put(VehicleContract.VehicleEntry.COLUMN_NAME_REGISTRATION_NO,vehicle.getRegNo());
        values.put(VehicleContract.VehicleEntry.COLUMN_NAME_BRAND, vehicle.getBrand());
        values.put(VehicleContract.VehicleEntry.COLUMN_NAME_MODEL,vehicle.getModel());
        values.put(VehicleContract.VehicleEntry.COLUMN_NAME_LAST_MILEAGE,vehicle.getLastMileage());
        values.put(VehicleContract.VehicleEntry.COLUMN_NAME_YEAR,vehicle.getYear());
        values.put(VehicleContract.VehicleEntry.COLUMN_NAME_IMAGE_URI,vehicle.getImageURI());

        db.insert(VehicleContract.VehicleEntry.TABLE_NAME,null,values);

    }

    public Vehicle getVehicle(String userId){

        SQLiteHelper helper = SQLiteHelper.getInstance(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                VehicleContract.VehicleEntry.COLUMN_NAME_USER_ID,
                VehicleContract.VehicleEntry.COLUMN_NAME_REGISTRATION_NO,
                VehicleContract.VehicleEntry.COLUMN_NAME_BRAND,
                VehicleContract.VehicleEntry.COLUMN_NAME_MODEL,
                VehicleContract.VehicleEntry.COLUMN_NAME_LAST_MILEAGE,
                VehicleContract.VehicleEntry.COLUMN_NAME_YEAR,
                VehicleContract.VehicleEntry.COLUMN_NAME_IMAGE_URI
        };
        String sortOrder = VehicleContract.VehicleEntry.COLUMN_NAME_VEHICLE_ID + " DESC";
        Cursor c = db.query(VehicleContract.VehicleEntry.TABLE_NAME, projection, VehicleContract.VehicleEntry.COLUMN_NAME_USER_ID + "='" + userId +"'",null,null,null,sortOrder,null);

        if(c.moveToNext()) {
            Vehicle v = new Vehicle(c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_BRAND)),
                    c.getInt(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_VEHICLE_ID)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_IMAGE_URI)),
                    c.getDouble(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_LAST_MILEAGE)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_MODEL)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_REGISTRATION_NO)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_USER_ID)),
                    c.getInt(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_YEAR)));

            return  v;
        }
        else {
            return null;
        }

    }


    public Vehicle getVehicle(int vehicleID){

        SQLiteHelper helper = SQLiteHelper.getInstance(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                VehicleContract.VehicleEntry.COLUMN_NAME_USER_ID,
                VehicleContract.VehicleEntry.COLUMN_NAME_REGISTRATION_NO,
                VehicleContract.VehicleEntry.COLUMN_NAME_BRAND,
                VehicleContract.VehicleEntry.COLUMN_NAME_MODEL,
                VehicleContract.VehicleEntry.COLUMN_NAME_LAST_MILEAGE,
                VehicleContract.VehicleEntry.COLUMN_NAME_YEAR,
                VehicleContract.VehicleEntry.COLUMN_NAME_VEHICLE_ID,
                VehicleContract.VehicleEntry.COLUMN_NAME_IMAGE_URI
        };
        String sortOrder = VehicleContract.VehicleEntry.COLUMN_NAME_VEHICLE_ID + " DESC";
        Cursor c = db.query(VehicleContract.VehicleEntry.TABLE_NAME, projection,  VehicleContract.VehicleEntry.COLUMN_NAME_VEHICLE_ID+"="+vehicleID,null,null,null,sortOrder,null);

        if(c.moveToNext()) {
            Vehicle v = new Vehicle(c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_BRAND)),
                    c.getInt(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_VEHICLE_ID)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_IMAGE_URI)),
                    c.getDouble(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_LAST_MILEAGE)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_MODEL)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_REGISTRATION_NO)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_USER_ID)),
                    c.getInt(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_YEAR)));

            return  v;
        }
        else {
            return null;
        }

    }


    private List<Vehicle> getVehicleByUserID(String userID){
        SQLiteHelper helper = SQLiteHelper.getInstance(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                VehicleContract.VehicleEntry.COLUMN_NAME_USER_ID,
                VehicleContract.VehicleEntry.COLUMN_NAME_REGISTRATION_NO,
                VehicleContract.VehicleEntry.COLUMN_NAME_BRAND,
                VehicleContract.VehicleEntry.COLUMN_NAME_MODEL,
                VehicleContract.VehicleEntry.COLUMN_NAME_LAST_MILEAGE,
                VehicleContract.VehicleEntry.COLUMN_NAME_YEAR,
                VehicleContract.VehicleEntry.COLUMN_NAME_VEHICLE_ID,
                VehicleContract.VehicleEntry.COLUMN_NAME_IMAGE_URI

        };
        String sortOrder = VehicleContract.VehicleEntry.COLUMN_NAME_VEHICLE_ID;
        Cursor c = db.query(VehicleContract.VehicleEntry.TABLE_NAME, projection,VehicleContract.VehicleEntry.COLUMN_NAME_USER_ID + "='" + userID +"'",null,null,null,sortOrder,null);

        ArrayList<Vehicle> results = new ArrayList<>();
        while (c.moveToNext())
        {

            Vehicle v = new Vehicle(c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_BRAND)),
                    c.getInt(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_VEHICLE_ID)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_IMAGE_URI)),
                    c.getDouble(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_LAST_MILEAGE)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_MODEL)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_REGISTRATION_NO)),
                    c.getString(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_USER_ID)),
                    c.getInt(c.getColumnIndex(VehicleContract.VehicleEntry.COLUMN_NAME_YEAR)));

            results.add(v);
        }
        return results;

    }
}
