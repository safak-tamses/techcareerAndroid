package com.example.bitirme_projesi.data.entity.DTO;

import com.example.bitirme_projesi.data.entity.Sepet;

import java.util.List;

public class SepetCevap {
    private List<Sepet> sepetler;
    private int success;

    public SepetCevap() {
    }

    public SepetCevap(List<Sepet> sepetler, int success) {
        this.sepetler = sepetler;
        this.success = success;
    }

    public List<Sepet> getSepetler() {
        return sepetler;
    }

    public void setSepetler(List<Sepet> sepetler) {
        this.sepetler = sepetler;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
