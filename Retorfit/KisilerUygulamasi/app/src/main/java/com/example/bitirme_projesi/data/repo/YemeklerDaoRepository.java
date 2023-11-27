package com.example.bitirme_projesi.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.bitirme_projesi.data.entity.Yemekler;
import com.example.bitirme_projesi.data.entity.DTO.YemeklerCevap;
import com.example.bitirme_projesi.retrofit.YemeklerDao;

import java.util.List;

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
