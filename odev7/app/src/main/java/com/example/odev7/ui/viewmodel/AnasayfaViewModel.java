package com.example.odev7.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.odev7.data.entity.ToDo;
import com.example.odev7.data.repo.ToDoDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    public ToDoDaoRepository trepo;
    public MutableLiveData<List<ToDo>> todoListesi;
    @Inject
    public AnasayfaViewModel(ToDoDaoRepository trepo){
        this.trepo = trepo;
        todoYukle();
        todoListesi = trepo.todoListesi;
    }

    public void ara(String aramaKelimesi){
        trepo.ara(aramaKelimesi);
    }

    public void sil(int kisi_id){
        trepo.sil(kisi_id);
    }

    public void todoYukle(){
        trepo.todoYukle();
    }
}
