package com.example.bitirme_projesi.retrofit;

import com.example.bitirme_projesi.data.entity.DTO.YemeklerCevap;

import retrofit2.Call;
import retrofit2.http.GET;

public interface YemeklerDao {
    @GET("yemekler/tumYemekleriGetir.php")
    Call<YemeklerCevap> yemekleriGetir();

}
