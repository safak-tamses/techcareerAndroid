package com.example.bitirmeprojesi.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bitirmeprojesi.data.entity.DTO.SepetEkle;
import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.data.repo.FavoriYemekDaoRepository;
import com.example.bitirmeprojesi.data.repo.SepetDaoRepository;
import com.example.bitirmeprojesi.data.repo.YemeklerDaoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    private YemeklerDaoRepository yrepo;
    private FavoriYemekDaoRepository frepo;
    private MutableLiveData<List<Yemekler>> yemeklerListesi;
    private MutableLiveData<List<Yemekler>> aramaSonucu = new MutableLiveData<>();

    private SepetDaoRepository srepo;

    @Inject
    public AnasayfaViewModel(YemeklerDaoRepository yrepo, SepetDaoRepository srepo, FavoriYemekDaoRepository frepo) {
        this.yrepo = yrepo;
        this.srepo = srepo;
        this.frepo = frepo;
        yemekleriYukle();
        yemeklerListesi = yrepo.yemeklerListesi;
    }

    public void yemekleriYukle() {
        yrepo.yemekleriGetir();
    }

    public void sepeteUrunEkle(SepetEkle sepetEkle){
        srepo.sepeteEkle(sepetEkle);
    }

    public LiveData<List<Yemekler>> getYemeklerListesi() {
        return yemeklerListesi;
    }

    public void ara(String aramaKelimesi) {
        if (yemeklerListesi.getValue() != null) {
            List<Yemekler> aranmisListe = yemeklerListesi.getValue()
                    .stream()
                    .filter(yemek -> yemek.getYemek_adi().toLowerCase().contains(aramaKelimesi.toLowerCase()))
                    .collect(Collectors.toList());
            if (aranmisListe.isEmpty()){
                List<Yemekler> bosListe = new ArrayList<>();
                aramaSonucu.setValue(bosListe);
                aramaSonucu.postValue(aramaSonucu.getValue());
            }else {
                aramaSonucu.setValue(aranmisListe);
                aramaSonucu.postValue(aramaSonucu.getValue());
                Log.e("Arama",aramaSonucu.getValue().get(0).getYemek_adi());
            }


        }
    }

    public LiveData<List<Yemekler>> getAramaSonucu(){ return aramaSonucu;}

    public void favoriEkle(String adi,String resimAdi, int fiyat){
        frepo.kaydet(adi,resimAdi,fiyat);
    }
}

