package com.example.bitirme_projesi.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bitirme_projesi.data.entity.Sepet;
import com.example.bitirme_projesi.data.repo.SepetDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SepetViewModel extends ViewModel {
    private SepetDaoRepository srepo;
    private MutableLiveData<List<Sepet>> sepetListesi;

    @Inject
    public SepetViewModel(SepetDaoRepository srepo){
        this.srepo = srepo;
        sepetListesi = srepo.sepetListesi;
    }

    public void sepettekiUrunleriYukle(){
        srepo.sepettekiYemekleriGetir();
    }

    public MutableLiveData<List<Sepet>> getSepetListesi(){
        return sepetListesi;
    }

    public void sepettenUrunSil(int sepet_yemek_id){
        srepo.sepettenUrunSil(sepet_yemek_id);
    }
}
