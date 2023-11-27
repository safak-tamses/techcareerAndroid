package com.example.bitirme_projesi.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bitirme_projesi.data.entity.Sepet;
import com.example.bitirme_projesi.data.repo.SepetDaoRepository;

import java.util.List;

import javax.inject.Inject;


public class DetayViewModel extends ViewModel {
    private SepetDaoRepository srepo;


    @Inject
    public DetayViewModel(SepetDaoRepository srepo){
        this.srepo = srepo;

    }

    public MutableLiveData<List<Sepet>> getSepetListesi(){
        return null;
    }

}
