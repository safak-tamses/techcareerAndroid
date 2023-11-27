package com.example.bitirmeprojesi.data.entity.DTO;

import com.example.bitirmeprojesi.data.entity.Sepet;

import java.util.List;

public class SepetCevap {
    private List<GcSepet> sepet_yemekler;
    private int success;

    public SepetCevap() {
    }

    public SepetCevap(List<GcSepet> sepet_yemekler, int success) {
        this.sepet_yemekler = sepet_yemekler;
        this.success = success;
    }

    public List<GcSepet> getSepet_yemekler() {
        return sepet_yemekler;
    }

    public void setSepet_yemekler(List<GcSepet> sepet_yemekler) {
        this.sepet_yemekler = sepet_yemekler;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
