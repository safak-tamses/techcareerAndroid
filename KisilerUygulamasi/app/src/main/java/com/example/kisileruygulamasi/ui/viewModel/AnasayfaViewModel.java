package com.example.kisileruygulamasi.ui.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;

import java.util.List;

public class AnasayfaViewModel extends ViewModel {
    public MutableLiveData<List<Kisiler>> kisilerList ;
    public KisilerDaoRepository kRepo = new KisilerDaoRepository();

    public AnasayfaViewModel() {
        kisileriYukle();
        this.kisilerList = kRepo.kisilerListesi;
    }

    public void ara(String aramaKelimesi) {
        kRepo.ara(aramaKelimesi);
    }

    public void sil(int kisi_id) {
        kRepo.sil(kisi_id);
    }

    public void kisileriYukle(){
        kRepo.kisileriYukle();
    }
}
