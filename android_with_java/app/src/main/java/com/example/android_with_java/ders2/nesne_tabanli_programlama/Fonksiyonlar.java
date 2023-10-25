package com.example.android_with_java.ders2.nesne_tabanli_programlama;

public class Fonksiyonlar {
    public void selamla1() {
        String sonuc = "Merhaba";
        System.out.println(sonuc);
    }

    public String selamla2() {
        String sonuc = "Merhaba";
        return sonuc;
    }

    public String selamla3(String veri) {
        return "Merhaba" + veri;
    }

    public void carp(int sayi1, int sayi2) {
        System.out.println("Çarpma : " + (sayi1 * sayi2));
    }
    public void carp(double sayi1, double sayi2) {
        System.out.println("Çarpma : " + (sayi1 * sayi2));
    }
    public void carp(int sayi1, int sayi2, int sayi3) {
        System.out.println("Çarpma : " + (sayi1 * sayi2 * sayi3));
    }
    public void carp(int sayi1, int sayi2, String yazi) {
        System.out.println("Çarpma sonucu : " + (sayi1 * sayi2) + " İslem yapan: " + yazi);
    }

}
