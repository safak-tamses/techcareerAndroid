package com.example.bitirmeprojesi.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bitirmeprojesi.data.entity.DTO.GcSepet;
import com.example.bitirmeprojesi.data.entity.DTO.SepetEkle;
import com.example.bitirmeprojesi.data.repo.SepetDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SepetViewModel extends ViewModel {
    private SepetDaoRepository srepo;
    public MutableLiveData<List<GcSepet>> sepetListesi;
    @Inject
    public SepetViewModel(SepetDaoRepository srepo){
        this.srepo = srepo;
        sepetiYukle();
        sepetListesi = srepo.sepetListesi;
    }
    public void sepetiYukle(){
        srepo.sepettekiYemekleriGetir();
    }
    public void sepetiSil(int id){
        srepo.sepettenUrunSil(id);
        sepetiYukle();
    }
    public MutableLiveData<List<GcSepet>> getSepetListesi(){
        return sepetListesi;
    }
}