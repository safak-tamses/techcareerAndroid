package com.example.android_with_java.ders2.nesne_tabanli_programlama;

public class Araba {
    String renk ;
    int hiz ;
    boolean calisiyorMu ;

    public Araba() {
    }

    public Araba(String renk, int hiz, boolean calisiyorMu) {
        this.renk = renk;
        this.hiz = hiz;
        this.calisiyorMu = calisiyorMu;
    }

    public void bilgiAl(){
        System.out.println("--------------------------");
        System.out.println("Renk         :" + renk);
        System.out.println("Hız          :" + hiz);
        System.out.println("Çalışıyor mu :" + calisiyorMu);
    }
    public void calistir(){
        calisiyorMu = true;
        hiz = 5;
    }
    public void durdur(){
        calisiyorMu = false;
        hiz = 0;
    }
    public void hizlan(int miktar){
        hiz = hiz + miktar;
    }
    public void yavasla(int miktar){
        hiz = hiz - miktar;
    }
}

