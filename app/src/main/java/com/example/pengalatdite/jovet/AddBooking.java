package com.example.pengalatdite.jovet;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.pengalatdite.jovet.Adapter.AddAdapter;
import com.example.pengalatdite.jovet.SQL.DatabaseHelper;

import java.text.DateFormat;
import java.util.Calendar;

public class AddBooking extends AppCompatActivity {

    SQLiteDatabase mDatabase;
    DatabaseHelper myDb;

    private static final String TAG = "AddBooking";

    Calendar dateTime = Calendar.getInstance();
    DateFormat dateFormat = DateFormat.getDateTimeInstance();

    private TextView mDisplayDate;
    private TextView mDisplayTime;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    private Button btnAdd;
    private Button btnShow;

    String date, time;

    public static String EXTRA_DATE = "extra_date";
    public static String EXTRA_TIME = "extra_time";
    private Cursor c;
    private AddAdapter mAdapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_booking);
        mDisplayDate = (TextView)findViewById(R.id.tvDate);
        mDisplayTime = (TextView) findViewById(R.id.tvTime);
        btnAdd = (Button)findViewById(R.id.add_booking_button);
        btnShow = (Button)findViewById(R.id.add_booking_show_button);

        myDb = new DatabaseHelper(this);
        mDatabase = myDb.getWritableDatabase();

//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_coba2);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mAdapter = new AddAdapter(this, getAllItems());
//        recyclerView.setAdapter(mAdapter);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar myCalendar = Calendar.getInstance();
                int tahun = myCalendar.get(Calendar.YEAR);
                int bulan = myCalendar.get(Calendar.MONTH);
                int hari = myCalendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddBooking.this,
                        mDateSetListener,
                        tahun, bulan, hari);
                dialog.show();
            }
        });

        mDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar myTime = Calendar.getInstance();
                int jam = myTime.get(Calendar.HOUR_OF_DAY);
                int menit = myTime.get(Calendar.MINUTE);

                TimePickerDialog dialog = new TimePickerDialog(
                        AddBooking.this,
                        mTimeSetListener,
                        jam, menit,
                        android.text.format.DateFormat.is24HourFormat(AddBooking.this));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yy: " + dayOfMonth + "/" + month + "/" + year);

                date = dayOfMonth + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.d(TAG, "onTimeSet: hh:mm" + hourOfDay + "/" + minute);

                time = hourOfDay + ":" + minute;
                mDisplayTime.setText(time);
            }
        };


        addBooking();
        viewAll();

    }

    private void addBooking (){
//        Intent intent = new Intent();
//        intent.putExtra(EXTRA_TIME, time);
//        intent.putExtra(EXTRA_DATE, dateHrBln+dateThn);
////        intent.putExtra(EXTRA_DATE_THN, dateThn)
//        Log.d(TAG, "addBooking: Date " + dateHrBln+dateThn);
//        Log.d(TAG, "addBooking: Time " + time);
//
//        setResult(Activity.RESULT_OK, intent);
//        finish();

        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        boolean isInserted = myDb.insertData(
//                                mDisplayDate.getText().toString(),
//                                mDisplayTime.getText().toString());
//                        if (isInserted == true)
//                            Toast.makeText(AddBooking.this, "Data Inserted", Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(AddBooking.this, "Data not Inserted", Toast.LENGTH_LONG).show();

//                        addItem();

                    }
                }
        );

//        boolean insertData = myDb.insertData(date, time);
//
//        if (insertData){
//            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
//        }

    }

    public void viewAll(){
        btnShow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0){

                            showMessage("Error", "Nothing data found");

                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("Id: " + res.getString(0)+"\n");
                            buffer.append("Date: " + res.getString(1)+"\n");
                            buffer.append("Time: " + res.getString(2)+"\n");
                        }

                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage (String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

//    private void addItem(){
//        if (mDisplayDate.getText().toString().trim().length() == 0 || mDisplayTime.toString().trim().length() == 0){
//            return;
//        }
//        String date = mDisplayDate.getText().toString();
//        String time = mDisplayTime.getText().toString();
//        ContentValues cv = new ContentValues();
//        cv.put(AddBookingContract.BookingEntry.COLUMN_DATE, date);
//        cv.put(AddBookingContract.BookingEntry.COLUMN_TIME, time);
//
//        mAdapter.swapCursor(getAllItems());
//
//        mDatabase.insert(AddBookingContract.BookingEntry.TABLE_NAME, null, cv);
//
//    }

//    public Cursor getAllItems(){
//        return mDatabase.query(
//                AddBookingContract.BookingEntry.TABLE_NAME,
//                null,
//                null,
//                null,
//                null,
//                null,
//                AddBookingContract.BookingEntry.COLUMN_TIMESTAMP + " DESC"
//        );
//
////        return myDb.getAllData();
//
////        return c = myDb.getReadableDatabase().rawQuery("SELECT * FROM TABLE_NAME ", null);
//    }

}
