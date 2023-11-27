package com.example.bitirme_projesi.data.entity.DTO;

import com.example.bitirme_projesi.data.entity.Yemekler;

import java.util.List;

public class YemeklerCevap {
    private List<Yemekler> yemekler;
    private int success;

    public YemeklerCevap() {
    }

    public YemeklerCevap(List<Yemekler> yemekler, int success) {
        this.yemekler = yemekler;
        this.success = success;
    }

    public List<Yemekler> getYemekler() {
        return yemekler;
    }

    public void setYemekler(List<Yemekler> yemekler) {
        this.yemekler = yemekler;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
