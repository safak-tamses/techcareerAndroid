package com.example.kisileruygulamasi.ui.viewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;

public class KisiKayitViewModel extends ViewModel {
    public KisilerDaoRepository kRepo = new KisilerDaoRepository();
    public void kaydet(String kisi_ad, String kisi_tel){
        kRepo.kaydet(kisi_ad,kisi_tel);
    }
}
