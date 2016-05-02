package com.example.prabaths.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by prabath s on 5/2/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "130614N.db";

    private static SQLiteHelper instance = null;
    private  static final String[] SQL_CREATE_ENTRIES =
            {"CREATE TABLE IF NOT EXISTS " + VehicleContract.VehicleEntry.TABLE_NAME +
                    " (" + VehicleContract.VehicleEntry.COLUMN_NAME_VEHICLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    VehicleContract.VehicleEntry.COLUMN_NAME_USER_ID+ " VARCHAR(20)  NOT NULL, "+
                    VehicleContract.VehicleEntry.COLUMN_NAME_REGISTRATION_NO  + " VARCHAR(50) NOT NULL, " +
                    VehicleContract.VehicleEntry.COLUMN_NAME_BRAND + " VARCHAR (50) NOT NULL, "+
                    VehicleContract.VehicleEntry.COLUMN_NAME_MODEL + " VARCHAR (50) NOT NULL, " +
                    VehicleContract.VehicleEntry.COLUMN_NAME_LAST_MILEAGE + " DECIMAL(10,2) NOT NULL, "+
                    VehicleContract.VehicleEntry.COLUMN_NAME_YEAR+" INTEGER  , "+
                    VehicleContract.VehicleEntry.COLUMN_NAME_IMAGE_URI+" VARCHAR (50)  )",
                    "CREATE TABLE IF NOT EXISTS " + UserContract.UserEntry.TABLE_NAME +
                            " (" + UserContract.UserEntry.COLUMN_NAME_NIC_NO + " VARCHAR(20) NOT NULL PRIMARY KEY,"+
                            UserContract.UserEntry.COLUMN_NAME_USER_NAME+ " VARCHAR(50) NOT NULL, "+
                            UserContract.UserEntry.COLUMN_NAME_EMAIL+ " VARCHAR(100) NOT NULL, "+
                            UserContract.UserEntry.COLUMN_NAME_PASSWORD +" VARCHAR(100) NOT NULL, "+
                            UserContract.UserEntry.COLUMN_NAME_NAME+" VARCHAR(50) , "+
                            UserContract.UserEntry.COLUMN_NAME_TELEPHONE_NO+" INTEGER , "+
                            UserContract.UserEntry.COLUMN_NAME_IMAGE_URI+" VARCHAR(50)  )",
                    "CREATE TABLE IF NOT EXISTS " + ExpenseContract.ExpenseEntry.TABLE_NAME +
                            " (" + ExpenseContract.ExpenseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY NOT NULL,"+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE+ " DATE NOT NULL, "+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_TYPE+ " INTEGER NOT NULL, "+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_COST+" DECIMAL(10,2) NOT NULL, "+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_PARTIAL_TANK+" INTEGER  , "+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_UNIT_PRICE+" DECIMAL(10,2) , "+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_ODOMETER_READING+" DECIMAL(10,2) , "+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_VOLUME+" DECIMAL(10,2) , "+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_LOCATION+" VARCHAR(20) , "+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_USER_ID+" VARCHAR(20) , "+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_CAR_ID+" INTEGER , "+
                            ExpenseContract.ExpenseEntry.COLUMN_NAME_NOTES+" VARCHAR(150)  )",
                    "CREATE TABLE IF NOT EXISTS " + InstantDataContract.InstantDataEntry.TABLE_NAME +
                            " (" + InstantDataContract.InstantDataEntry.COLUMN_NAME_UNIT_PRICE + " DECIMAL(10,2) ,"+
                            InstantDataContract.InstantDataEntry.COLUMN_NAME_DATE+ " DATE , "+
                            InstantDataContract.InstantDataEntry.COLUMN_NAME_CAR_ID+ " INTEGER  NOT NULL, "+
                            InstantDataContract.InstantDataEntry.COLUMN_NAME_USER_ID+" VARCHAR(20) NOT NULL  )"
            };
    private static final String[] SQL_DELETE_ENTRIES = {"DROP TABLE IF EXISTS " + VehicleContract.VehicleEntry.TABLE_NAME ,
            "DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME,
            "DROP TABLE IF EXISTS " + ExpenseContract.ExpenseEntry.TABLE_NAME,
            "DROP TABLE IF EXISTS " + InstantDataContract.InstantDataEntry.TABLE_NAME};







    private SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static String dateToString(Date date, Context context){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date);
        return dateString;

    }

    public static Date dateFromString(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date strDate = dateFormat.parse(date);
        return strDate;
    }






    public static SQLiteHelper getInstance(Context context)
    {
        if(instance == null)
            instance = new SQLiteHelper(context);
        return instance;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        for(String s : SQL_CREATE_ENTRIES)
        {
            System.out.println(s);
            db.execSQL(s);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for(String s : SQL_DELETE_ENTRIES)
        {
            db.execSQL(s);
        }
        onCreate(db);
    }
}
