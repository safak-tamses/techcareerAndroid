package com.example.android_with_java.ders2.nesne_tabanli_programlama;

public class ArabaMain {
    public static void main(String[] args) {

        Araba bmw = new Araba();
        bmw.renk = "Mavi";
        bmw.hiz = 100;
        bmw.calisiyorMu = true;

        System.out.println("--------------------------");
        System.out.println("Renk         :" + bmw.renk);
        System.out.println("Hız          :" + bmw.hiz);
        System.out.println("Çalışıyor mu :" + bmw.calisiyorMu);

        Araba sahin = new Araba();
        sahin.renk = "Beyaz";
        sahin.hiz = 0;
        sahin.calisiyorMu = false;

        System.out.println("--------------------------");
        System.out.println("Renk         :" + sahin.renk);
        System.out.println("Hız          :" + sahin.hiz);
        System.out.println("Çalışıyor mu :" + sahin.calisiyorMu);

        bmw.bilgiAl();

        sahin.bilgiAl();

        bmw.durdur();
        bmw.bilgiAl();
        bmw.calistir();
        bmw.bilgiAl();
        bmw.hizlan(15);
        bmw.bilgiAl();
        bmw.yavasla(5);
        bmw.bilgiAl();

        sahin.durdur();
        sahin.bilgiAl();
        sahin.calistir();
        sahin.bilgiAl();
        sahin.hizlan(60);
        sahin.bilgiAl();
        sahin.yavasla(59);
        sahin.bilgiAl();

        Araba megan = new Araba("Lacivert",120,true);
        megan.bilgiAl();
    }
}
