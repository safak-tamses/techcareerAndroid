package com.example.navigationcomponentkullanimi;

import java.io.Serializable;

public class Urunler implements Serializable {
    private int id;
    private String ad;

    public Urunler() {
    }

    public Urunler(int id, String ad) {
        this.id = id;
        this.ad = ad;
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
}
