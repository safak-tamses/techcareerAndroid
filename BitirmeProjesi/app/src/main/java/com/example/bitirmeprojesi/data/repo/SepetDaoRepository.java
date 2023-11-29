package com.example.bitirmeprojesi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bitirmeprojesi.data.entity.DTO.CRUDCevap;
import com.example.bitirmeprojesi.data.entity.DTO.GcSepet;
import com.example.bitirmeprojesi.data.entity.DTO.SepetCevap;
import com.example.bitirmeprojesi.data.entity.DTO.SepetEkle;
import com.example.bitirmeprojesi.retrofit.SepetDao;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SepetDaoRepository {
    public MutableLiveData<List<GcSepet>> sepetListesi = new MutableLiveData<>();
    private SepetDao sdao;

    public SepetDaoRepository(SepetDao sdao) {
        this.sdao = sdao;
    }

    public void sepettekiYemekleriGetir(){
       sdao.sepettekiYemekleriGetir("safak_tamses").enqueue(new Callback<SepetCevap>() {
           @Override
           public void onResponse(Call<SepetCevap> call, Response<SepetCevap> response) {
               List<GcSepet> liste = response.body().getSepet_yemekler();
               if (liste == null){
                   Log.e("Buraneremk","bura niye girdin amk ");
                   sepetListesi.setValue(null);
               } else {
                   Log.e("Buraneremk","bura niye girdin amk noluyor aq");
                   sepetListesi.setValue(liste);
               }


           }

           @Override
           public void onFailure(Call<SepetCevap> call, Throwable t) {
               Log.e("Buraneremk","bura niye girdin mk ");
           }
       });
    }
    public void sepeteEkle(SepetEkle sepetEkle){
        sdao.sepeteEkle(
                sepetEkle.getYemek_adi(),
                sepetEkle.getYemek_resim_adi(),
                sepetEkle.getYemek_fiyat(),
                sepetEkle.getYemek_siparis_adet(),
                "safak_tamses"
        ).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                Log.e("Buraneremk",response.message());
                if (response.isSuccessful()){
                    Log.e("Buraneremk","true");
                }else{
                    Log.e("Buraneremk","false");
                }

            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void sepettenUrunSil(int sepet_yemek_id){
        sdao.sepettenYemekSil(sepet_yemek_id,"safak_tamses")
                .enqueue(new Callback<CRUDCevap>() {
                    @Override
                    public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                        sepettekiYemekleriGetir();
                        if (sepetListesi.getValue().size() == 0){
                            Log.e("Buraneremk","hololo");
                        }
                        sepetListesi.postValue(sepetListesi.getValue());
                    }

                    @Override
                    public void onFailure(Call<CRUDCevap> call, Throwable t) {

                    }
                });

    }


}

