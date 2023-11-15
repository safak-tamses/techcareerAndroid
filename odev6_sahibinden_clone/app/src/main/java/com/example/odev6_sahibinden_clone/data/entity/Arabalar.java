package com.example.odev6_sahibinden_clone.data.entity;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;

public class Arabalar implements Serializable {
    private String resim;
    private int fiyat;
    private Date ilanTarih;
    private int ilanNo;
    private String marka;
    private String seri;
    private String model;
    private Date yil;
    private String yakit;
    private String vites;
    private String aracDurumu;
    private int km;
    private String kasaTipi;
    private int motorGucu;
    private int motorHacmi;
    private String cekis;
    private String renk;
    private boolean garanti;
    private boolean agirHasarKaydi;
    private String plakaUyruk;
    private String kimden;
    private boolean goruntuluAramaIleGorulebilir;
    private boolean takas;

    public Arabalar() {
    }

    public Arabalar(String resim, int fiyat, Date ilanTarih, int ilanNo, String marka, String seri, String model, Date yil, String yakit, String vites, String aracDurumu, int km, String kasaTipi, int motorGucu, int motorHacmi, String cekis, String renk, boolean garanti, boolean agirHasarKaydi, String plakaUyruk, String kimden, boolean goruntuluAramaIleGorulebilir, boolean takas) {
        this.resim = resim;
        this.fiyat = fiyat;
        this.ilanTarih = ilanTarih;
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
        this.agirHasarKaydi = agirHasarKaydi;
        this.plakaUyruk = plakaUyruk;
        this.kimden = kimden;
        this.goruntuluAramaIleGorulebilir = goruntuluAramaIleGorulebilir;
        this.takas = takas;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public Date getIlanTarih() {
        return ilanTarih;
    }

    public void setIlanTarih(Date ilanTarih) {
        this.ilanTarih = ilanTarih;
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

    public Date getYil() {
        return yil;
    }

    public void setYil(Date yil) {
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

    public boolean isGaranti() {
        return garanti;
    }

    public void setGaranti(boolean garanti) {
        this.garanti = garanti;
    }

    public boolean isAgirHasarKaydi() {
        return agirHasarKaydi;
    }

    public void setAgirHasarKaydi(boolean agirHasarKaydi) {
        this.agirHasarKaydi = agirHasarKaydi;
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

    public boolean isGoruntuluAramaIleGorulebilir() {
        return goruntuluAramaIleGorulebilir;
    }

    public void setGoruntuluAramaIleGorulebilir(boolean goruntuluAramaIleGorulebilir) {
        this.goruntuluAramaIleGorulebilir = goruntuluAramaIleGorulebilir;
    }

    public boolean isTakas() {
        return takas;
    }

    public void setTakas(boolean takas) {
        this.takas = takas;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }
}
