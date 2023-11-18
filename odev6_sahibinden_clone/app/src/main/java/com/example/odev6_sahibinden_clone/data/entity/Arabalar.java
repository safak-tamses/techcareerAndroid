package com.example.odev6_sahibinden_clone.data.entity;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;

public class Arabalar implements Serializable {
    private String resim;
    private String aciklama;
    private String yer;
    private int fiyat;
    private String yayinlayan;
    private String yerDetay;
    private String ilanTarihi;
    private int ilanNo;
    private String marka;
    private String seri;
    private String model;
    private String yil;
    private String yakit;
    private String vites;
    private String aracDurumu;
    private int km;
    private String kasaTipi;
    private int motorGucu;
    private int motorHacmi;
    private String cekis;
    private String renk;
    private String garanti;
    private String agirHasar;
    private String plakaUyruk;
    private String kimden;
    private String goruntuluArama;
    private String takas;

    public Arabalar() {
    }

    public Arabalar(String resim, String aciklama, String yer, int fiyat, String yayinlayan, String yerDetay, String ilanTarihi, int ilanNo, String marka, String seri, String model, String yil, String yakit, String vites, String aracDurumu, int km, String kasaTipi, int motorGucu, int motorHacmi, String cekis, String renk, String garanti, String agirHasar, String plakaUyruk, String kimden, String goruntuluArama, String takas) {
        this.resim = resim;
        this.aciklama = aciklama;
        this.yer = yer;
        this.fiyat = fiyat;
        this.yayinlayan = yayinlayan;
        this.yerDetay = yerDetay;
        this.ilanTarihi = ilanTarihi;
        this.ilanNo = ilanNo;
        this.marka = marka;
        this.seri = seri;
        this.model = model;
        this.yil = yil;
        this.yakit = yakit;
        this.vites = vites;
        this.aracDurumu = aracDurumu;
        this.km = km;
        this.kasaTipi = kasaTipi;
        this.motorGucu = motorGucu;
        this.motorHacmi = motorHacmi;
        this.cekis = cekis;
        this.renk = renk;
        this.garanti = garanti;
        this.agirHasar = agirHasar;
        this.plakaUyruk = plakaUyruk;
        this.kimden = kimden;
        this.goruntuluArama = goruntuluArama;
        this.takas = takas;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getYer() {
        return yer;
    }

    public void setYer(String yer) {
        this.yer = yer;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getYayinlayan() {
        return yayinlayan;
    }

    public void setYayinlayan(String yayinlayan) {
        this.yayinlayan = yayinlayan;
    }

    public String getYerDetay() {
        return yerDetay;
    }

    public void setYerDetay(String yerDetay) {
        this.yerDetay = yerDetay;
    }

    public String getIlanTarihi() {
        return ilanTarihi;
    }

    public void setIlanTarihi(String ilanTarihi) {
        this.ilanTarihi = ilanTarihi;
    }

    public int getIlanNo() {
        return ilanNo;
    }

    public void setIlanNo(int ilanNo) {
        this.ilanNo = ilanNo;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public String getYakit() {
        return yakit;
    }

    public void setYakit(String yakit) {
        this.yakit = yakit;
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public String getAracDurumu() {
        return aracDurumu;
    }

    public void setAracDurumu(String aracDurumu) {
        this.aracDurumu = aracDurumu;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getKasaTipi() {
        return kasaTipi;
    }

    public void setKasaTipi(String kasaTipi) {
        this.kasaTipi = kasaTipi;
    }

    public int getMotorGucu() {
        return motorGucu;
    }

    public void setMotorGucu(int motorGucu) {
        this.motorGucu = motorGucu;
    }

    public int getMotorHacmi() {
        return motorHacmi;
    }

    public void setMotorHacmi(int motorHacmi) {
        this.motorHacmi = motorHacmi;
    }

    public String getCekis() {
        return cekis;
    }

    public void setCekis(String cekis) {
        this.cekis = cekis;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getGaranti() {
        return garanti;
    }

    public void setGaranti(String garanti) {
        this.garanti = garanti;
    }

    public String getAgirHasar() {
        return agirHasar;
    }

    public void setAgirHasar(String agirHasar) {
        this.agirHasar = agirHasar;
    }

    public String getPlakaUyruk() {
        return plakaUyruk;
    }

    public void setPlakaUyruk(String plakaUyruk) {
        this.plakaUyruk = plakaUyruk;
    }

    public String getKimden() {
        return kimden;
    }

    public void setKimden(String kimden) {
        this.kimden = kimden;
    }

    public String getGoruntuluArama() {
        return goruntuluArama;
    }

    public void setGoruntuluArama(String goruntuluArama) {
        this.goruntuluArama = goruntuluArama;
    }

    public String getTakas() {
        return takas;
    }

    public void setTakas(String takas) {
        this.takas = takas;
    }
}
