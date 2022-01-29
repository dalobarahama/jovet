package com.example.pengalatdite.jovet.Model;

public class AnimalsModel {

    private String jenisHewan;
    private String deskripsiHewan;
    private int imageId;

    public AnimalsModel(String jenisHewan, String deskripsiHewan, int imageId) {

        this.jenisHewan = jenisHewan;
        this.deskripsiHewan = deskripsiHewan;
        this.imageId = imageId;
    }

    public String getJenisHewan() {
        return jenisHewan;
    }

    public void setJenisHewan(String jenisHewan) {
        this.jenisHewan = jenisHewan;
    }

    public String getDeskripsiHewan() {
        return deskripsiHewan;
    }

    public void setDeskripsiHewan(String deskripsiHewan) {
        this.deskripsiHewan = deskripsiHewan;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
