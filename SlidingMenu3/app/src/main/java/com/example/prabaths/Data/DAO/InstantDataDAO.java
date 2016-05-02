package com.example.prabaths.Data.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.prabaths.Data.InstantDataContract;
import com.example.prabaths.Data.SQLiteHelper;
import com.example.prabaths.VO.InstantData;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by prabath s on 5/2/2016.
 */
public class InstantDataDAO {
    private Context context;

    public InstantDataDAO(Context context) {
        this.context = context;
    }

    private List<InstantData> getAllInstantData(){
        System.out.println("innnnnnn");
        SQLiteHelper helper = SQLiteHelper.getInstance(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                InstantDataContract.InstantDataEntry.COLUMN_NAME_UNIT_PRICE,
                InstantDataContract.InstantDataEntry.COLUMN_NAME_DATE,
                InstantDataContract.InstantDataEntry.COLUMN_NAME_USER_ID,
                InstantDataContract.InstantDataEntry.COLUMN_NAME_CAR_ID,

        };
        String sortOrder = InstantDataContract.InstantDataEntry.COLUMN_NAME_CAR_ID;
        Cursor c = db.query(InstantDataContract.InstantDataEntry.TABLE_NAME, projection,null,null,null,null,sortOrder,null);

        ArrayList<InstantData> results = new ArrayList<>();
        while (c.moveToNext())
        {
            String dateSring=c.getString(c.getColumnIndex(InstantDataContract.InstantDataEntry.COLUMN_NAME_DATE));
            Date date=null;
            try {
                 date=SQLiteHelper.dateFromString(dateSring);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            InstantData idata = new InstantData(c.getInt(c.getColumnIndex(InstantDataContract.InstantDataEntry.COLUMN_NAME_CAR_ID)),date,
                    c.getDouble(c.getColumnIndex(InstantDataContract.InstantDataEntry.COLUMN_NAME_UNIT_PRICE)),
                    c.getString(c.getColumnIndex(InstantDataContract.InstantDataEntry.COLUMN_NAME_USER_ID)));

            results.add(idata);
        }
        return results;

    }
}
