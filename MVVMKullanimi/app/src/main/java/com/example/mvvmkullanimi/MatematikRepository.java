package com.example.mvvmkullanimi;

import androidx.lifecycle.MutableLiveData;

public class MatematikRepository {
    public MutableLiveData<String> sonuc = new MutableLiveData<>("0");

    public void topla(String alinanSayi1, String alinanSayi2) {
        int sayi1 = Integer.parseInt(alinanSayi1);
        int sayi2 = Integer.parseInt(alinanSayi2);

        int toplam = sayi1 + sayi2;
        sonuc.setValue(String.valueOf(toplam));
    }

    public void carpma(String alinanSayi1, String alinanSayi2) {
        int sayi1 = Integer.parseInt(alinanSayi1);
        int sayi2 = Integer.parseInt(alinanSayi2);

        int carpma = sayi1 * sayi2;
        sonuc.setValue(String.valueOf(carpma));
    }
}
