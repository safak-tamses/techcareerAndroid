package com.example.kisileruygulamasi.ui.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    public MutableLiveData<List<Kisiler>> kisilerList ;
    public KisilerDaoRepository kRepo;

    @Inject
    public AnasayfaViewModel(KisilerDaoRepository kRepo) {
        kisileriYukle();
        this.kisilerList = kRepo.kisilerListesi;
        this.kRepo = kRepo;
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
