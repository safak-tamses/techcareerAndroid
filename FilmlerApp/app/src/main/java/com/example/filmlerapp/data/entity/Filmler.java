package com.example.filmlerapp.data.entity;

import java.io.Serializable;

public class Filmler implements Serializable {
    private int id;
    private String ad;
    private String resim;
    private int fiyat;


    public Filmler() {
    }

    public Filmler(int id, String ad, String resim, int fiyat) {
        this.id = id;
        this.ad = ad;
        this.resim = resim;
        this.fiyat = fiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}
