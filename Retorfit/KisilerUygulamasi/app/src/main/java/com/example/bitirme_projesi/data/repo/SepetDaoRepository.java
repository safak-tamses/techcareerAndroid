package com.example.bitirme_projesi.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.bitirme_projesi.data.entity.DTO.CRUDCevap;
import com.example.bitirme_projesi.data.entity.DTO.SepetCevap;
import com.example.bitirme_projesi.data.entity.DTO.SepetEkle;
import com.example.bitirme_projesi.data.entity.Sepet;
import com.example.bitirme_projesi.retrofit.SepetDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SepetDaoRepository {
    public MutableLiveData<List<Sepet>> sepetListesi = new MutableLiveData<>();
    private SepetDao sdao;

    public SepetDaoRepository(SepetDao sdao) {
        this.sdao = sdao;
    }

    public void sepettekiYemekleriGetir(){
        sdao.sepettekiYemekleriGetir("safak_tamses").enqueue(new Callback<SepetCevap>() {
            @Override
            public void onResponse(Call<SepetCevap> call, Response<SepetCevap> response) {
                List<Sepet> liste = response.body().getSepetler();
                sepetListesi.setValue(liste);
            }

            @Override
            public void onFailure(Call<SepetCevap> call, Throwable t) {

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
                    }

                    @Override
                    public void onFailure(Call<CRUDCevap> call, Throwable t) {

                    }
                });
    }
}
