package com.example.pimenvibritania.travelkeun.model;

import org.w3c.dom.Text;

public class Travel {

    private String nPerusahaan;
    private String alamat;
    private int jumlah;
    private String nTravel;
    private String img_url;
    private String desk;

    public Travel(){

    }

    public Travel(String nPerusahaan, String alamat, int jumlah, String nTravel, String img_url, String desk) {
        this.nPerusahaan = nPerusahaan;
        this.alamat = alamat;
        this.jumlah = jumlah;
        this.nTravel = nTravel;
        this.img_url = img_url;
        this.desk = desk;
    }

    public String getDesk() {
        return desk;
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

    public void setDesk(String desk) {
        this.desk = desk;
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
