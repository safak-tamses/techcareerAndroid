package com.example.bitirmeprojesi.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bitirmeprojesi.data.entity.DTO.SepetEkle;
import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.data.repo.SepetDaoRepository;
import com.example.bitirmeprojesi.data.repo.YemeklerDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    private YemeklerDaoRepository yrepo;
    private MutableLiveData<List<Yemekler>> yemeklerListesi;

    private SepetDaoRepository srepo;


    @Inject
    public AnasayfaViewModel(YemeklerDaoRepository yrepo, SepetDaoRepository srepo) {
        this.yrepo = yrepo;
        this.srepo = srepo;
        yemekleriYukle();
        yemeklerListesi = yrepo.yemeklerListesi;
    }

    public void yemekleriYukle() {
        yrepo.yemekleriGetir();
    }

    public void sepeteUrunEkle(SepetEkle sepetEkle){
        srepo.sepeteEkle(sepetEkle);
    }

    public MutableLiveData<List<Yemekler>> getYemeklerListesi() {
        return yemeklerListesi;
    }


}

