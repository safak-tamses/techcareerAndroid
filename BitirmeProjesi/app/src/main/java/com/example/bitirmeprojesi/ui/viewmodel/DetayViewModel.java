package com.example.bitirmeprojesi.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.bitirmeprojesi.data.entity.DTO.SepetEkle;
import com.example.bitirmeprojesi.data.repo.SepetDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DetayViewModel extends ViewModel {
    private SepetDaoRepository srepo;

    @Inject
    public DetayViewModel(SepetDaoRepository srepo){
        this.srepo = srepo;
    }
    public void sepeteUrunEkle(SepetEkle sepetEkle){
        srepo.sepeteEkle(sepetEkle);
    }

}
