package com.example.kisileruygulamasi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisileruygulamasi.data.entity.Kisiler;

import java.util.ArrayList;
import java.util.List;

public class KisilerDaoRepository {
    public MutableLiveData<List<Kisiler>> kisilerListesi = new MutableLiveData<>();


    public void kaydet(String kisi_ad, String kisi_tel){
        Log.e("Kişi kaydet ",kisi_ad+" - "+kisi_tel);
    }
    public void guncelle(int kisi_id, String kisi_ad, String kisi_tel){
        Log.e("Kişi güncelle ",kisi_id+" - "+kisi_ad+" - "+kisi_tel);
    }
    public void ara(String aramaKelimesi){
        Log.e("Kişi Ara ",aramaKelimesi);
    }

    public  void sil(int kisi_id){
        Log.e("Kişi Sil", String.valueOf(kisi_id) + " silindi.");
        kisileriYukle();
    }
    public void kisileriYukle(){
        ArrayList<Kisiler> liste = new ArrayList<>();
        liste.add(
                new Kisiler(1, "Ahmet", "1234")
        );
        liste.add(
                new Kisiler(2, "Zeynep", "4321")
        );
        liste.add(
                new Kisiler(3, "Beyza", "1432")
        );
        kisilerListesi.setValue(liste);

    }
}
