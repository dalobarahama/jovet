package com.example.pengalatdite.jovet.Model;

import com.example.pengalatdite.jovet.R;

import java.util.ArrayList;
import java.util.List;

public class AnimalsData {

    private final List<AnimalsModel> model = new ArrayList<>();

    public void animalsData() {
        model.add(new AnimalsModel("Kucing Persia", "", R.drawable.foto_kucing_persiamedium));
        model.add(new AnimalsModel("Kucing Anggora", "", R.drawable.kucing_persia_asli));
        model.add(new AnimalsModel("Kucing Kampung", "", R.drawable.kucing_persia_asli));
        model.add(new AnimalsModel("Anjing Doberman", "", R.drawable.doberman2));
        model.add(new AnimalsModel("Kucing Retriver", "", R.drawable.retriver));
        model.add(new AnimalsModel("Kucing Shepherd", "", R.drawable.german_shepherd));
    }

    public List<AnimalsModel> getModel() {
        return model;
    }

}
