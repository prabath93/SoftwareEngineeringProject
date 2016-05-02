package com.example.prabaths.Data;

import android.provider.BaseColumns;

/**
 * Created by prabath s on 5/2/2016.
 */
public final class InstantDataContract {
    public InstantDataContract() {}

    /* Inner class that defines the table contents */
    public static abstract class InstantDataEntry implements BaseColumns {
        public static final String TABLE_NAME = "instantData";


        public static final String COLUMN_NAME_UNIT_PRICE = "unit_price";
        public static final String COLUMN_NAME_USER_ID = "user_id";
        public static final String COLUMN_NAME_CAR_ID = "car_id";
        public static final String COLUMN_NAME_DATE = "date";

    }
}
