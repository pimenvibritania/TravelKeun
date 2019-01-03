package com.example.pimenvibritania.travelkeun.model;

public class Travel {

    private String nPerusahaan;
    private String alamat;
    private int jumlah;
    private String nTravel;
    private String img_url;

    public Travel(){

    }

    public Travel(String nPerusahaan, String alamat, int jumlah, String nTravel, String img_url) {
        this.nPerusahaan = nPerusahaan;
        this.alamat = alamat;
        this.jumlah = jumlah;
        this.nTravel = nTravel;
        this.img_url = img_url;
    }

    public String getnPerusahaan() {
        return nPerusahaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getnTravel() {
        return nTravel;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setnPerusahaan(String nPerusahaan) {
        this.nPerusahaan = nPerusahaan;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setnTravel(String nTravel) {
        this.nTravel = nTravel;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
