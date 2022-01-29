package com.example.pengalatdite.jovet.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pengalatdite.jovet.Adapter.AnimalsAdapter;
import com.example.pengalatdite.jovet.Model.AnimalsModel;
import com.example.pengalatdite.jovet.R;

import java.util.ArrayList;
import java.util.List;

public class AnimalsFragment extends Fragment {

    private static final String TAG = "AnimalsFragment";

    private Context mContext;
    private List<AnimalsModel> animalsModelList = new ArrayList<>();
    AnimalsAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: started");

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animals, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyler_view);
        adapter = new AnimalsAdapter(animalsModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);

        animalsData();

    }

    private void animalsData() {
        Log.d(TAG, "animalsData: preparing data");

        AnimalsModel animalsModel = new AnimalsModel("Kucing", "Kucing Persia", R.drawable.foto_kucing_persiamedium);
        animalsModelList.add(animalsModel);

        animalsModel = new AnimalsModel("Kucing", "Kucing Anggora", R.drawable.kucing_persia_asli);
        animalsModelList.add(animalsModel);

        animalsModel = new AnimalsModel("Kucing", "Kucing Kampung", R.drawable.kucing_persia_asli);
        animalsModelList.add(animalsModel);

        animalsModel = new AnimalsModel("Anjing", "Anjing Doberman", R.drawable.doberman2);
        animalsModelList.add(animalsModel);

        animalsModel = new AnimalsModel("Anjing", "Anjing Retriver", R.drawable.retriver);
        animalsModelList.add(animalsModel);

        animalsModel = new AnimalsModel("Anjing", "Anjing Shepherd", R.drawable.german_shepherd);
        animalsModelList.add(animalsModel);

        adapter.notifyDataSetChanged();

    }

    public void onAttach(Context mContext) {
        super.onAttach(mContext);
        this.mContext = mContext;
    }
}
