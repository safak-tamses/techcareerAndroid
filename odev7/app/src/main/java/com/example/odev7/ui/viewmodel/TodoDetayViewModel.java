package com.example.odev7.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.odev7.data.repo.ToDoDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TodoDetayViewModel extends ViewModel {
    public ToDoDaoRepository trepo;
    @Inject
    public TodoDetayViewModel(ToDoDaoRepository trepo){
        this.trepo = trepo;
    }
    public void guncelle(int todo_id, String todo_name){
        trepo.guncelle(todo_id,todo_name);
    }
}
