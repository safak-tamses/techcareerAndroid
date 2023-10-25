package com.example.android_with_java.ders2.nesne_tabanli_programlama;

public class FonksiyonlarMain {
    public static void main(String[] args) {
        Fonksiyonlar f = new Fonksiyonlar();
        f.selamla1();
        System.out.println("String : " + f.selamla2());
        System.out.println("Return : " + f.selamla3("Ahmet"));
        f.carp(2,4);
        f.carp(2.0,3.4);
        f.carp(3,4,6);
        f.carp(3,4,"Zeynep");
    }
}
