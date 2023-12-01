package com.example.bitirmeprojesi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bitirmeprojesi.data.entity.DTO.CRUDCevap;
import com.example.bitirmeprojesi.data.entity.DTO.GcSepet;
import com.example.bitirmeprojesi.data.entity.DTO.SepetCevap;
import com.example.bitirmeprojesi.data.entity.DTO.SepetEkle;
import com.example.bitirmeprojesi.retrofit.SepetDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SepetDaoRepository {
    public MutableLiveData<List<GcSepet>> sepetListesi = new MutableLiveData<>();
    public MutableLiveData<Map<String,List<String>>> sepetListesiBirlestirilmis = new MutableLiveData<>();
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
                   sepetListesi.setValue(null);
               } else {
                   sepetListesi.setValue(liste);
                   Map<String , GcSepet> urunAdiSepetMap = new LinkedHashMap<>();
                   Map<String,List<String>> urunAdiUrunIdMap = new LinkedHashMap<>();
                   for (GcSepet gc : liste) {
                       if (!urunAdiSepetMap.containsKey(gc.getYemek_adi())) {
                           urunAdiSepetMap.put(gc.getYemek_adi(), gc);
                           List<String> idList = new ArrayList<>();
                           idList.add(gc.getSepet_yemek_id());
                           urunAdiUrunIdMap.put(gc.getYemek_adi(), idList);
                       } else {
                           if (!urunAdiUrunIdMap.containsKey(gc.getYemek_adi())) {
                               urunAdiUrunIdMap.put(gc.getYemek_adi(), new ArrayList<>());
                           }

                           GcSepet g = urunAdiSepetMap.get(gc.getYemek_adi());
                           int yeniSiparis = Integer.parseInt(g.getYemek_siparis_adet()) +Integer.parseInt(gc.getYemek_siparis_adet());

                           g.setYemek_siparis_adet(String.valueOf(yeniSiparis));
                           urunAdiSepetMap.put(g.getYemek_adi(), g);
                           urunAdiUrunIdMap.get(g.getYemek_adi()).add(gc.getSepet_yemek_id());
                           urunAdiUrunIdMap.get(g.getYemek_adi()).forEach(
                                  e->{
                                      Log.e("Tt",e);
                                  }
                           );
                       }
                   }
                   sepetListesiBirlestirilmis.setValue(urunAdiUrunIdMap);
                   sepetListesi.setValue(urunAdiSepetMap.values().stream().collect(Collectors.toList()));

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

    public void sepettenUrunSil(String sepet_yemek_adi){
        List<String> idList = sepetListesiBirlestirilmis.getValue().get(sepet_yemek_adi);
        idList.forEach(

                e -> {
                    Log.e("Tt",e);
                    sdao.sepettenYemekSil(Integer.parseInt(e),"safak_tamses")
                            .enqueue(new Callback<CRUDCevap>() {
                                @Override
                                public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                                    if (response.isSuccessful()) {
                                        sepetListesi.postValue(null);
                                        sepettekiYemekleriGetir();
                                    }
                                }

                                @Override
                                public void onFailure(Call<CRUDCevap> call, Throwable t) {

                                }
                            });
                }
        );


    }


}

