package com.example.mvvmkullanimi;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    public MutableLiveData<String> sonuc = new MutableLiveData<>("0");
    public MatematikRepository mRepo = new MatematikRepository();

    public MainActivityViewModel() {
        this.sonuc = mRepo.sonuc;
    }

    public void topla(String alinanSayi1, String alinanSayi2) {
        mRepo.topla(alinanSayi1,alinanSayi2);
    }

    public void carpma(String alinanSayi1, String alinanSayi2) {
        mRepo.carpma(alinanSayi1,alinanSayi2);
    }
}
