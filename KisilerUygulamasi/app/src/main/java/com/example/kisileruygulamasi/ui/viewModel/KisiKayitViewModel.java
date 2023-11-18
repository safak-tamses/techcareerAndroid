package com.example.kisileruygulamasi.ui.viewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
@HiltViewModel
public class KisiKayitViewModel extends ViewModel {
    public KisilerDaoRepository kRepo;

    @Inject
    public KisiKayitViewModel(KisilerDaoRepository kRepo) {
        this.kRepo = kRepo;
    }

    public void kaydet(String kisi_ad, String kisi_tel){
        kRepo.kaydet(kisi_ad,kisi_tel);
    }
}
