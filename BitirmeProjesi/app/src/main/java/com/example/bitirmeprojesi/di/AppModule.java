package com.example.bitirmeprojesi.di;

import com.example.bitirmeprojesi.data.repo.SepetDaoRepository;
import com.example.bitirmeprojesi.data.repo.YemeklerDaoRepository;
import com.example.bitirmeprojesi.retrofit.ApiUtils;
import com.example.bitirmeprojesi.retrofit.SepetDao;
import com.example.bitirmeprojesi.retrofit.YemeklerDao;

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