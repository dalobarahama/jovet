package com.example.pengalatdite.jovet.Adapter;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pengalatdite.jovet.AddBookingContract;
import com.example.pengalatdite.jovet.R;

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.AddViewHolder> {

    private static final String TAG = "AddRecyclerViewAdapter";
    Context mContext;
    Cursor mCursor;

    public AddAdapter(Context mContext, Cursor cursor) {
//        this.dateList = dateList;
//        this.timeList = timeList;
//        this.mContext = mContext;

//        this.listBooking = listBooking;

        this.mContext = mContext;
        this.mCursor = cursor;

    }

//    public ArrayList<Add> getList() {
//        return (ArrayList<Add>) listBooking;
//    }
//
//    public void setBookingList(ArrayList<Add> bookingList) {
//        this.listBooking = bookingList;
//    }

    @NonNull
    @Override
    public AddViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_history, parent, false);
//        AddViewHolder holder = new AddViewHolder(view);
        return new  AddViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

//        Add add = listBooking.get(position);

//        holder.date.setText(add.getDate());
//        holder.time.setText(add.getTime());

        if (!mCursor.moveToPosition(position)){
            return;
        }

        String date = mCursor.getString(mCursor.getColumnIndex(AddBookingContract.BookingEntry.COLUMN_DATE));
        String time = mCursor.getString(mCursor.getColumnIndex(AddBookingContract.BookingEntry.COLUMN_TIME));

        holder.date.setText(date);
        holder.time.setText(time);
    }

    @Override
    public int getItemCount() {
//        return listBooking.size();
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if (mCursor != null){
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null){
            notifyDataSetChanged();
        }
    }

    public class AddViewHolder extends RecyclerView.ViewHolder {
        TextView date, time;
        ImageButton deleteButton;
//        FrameLayout addListBooking;

        public AddViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.text_view_hari_bulan);
            time = itemView.findViewById(R.id.waktu);
//            addListBooking = itemView.findViewById(R.id.rv_booking_history);

//            deleteButton = (ImageButton) itemView.findViewById(R.id.delete_jadwal_booking);
//            deleteButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    listBooking.remove(getAdapterPosition());
////                    timeList.remove(getAdapterPosition());
//                    notifyItemRemoved(getAdapterPosition());
//                }
//            });
        }
    }
}
