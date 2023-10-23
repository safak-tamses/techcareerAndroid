package com.example.firstlessonscode.ders1.degiskenler;

public class DegiskenOlusturma {
    public static void main(String[] args) {
        String name = "Şafak";
        Integer age = Integer.valueOf(25);
        int ageC = 25;
        Double height = Double.valueOf(1.80);
        double heightD = 1.80;
        String firstCharacterOfNameS = String.valueOf('Ş');
        char firstCharacterOfName = 'Ş';
        Boolean studentIsContinue = true;

        System.out.println("Öğrenci ismi: " + name);
        System.out.println("Öğrenci yaşı: " + age);
        System.out.println(ageC);
        System.out.println(height);
        System.out.println(heightD);
        System.out.println(firstCharacterOfName);
        System.out.println(firstCharacterOfNameS);
        System.out.println(studentIsContinue);

        int urun_id = 1;
        String urun_adi = "Kol saati";
        int urun_adet = 100;
        double urun_fiyat = 149.99;
        String urun_tedarikci = "Rolex";

        System.out.println("Ürün id:        " + urun_id);
        System.out.println("Ürün adı:       " + urun_adi);
        System.out.println("Ürün adet:      " + urun_adet);
        System.out.println("Ürün fiyat:     " + urun_fiyat + " $");
        System.out.println("Ürün tedarikci: " + urun_tedarikci);

        final int numara = 3;
        System.out.println(numara);
        int i = 67;
        double d = 35.98;

        int sonuc1 = (int) d;
        int sonuc2 = i;

        System.out.println(sonuc1);
        System.out.println(sonuc2);

        String sonuc3 = String.valueOf(d);
        String sonuc4 = String.valueOf(i);

        System.out.println(sonuc3);
        System.out.println(sonuc4);

        String yazi1 = "89";
        String yazi2 = "43.81";

        int sonuc5 = Integer.parseInt(yazi1);
        double sonuc6 = Double.parseDouble(yazi2);

        System.out.println(sonuc5);
        System.out.println(sonuc6);
    }
}
