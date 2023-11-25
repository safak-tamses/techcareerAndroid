package com.example.kisileruygulamasi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class KisilerDaoRepository {
    public MutableLiveData<List<Kisiler>> kisilerListesi = new MutableLiveData<>();
    private CollectionReference collectionKisiler;
    public KisilerDaoRepository(CollectionReference collectionKisiler){
        this.collectionKisiler = collectionKisiler;
    }

    public void kaydet(String kisi_ad,String kisi_tel){
        Kisiler yeniKisi = new Kisiler("", kisi_ad,kisi_tel);
        collectionKisiler.document().set(yeniKisi);
    }

    public void guncelle(String kisi_id,String kisi_ad,String kisi_tel){
        HashMap<String, Object> guncellenenKisi = new HashMap<>();
        guncellenenKisi.put("kisi_ad",kisi_ad);
        guncellenenKisi.put("kisi_tel",kisi_tel);
        collectionKisiler.document(kisi_id).update(guncellenenKisi);
    }

    public void ara(String aramaKelimesi){
        collectionKisiler.addSnapshotListener((value, error) -> {
            ArrayList<Kisiler> liste = new ArrayList<>();
            for (DocumentSnapshot d : value.getDocuments()){
                Kisiler kisi = d.toObject(Kisiler.class);
                if (kisi != null){
                    if (kisi.getKisi_ad().toLowerCase().contains(aramaKelimesi.toLowerCase())){
                        kisi.setKisi_id(d.getId());
                        liste.add(kisi);
                    }

                }
            }
            kisilerListesi.setValue(liste);
        });
    }

    public void sil(String kisi_id){
        collectionKisiler.document(kisi_id).delete();
    }

    public void kisileriYukle(){
        collectionKisiler.addSnapshotListener((value, error) -> {
            ArrayList<Kisiler> liste = new ArrayList<>();
            for (DocumentSnapshot d : value.getDocuments()){
                Kisiler kisi = d.toObject(Kisiler.class);
                if (kisi != null){
                    kisi.setKisi_id(d.getId());
                    liste.add(kisi);
                }
            }
            kisilerListesi.setValue(liste);
        });
    }
}
