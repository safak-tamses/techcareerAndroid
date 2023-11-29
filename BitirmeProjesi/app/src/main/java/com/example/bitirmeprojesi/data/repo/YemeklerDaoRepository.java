package com.example.bitirmeprojesi.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.bitirmeprojesi.data.entity.DTO.GcSepet;
import com.example.bitirmeprojesi.data.entity.DTO.YemeklerCevap;
import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.retrofit.YemeklerDao;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YemeklerDaoRepository {
    public MutableLiveData<List<Yemekler>> yemeklerListesi = new MutableLiveData<>();

    private YemeklerDao ydao;
    public YemeklerDaoRepository(YemeklerDao ydao){
        this.ydao = ydao;
    }


    public void yemekleriGetir(){
        ydao.yemekleriGetir().enqueue(new Callback<YemeklerCevap>() {
            @Override
            public void onResponse(Call<YemeklerCevap> call, Response<YemeklerCevap> response) {
                List<Yemekler> liste = response.body().getYemekler();
                yemeklerListesi.setValue(liste);
            }

            @Override
            public void onFailure(Call<YemeklerCevap> call, Throwable t) {

            }
        });
    }




}
