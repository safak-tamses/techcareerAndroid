package com.example.android_with_java.ders2.stadart_programlama;

public class IfVeSwichKullanimi {
    public static void main(String[] args) {
        int yas = 19;
        String isim = "Ahmet";
        if (yas >= 18) {
            System.out.println("Reşitsiniz");
        } else {
            System.out.println("Reşit değilsiniz");
        }
        if (isim == "Ahmet") {
            System.out.println("Merhaba Ahmet");
        } else if (isim == "Mehmet") {
            System.out.println("Merhaba Mehmet");
        } else {
            System.out.println("Tanınmayan kişi");
        }

        if (isim.equals("Ahmet")) {
            System.out.println("Merhaba Ahmet");
        } else {
            System.out.println("Tanınmayan kişi");
        }

        String ka = "admin";
        int s = 123456;

        if (ka.equals("admin") && s == 123456){
            System.out.println("Hoşgeldiniz");
        } else {
            System.out.println("Hatalı giriş");
        }

        int sayi = 11;
        if (sayi == 9 || sayi == 10){
            System.out.println("Sayi 9 veya 10 dur");
        } else {
            System.out.println("Sayi 9 veya 10 değildir");
        }


        //Switch = Kotlin(When)
        int gun = 4;
        switch (gun){
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşamba");
                break;
            case 4:
                System.out.println("Perşembe");
                break;
            case 5:
                System.out.println("Cuma");
                break;
            case 6:
                System.out.println("Cumartesi");
                break;
            case 7:
                System.out.println("Pazar");
                break;
            default:
                System.out.println("Böyle bir gün yok");
                break;
        }
    }
}
