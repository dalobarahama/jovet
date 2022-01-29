package com.example.pengalatdite.jovet.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pengalatdite.jovet.Adapter.AddAdapter;
import com.example.pengalatdite.jovet.AddBooking;
import com.example.pengalatdite.jovet.R;
import com.example.pengalatdite.jovet.SQL.DatabaseHelper;

/**
 * A simple {@link Fragment} subclass.
 */

public class BookingFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "BookingFragment";

    DatabaseHelper myDb;

    public static AddAdapter adapter;
    //    private ArrayList<Add> addList = new ArrayList<>();
//    public static ArrayList<String> mDate = new ArrayList<>();
//    public static ArrayList<String> mTime = new ArrayList<>();
    private Context mContext;
//    Cursor res = myDb.getAllData();

    public BookingFragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: started");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_booking, container, false);
//        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rv_booking);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new AddAdapter(BookingFragment.model, getContext());
//        recyclerView.setAdapter(adapter);

//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        AddBooking addBooking = new AddBooking();
//        adapter = new AddAdapter(getContext(), addBooking.getAllItems());
//        recyclerView.setAdapter(adapter);

        ImageButton addBtn = (ImageButton) v.findViewById(R.id.addButton);
        addBtn.setOnClickListener((View.OnClickListener) this);

        mContext = container.getContext();

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_booking);
//        AddAdapter adapter = new AddAdapter(addList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        recyclerView.setAdapter(adapter);

//        bookingData();
    }

//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(mContext ,AddBooking.class);
//        startActivity(intent);
//
//    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data){
//        if (requestCode == 1){
//            if ((resultCode == Activity.RESULT_OK)){
//                Bundle extras = data.getExtras();
//                if (extras != null){
//                    String date = extras.getString(AddBooking.EXTRA_DATE);
//                    String time = extras.getString(AddBooking.EXTRA_TIME);
//                        Log.d(TAG, "onActivityResult: date recived " + date);
//                        Log.d(TAG, "onActivityResult: time recived " + time);
//                    Add addBooking = new Add(date, time);
//                    addList.add(addBooking);
//                    adapter.setBookingList((ArrayList<Add>) addList);
//                    adapter.notifyItemInserted(addList.size());
//                }
//
//            }
//
//            if (resultCode == Activity.RESULT_CANCELED){
//
//            }
//        }
//
//    }

//    protected void bookingData(){
//        Log.d(TAG, "bookingData: preparing data");

//        mDate.add("08/08/2018");
//        mTime.add("19.00");

//        Add add = new Add("08/08/2018", "19.00");
//        addList.add(add);

//        mDate.add("02/04/2018");
//        mTime.add("13.00");

//        add = new Add(res.getString(2), res.getString(3));
//        addList.add(add);


//        if (res.getCount() == 0){
//            return;
//        }
//
//        StringBuffer buffer = new StringBuffer();
//        while (res.moveToNext()){
////            buffer.append("Id: " + res.getString(0));
//            buffer.append("Date: " + res.getString(1));
//            buffer.append("Time: " + res.getString(2));
//        }

//    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, AddBooking.class);
        startActivity(intent);
    }
}
