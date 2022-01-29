package com.example.pengalatdite.jovet;

import android.provider.BaseColumns;

public class AddBookingContract {

    private AddBookingContract(){}

    public static final class BookingEntry implements BaseColumns{
        public static final String TABLE_NAME = "bookingTable";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }

}
