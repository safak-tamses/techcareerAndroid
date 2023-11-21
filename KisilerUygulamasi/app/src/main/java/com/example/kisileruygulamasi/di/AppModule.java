package com.example.kisileruygulamasi.di;

import android.content.Context;

import androidx.room.Room;

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;
import com.example.kisileruygulamasi.data.room.KisilerDao;
import com.example.kisileruygulamasi.data.room.Veritabanı;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisilerDaoRepository provideKisilerDaoRepository(KisilerDao kisilerDao){
        return new KisilerDaoRepository(kisilerDao);
    }
    @Provides
    @Singleton
    public KisilerDao provideKisilerDao(@ApplicationContext Context context){
        Veritabanı vt = Room.databaseBuilder(context, Veritabanı.class, "rehber.sqlite")
                .createFromAsset("rehber.sqlite")
                .build();
        return vt.getKisilerDao();
    }
}
