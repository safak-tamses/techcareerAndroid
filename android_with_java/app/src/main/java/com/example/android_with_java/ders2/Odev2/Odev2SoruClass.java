package com.example.android_with_java.ders2.Odev2;

public class Odev2SoruClass {
    public double soru1(double input) {
        return input * 0.621;
    }

    public int soru2(int deger1, int deger2) {
        return deger1 * deger2;
    }

    public double soru2(double deger1, double deger2) {
        return deger1 * deger2;
    }

    public long soru3(int deger) {
        if (deger < 0) {
            return -1;
        } else if (deger == 0 || deger == 1) {
            return 1;
        } else {
            long factorial = 1;
            for (int i = 2; i <= deger; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }

    public int soru4(String kelime) {
        int count = 0;
        for (int i = 0; i < kelime.length(); i++) {
            if (kelime.charAt(i) == 'e') {
                count++;
            }
        }
        return count;
    }

    public double soru5(int kenarSayisi) {
        return (kenarSayisi - 2) * 180 / kenarSayisi;
    }

    public int soru6(int calisilanGunSayisi) {
        int toplamCalismaSaati = calisilanGunSayisi * 8;
        if (toplamCalismaSaati > 150) {
            int normalUcret = 150 * 40;
            int mesaiUcret = (toplamCalismaSaati - 150) * 80;
            return normalUcret + mesaiUcret;
        } else {
            return toplamCalismaSaati * 40;
        }
    }

    public int soru7(int otoparkSuresi) {
        if (otoparkSuresi == 1) {
            return 50;
        } else {
            return (otoparkSuresi - 1) * 10 + 50;
        }
    }
}
