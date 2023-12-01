package com.example.bitirmeprojesi.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bitirmeprojesi.data.entity.VeriTabaniYemek;
import com.example.bitirmeprojesi.data.repo.FavoriYemekDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FavoriViewModel extends ViewModel {
    public FavoriYemekDaoRepository frepo;
    public MutableLiveData<List<VeriTabaniYemek>> yemekListesi;
    @Inject
    public FavoriViewModel(FavoriYemekDaoRepository frepo){
        this.frepo = frepo;
        favorileriYukle();
        yemekListesi = frepo.yemekListesi;
    }
    public void silFavori(String yemek_id){ frepo.sil(yemek_id); }

    public void favorileriYukle(){ frepo.favorileriYukle(); }

    public MutableLiveData<List<VeriTabaniYemek>> getFavList(){
        return yemekListesi;
    }
}
