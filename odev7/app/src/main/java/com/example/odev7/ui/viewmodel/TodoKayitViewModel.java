package com.example.odev7.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.odev7.data.repo.ToDoDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TodoKayitViewModel extends ViewModel{
    public ToDoDaoRepository trepo;
    @Inject
    public TodoKayitViewModel(ToDoDaoRepository trepo){
        this.trepo = trepo;
    }
    public void kaydet(String todo_name){
        trepo.kaydet(todo_name);
    }
}
