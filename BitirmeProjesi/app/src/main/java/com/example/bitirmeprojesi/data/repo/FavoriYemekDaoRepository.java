package com.example.bitirmeprojesi.data.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bitirmeprojesi.data.entity.DTO.GcSepet;
import com.example.bitirmeprojesi.data.entity.VeriTabaniYemek;
import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class FavoriYemekDaoRepository {
    public MutableLiveData<List<VeriTabaniYemek>> yemekListesi = new MutableLiveData<>();
    private CollectionReference collectionYemekler;

    public FavoriYemekDaoRepository(CollectionReference collectionYemekler) {
        this.collectionYemekler = collectionYemekler;
    }

    public void sil(String yemek_id){ collectionYemekler.document(yemek_id).delete(); }

    public void favorileriYukle() {
        collectionYemekler.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<VeriTabaniYemek> liste = new ArrayList<>();
                for (DocumentSnapshot d : task.getResult().getDocuments()) {
                    VeriTabaniYemek yemek = d.toObject(VeriTabaniYemek.class);
                    if (yemek != null) {
                        yemek.setYemek_id(d.getId());
                        liste.add(yemek);
                        Log.e("Fav",yemek.getYemek_adi());
                    }
                }
                yemekListesi.setValue(liste);
            } else {

            }
        });
    }

    public boolean kaydet(String yemek_adi, String yemek_resim_adi, int yemek_fiyat) {
        if (!isimBenzersiz(yemek_adi)) {
            Log.e("Fav", "Aynı isimde bir obje zaten var.");
            return false;
        } else {
            VeriTabaniYemek yeniFavori = new VeriTabaniYemek(
                    "",
                    yemek_adi,
                    yemek_resim_adi,
                    yemek_fiyat
            );

            collectionYemekler.document().set(yeniFavori)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            favorileriYukle();
                            Log.e("Fav", "Kayıt başarıyla tamamlandı.");

                        } else {
                            Log.e("Fav", "Kayıt sırasında bir hata oluştu: " + task.getException());
                        }
                    });
            return true;
        }
    }



    private boolean isimBenzersiz(String yeniIsim) {
        favorileriYukle();
        List<VeriTabaniYemek> liste = yemekListesi.getValue();
        if (liste != null) {
            for (VeriTabaniYemek yemek : liste) {
                if (yeniIsim.equals(yemek.getYemek_adi())) {
                    return false;
                }
            }
        }
        return true;

    }


}
