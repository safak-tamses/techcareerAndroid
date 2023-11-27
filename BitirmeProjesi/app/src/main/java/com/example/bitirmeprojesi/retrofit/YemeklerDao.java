package com.example.bitirmeprojesi.retrofit;

import com.example.bitirmeprojesi.data.entity.DTO.YemeklerCevap;

import retrofit2.Call;
import retrofit2.http.GET;

public interface YemeklerDao {
    @GET("yemekler/tumYemekleriGetir.php")
    Call<YemeklerCevap> yemekleriGetir();

}
