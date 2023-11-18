package com.example.hiltkullanimi;

import android.util.Log;

public class Internet {
    Adres adres = new Adres("Kadıköy");
    public void basvuruYap(){
        Log.e("Sonuç",adres.getBilgi()+ "adresine internet başvurusu yapıldı");
    }
}
