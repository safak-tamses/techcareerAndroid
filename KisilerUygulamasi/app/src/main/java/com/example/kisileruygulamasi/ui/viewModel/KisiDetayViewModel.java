package com.example.kisileruygulamasi.ui.viewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;

public class KisiDetayViewModel extends ViewModel {
    public KisilerDaoRepository kRepo = new KisilerDaoRepository();

    public void guncelle(int kisi_id, String kisi_ad, String kisi_tel) {
        kRepo.guncelle(kisi_id, kisi_ad, kisi_tel);
    }
}
