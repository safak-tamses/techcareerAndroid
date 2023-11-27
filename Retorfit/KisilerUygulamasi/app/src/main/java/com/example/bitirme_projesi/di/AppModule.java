package com.example.bitirme_projesi.di;

import com.example.bitirme_projesi.data.repo.SepetDaoRepository;
import com.example.bitirme_projesi.data.repo.YemeklerDaoRepository;
import com.example.bitirme_projesi.retrofit.ApiUtils;
import com.example.bitirme_projesi.retrofit.SepetDao;
import com.example.bitirme_projesi.retrofit.YemeklerDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public YemeklerDaoRepository provideKisilerDaoRepository(YemeklerDao ydao){
        return new YemeklerDaoRepository(ydao);
    }

    @Provides
    @Singleton
    public SepetDaoRepository provideSepetDaoRepository(SepetDao sdao){
        return new SepetDaoRepository(sdao);
    }

    @Provides
    @Singleton
    public YemeklerDao provideKisilerDao(){
        return ApiUtils.getYemeklerDao();
    }

    @Provides
    @Singleton
    public SepetDao provideSepetDao() {return ApiUtils.getSepetDao();}
}
