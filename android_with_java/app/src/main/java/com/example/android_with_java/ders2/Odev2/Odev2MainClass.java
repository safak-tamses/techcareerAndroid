package com.example.android_with_java.ders2.Odev2;

public class Odev2MainClass {
    public static void main(String[] args) {
        Odev2SoruClass c = new Odev2SoruClass();
        System.out.println("Girilen kilometreyi mile çeviren fonksiyon: ");
        System.out.println("Girilen kilometre 340 Sonuc: " + c.soru1(340) + " mil dir");

        System.out.println("--------------------------------------");

        System.out.println("Dikdörtgen hesaplayan fonksiyon hem double olarak hemde int olarak hesaplanabilir");
        System.out.println("İnteger değerlere göre");
        System.out.println("Kenarları 3 ve 7 olan dikdörtgenin alanı: " + c.soru2(3, 7));
        System.out.println("--");
        System.out.println("Double değerlere göre");
        System.out.println("Kenarları 3,7 ve 14,3 olan dikdörtgenin alanı: " + c.soru2(3.7, 14.3));

        System.out.println("--------------------------------------");

        System.out.println("Faktoriel hesaplayan fonksiyon:");
        System.out.println("6 degerinin faktöriyeli: " + c.soru3(6));

        System.out.println("--------------------------------------");

        System.out.println("Parametre olarak girilen sayıdaki e harfinin sayısını hesaplayan fonksion:");
        System.out.println("tencere kelimesinde " + c.soru4("tencere") + " tane e harfi var");

        System.out.println("--------------------------------------");

        System.out.println("Parametre olarak girilen kenar sayısına göre her bir iç açıyı hesaplayıp geri döndüren metod:");
        System.out.println("Kenar sayısı 5 olan bir düzgün beşgenin bir iç açısı: " + c.soru5(5) + " dir.");

        System.out.println("--------------------------------------");

        System.out.println("Parametre olarak girilen gün sayısına göre maaş hesabı yapan ve elde edilen değeri geri döndüren metod:");
        System.out.println("24 gün çalışan bir kişinin maaşı: " + c.soru6(24) + " 'tl dir");

        System.out.println("--------------------------------------");

        System.out.println("Parametre olarak girilen otopark süresine göre otopark ücreti hesaplayarak geri döndüren method:");
        System.out.println("Otoparkta 8 saat kalan bir aracın ödemesi gereken tutar: " + c.soru7(8) + " 'tl dir.");

    }
}
